package com.yt8492.qiitaclient.ui.articles

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import javax.inject.Inject

class ArticlesViewModelFactory @Inject constructor(
    private val articleRepository: ArticleRepository
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        require(modelClass == ArticlesViewModel::class.java) {
            "Unknown ViewModel Class"
        }
        return ArticlesViewModel(
            articleRepository
        ) as T
    }
}