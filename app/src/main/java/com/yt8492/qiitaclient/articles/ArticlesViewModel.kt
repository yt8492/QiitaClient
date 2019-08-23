package com.yt8492.qiitaclient.articles

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yt8492.qiitaclient.data.datasource.ArticleDataSource
import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import com.yt8492.qiitaclient.data.model.Article

class ArticlesViewModel (
    private val articleRepository: ArticleRepository
) : ViewModel() {

    fun start(query: String?): LiveData<PagedList<Article>> {
        return LivePagedListBuilder(
            ArticleDataSource.Factory(query, articleRepository),
            PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(PER_PAGE)
                .setPageSize(PER_PAGE)
                .build()
        ).build()
    }

    companion object {
        private const val PER_PAGE = 100
    }
}