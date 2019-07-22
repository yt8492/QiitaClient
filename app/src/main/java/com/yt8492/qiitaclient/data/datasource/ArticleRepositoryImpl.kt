package com.yt8492.qiitaclient.data.datasource

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.map
import com.yt8492.qiitaclient.data.api.service.QiitaApi
import com.yt8492.qiitaclient.data.model.Article
import com.yt8492.qiitaclient.util.extention.toModel
import javax.inject.Inject
import javax.inject.Singleton

class ArticleRepositoryImpl @Inject constructor(
    private val qiitaApi: QiitaApi
) : ArticleRepository {
    override fun getArticles(query: String?, page: Int): LiveData<List<Article>> = liveData {
        emitSource(
            qiitaApi.getArticles(query, page, PER_PAGE)
                .map { articles ->
                    articles.map{ it.toModel() }
                }
        )
    }

    companion object {
        private const val PER_PAGE = 100
    }
}