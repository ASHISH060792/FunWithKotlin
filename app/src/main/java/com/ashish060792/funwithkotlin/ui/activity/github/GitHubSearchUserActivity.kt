package com.ashish060792.funwithkotlin.ui.activity.github
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.SearchView
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.inputmethod.InputMethodManager
import com.ashish060792.funwithkotlin.R
import com.ashish060792.funwithkotlin.core.model.github.GithubUserModel
import com.ashish060792.funwithkotlin.core.repository.github.GithubRepositoryProvider
import com.ashish060792.funwithkotlin.core.repository.github.GithubSearchRepository
import com.ashish060792.funwithkotlin.ui.adapter.github.GithubRecyclerViewAdapter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_github_search.*
import showToast


/**
 * Created by Ashish on 9/7/2017.
 */
class GitHubSearchUserActivity : AppCompatActivity() {
    val repository = GithubRepositoryProvider.provideSearchRepository()
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_github_search)
        setSupportActionBar(toolbar)
        val githubUserModel: GithubUserModel = ViewModelProviders.of(this).get(GithubUserModel::class.java)
        if (githubUserModel.userList == null) {
            searchText.visibility = View.VISIBLE
        } else {
            updateUI(githubUserModel)
        }
        with(searchView) {
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String): Boolean {
                    sendRequest(repository, githubUserModel, query)
                    return false
                }

                override fun onQueryTextChange(newText: String): Boolean {
                    return false
                }
            })
            setOnQueryTextFocusChangeListener({ view, hasFocus ->
                if (hasFocus) {
                    showInputMethod(view.findFocus())
                }
            })
        }
    }

    private fun sendRequest(repository: GithubSearchRepository, githubUserModel: GithubUserModel
                            , query: String) {
        githubUserModel.userList?.clear()
        progress.visibility = View.VISIBLE
        searchText.visibility = View.GONE
        compositeDisposable.add(
                repository.searchUsers(query)
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeOn(Schedulers.io())
                        .subscribe({ result ->
                            githubUserModel.userList = result.items
                            progress.visibility = View.GONE
                            searchView.visibility = View.GONE
                            toolbar.visibility = View.VISIBLE
                            updateUI(githubUserModel)

                        }, { error ->
                            this.showToast(error.localizedMessage)
                            error.printStackTrace()
                        })
        )
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.getItemId()) {
            R.id.action_logout -> {
                startActivity(Intent(this@GitHubSearchUserActivity, LoginActivity::class.java))
                PrefHelper.clearPrefs()
                finish()
                return true
            }
            R.id.action_search -> {
                searchView.visibility = View.VISIBLE
                toolbar.visibility = View.GONE
                searchView.requestFocus()
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun showInputMethod(view: View) {
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(view, 0)
    }
    override fun onDestroy() {
        compositeDisposable.clear()
        super.onDestroy()
    }

    private fun updateUI(githubUserModel: GithubUserModel) {
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = GithubRecyclerViewAdapter(githubUserModel.userList)
    }
}