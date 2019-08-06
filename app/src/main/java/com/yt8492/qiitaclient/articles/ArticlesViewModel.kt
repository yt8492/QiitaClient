package com.yt8492.qiitaclient.articles

import androidx.lifecycle.*
import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import com.yt8492.qiitaclient.data.model.Article
import kotlinx.coroutines.launch

class ArticlesViewModel (
    private val articleRepository: ArticleRepository
) : ViewModel() {
    private var query: String? = null
    private var currentPage = 1

    private val _articles = MediatorLiveData<List<Article>>()
    val articles: LiveData<List<Article>>
        get() = _articles

    private val _dataLoading = MutableLiveData<Boolean>()
    val dataLoading: LiveData<Boolean>
        get() = _dataLoading

    fun start(query: String?) {
        _dataLoading.value = true
        this.query = query
        viewModelScope.launch {
            val articles = articleRepository.getArticles(query, currentPage)
            _articles.value = articles
            _dataLoading.value = false
        }
    }

    fun loadNextPage() {
        if (_dataLoading.value == false) {
            val currentArticles = _articles.value ?: emptyList()
            _dataLoading.value = true
            viewModelScope.launch {
                val nextArticles = articleRepository.getArticles(query, currentPage + 1)
                _articles.value = currentArticles + nextArticles
                currentPage++
                _dataLoading.value = false
            }
        }
    }
}