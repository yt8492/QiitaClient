package com.yt8492.qiitaclient.ui.articlelist

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.yt8492.qiitaclient.domain.repository.ArticleRepository

class ArticleListViewModel(
    articleRepository: ArticleRepository,
    query: String?
) : ViewModel() {

    val pagedArticleFlow = Pager(PagingConfig(pageSize = PER_PAGE, initialLoadSize = PER_PAGE)) {
        ArticlePagingSource(query, articleRepository)
    }.flow.cachedIn(viewModelScope)

    companion object {
        private const val PER_PAGE = 100
    }
}
