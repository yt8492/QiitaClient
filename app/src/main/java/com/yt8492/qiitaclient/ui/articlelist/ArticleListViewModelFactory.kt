package com.yt8492.qiitaclient.ui.articlelist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticleListViewModelFactory(
    private val articleRepository: ArticleRepository,
    private val query: String?
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == ArticleListViewModel::class.java) {
            "Unknown ViewModel Class"
        }
        return ArticleListViewModel(
            articleRepository,
            query
        ) as T
    }

    class Provider @Inject constructor(
        private val articleRepository: ArticleRepository
    ) {
        fun provide(query: String?): ArticleListViewModelFactory =
            ArticleListViewModelFactory(
                articleRepository,
                query
            )
    }
}