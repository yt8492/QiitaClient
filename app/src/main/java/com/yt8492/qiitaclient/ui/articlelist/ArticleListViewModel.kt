package com.yt8492.qiitaclient.ui.articlelist

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel

class ArticleListViewModel(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    fun start(query: String?): LiveData<PagedList<ArticleBindingModel>> {
        return LivePagedListBuilder(
            ArticleDataSourceFactory(query, articleRepository),
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