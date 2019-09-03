package com.yt8492.qiitaclient.ui.articles

import androidx.paging.DataSource
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.domain.repository.ArticleRepository

class ArticleDataSourceFactory(
    private val query: String?,
    private val articleRepository: ArticleRepository
) : DataSource.Factory<Int, Article>() {
    override fun create(): DataSource<Int, Article> =
        ArticleDataSource(query, articleRepository)
}