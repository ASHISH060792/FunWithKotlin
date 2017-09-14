package com.ashish060792.funwithkotlin.core.repository.github

import com.ashish060792.funwithkotlin.core.interfaces.ApiService

/**
 * Created by Ashish on 9/7/2017.
 */
object GithubRepositoryProvider {

    fun provideSearchRepository(): GithubSearchRepository {
        return GithubSearchRepository(ApiService.create("https://api.github.com/"))
    }
    fun provideLoginRepository(): GithubLoginRepository {
        return GithubLoginRepository(ApiService.create("https://api.github.com/"))
    }

}