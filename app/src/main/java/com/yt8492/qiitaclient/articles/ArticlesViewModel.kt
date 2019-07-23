package com.yt8492.qiitaclient.articles

import android.app.Application
import androidx.lifecycle.*
import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import com.yt8492.qiitaclient.data.model.Article
import javax.inject.Inject

class ArticlesViewModel (
    private val articleRepository: ArticleRepository
) : ViewModel() {
    private val query: String? = null
    private var currentPage = 1

    private val _articles = MutableLiveData<List<Article>>().apply {
        value = articleRepository.getArticles(query, currentPage).value
    }
    val articles: LiveData<List<Article>>
        get() = _articles

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    fun loadNextPage() {
        val currentArticles = _articles.value ?: return
        currentPage++
        val nextArticles = articleRepository.getArticles(query, currentPage).value ?: return
        _articles.postValue(currentArticles + nextArticles)
    }

    class Factory(private val query: String?,
                  private val articleRepository: ArticleRepository
    ) : ViewModelProvider.NewInstanceFactory() {

        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ArticlesViewModel(articleRepository) as T
        }
    }
}