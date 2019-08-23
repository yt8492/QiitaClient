package com.yt8492.qiitaclient.data.datasource

import com.yt8492.qiitaclient.data.model.Article

interface ArticleRepository {
    suspend fun getArticles(query: String? = null, page: Int, perPage: Int): List<Article>
}