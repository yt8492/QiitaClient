package com.yt8492.qiitaclient.data.api.service

import com.yt8492.qiitaclient.data.api.response.Article
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaApi {
    @GET("/api/v2/items")
    suspend fun getArticles(
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<Article>
}