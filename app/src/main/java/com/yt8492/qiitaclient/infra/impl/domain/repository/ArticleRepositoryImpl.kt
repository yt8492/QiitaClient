package com.yt8492.qiitaclient.infra.impl.domain.repository

import com.yt8492.api.infra.api.QiitaApi
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.api.infra.api.json.ArticleJson
import com.yt8492.qiitaclient.infra.impl.domain.converter.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val qiitaApi: QiitaApi
) : ArticleRepository {
    override suspend fun findAll(
        query: String?,
        page: Int,
        perPage: Int
    ): List<Article> = withContext(Dispatchers.IO) {
        qiitaApi.getArticles(query, page, perPage)
            .map(ArticleJson::toModel)
    }
}