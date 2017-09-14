package com.ashish060792.funwithkotlin.core.repository.github

import com.ashish060792.funwithkotlin.core.interfaces.ApiService
import com.ashish060792.funwithkotlin.core.model.github.Result


/**
 * Created by Ashish on 9/7/2017.
 */

class GithubSearchRepository(val apiService: ApiService) {

    fun searchUsers(query: String): io.reactivex.Observable<Result> {
        return apiService.search(query)
    }

}