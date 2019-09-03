package com.yt8492.qiitaclient.infra.repository

import com.yt8492.qiitaclient.infra.api.QiitaApi
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.infra.converter.toModel
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val qiitaApi: QiitaApi
) : ArticleRepository {
    override suspend fun getArticles(
        query: String?,
        page: Int,
        perPage: Int
    ): List<Article> = withContext(Dispatchers.IO) {
        qiitaApi.getArticles(query, page, perPage)
            .map { it.toModel() }
    }
}