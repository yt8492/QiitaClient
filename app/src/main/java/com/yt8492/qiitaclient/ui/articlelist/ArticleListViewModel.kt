package com.yt8492.qiitaclient.ui.articlelist

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArticleListViewModel(
    articleRepository: ArticleRepository,
    query: String?
) : ViewModel() {


    val pagedArticleList = LivePagedListBuilder(
        ArticleDataSourceFactory(query, articleRepository),
        PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(PER_PAGE)
            .setPageSize(PER_PAGE)
            .build()
    ).build()

    fun refresh(): Job = viewModelScope.launch {
        pagedArticleList.value?.dataSource?.invalidate()
    }

    companion object {
        private const val PER_PAGE = 100
    }
}