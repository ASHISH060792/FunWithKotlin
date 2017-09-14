
package com.ashish060792.funwithkotlin.core.repository.github

import com.ashish060792.funwithkotlin.core.interfaces.ApiService
import com.ashish060792.funwithkotlin.core.model.github.User

/**
 * Created by Ashish on 9/7/2017.
 */

class GithubLoginRepository(val apiService: ApiService) {

    fun loginUser(authorization: String): io.reactivex.Observable<User> {
        return apiService.login(authorization)
    }

}