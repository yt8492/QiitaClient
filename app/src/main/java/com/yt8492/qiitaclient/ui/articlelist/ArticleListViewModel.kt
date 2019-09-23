package com.yt8492.qiitaclient.ui.articlelist

import androidx.lifecycle.*
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArticleListViewModel(
    private val articleRepository: ArticleRepository
) : ViewModel() {

    private val query = MutableLiveData<String?>()

    val pagedArticleList = query.switchMap { query ->
        LivePagedListBuilder(
            ArticleDataSourceFactory(query, articleRepository),
            PagedList.Config.Builder()
                .setEnablePlaceholders(false)
                .setInitialLoadSizeHint(PER_PAGE)
                .setPageSize(PER_PAGE)
                .build()
        ).build()
    }

    fun start(query: String?): Job = viewModelScope.launch {
        this@ArticleListViewModel.query.value = query
    }

    companion object {
        private const val PER_PAGE = 100
    }
}