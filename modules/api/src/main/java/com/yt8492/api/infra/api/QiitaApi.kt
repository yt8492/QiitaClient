package com.yt8492.api.infra.api

import com.yt8492.api.infra.api.json.ArticleJson
import retrofit2.http.GET
import retrofit2.http.Query

interface QiitaApi {
    @GET("/api/v2/items")
    suspend fun getArticles(
        @Query("query") query: String?,
        @Query("page") page: Int,
        @Query("per_page") perPage: Int
    ): List<ArticleJson>
}