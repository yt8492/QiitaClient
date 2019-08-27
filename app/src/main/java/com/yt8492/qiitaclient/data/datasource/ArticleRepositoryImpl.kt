package com.yt8492.qiitaclient.data.datasource

import com.yt8492.qiitaclient.data.api.service.QiitaApi
import com.yt8492.qiitaclient.data.model.Article
import com.yt8492.qiitaclient.data.api.converter.toModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val qiitaApi: QiitaApi
) : ArticleRepository {
    override suspend fun getArticles(query: String?, page: Int, perPage: Int): List<Article> =
        withContext(Dispatchers.IO) {
            qiitaApi.getArticles(query, page, perPage)
                .map { it.toModel() }
        }
}