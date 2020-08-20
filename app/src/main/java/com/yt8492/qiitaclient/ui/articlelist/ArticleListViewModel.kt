package com.yt8492.qiitaclient.ui.articlelist

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.liveData
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class ArticleListViewModel(
    articleRepository: ArticleRepository,
    query: String?
) : ViewModel() {

    val pagedArticleFlow = Pager(PagingConfig(pageSize = PER_PAGE, initialLoadSize = PER_PAGE)) {
        ArticlePagingSource(query, articleRepository)
    }.flow

    companion object {
        private const val PER_PAGE = 100
    }
}