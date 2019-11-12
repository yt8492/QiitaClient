package com.yt8492.qiitaclient.ui.articlelist

import androidx.paging.DataSource
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel
import kotlinx.coroutines.CoroutineScope

class ArticleDataSourceFactory(
    private val query: String?,
    private val articleRepository: ArticleRepository,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, ArticleBindingModel>() {
    override fun create(): DataSource<Int, ArticleBindingModel> =
        ArticleDataSource(query, articleRepository, scope)
}