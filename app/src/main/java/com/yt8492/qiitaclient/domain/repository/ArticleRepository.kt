package com.yt8492.qiitaclient.domain.repository

import com.yt8492.qiitaclient.domain.model.Article

interface ArticleRepository {
    suspend fun findAll(
        query: String? = null,
        page: Int,
        perPage: Int
    ): List<Article>
}