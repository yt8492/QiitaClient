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
            articleRepository.getArticles(query, currentPage).let {
                _articles.addSource(it) {
                    _articles.value = it
                    _dataLoading.value = false
                }
            }
        }
    }

    fun loadNextPage() {
        if (_dataLoading.value == false) {
            val currentArticles = _articles.value ?: emptyList()
            _dataLoading.value = true
            viewModelScope.launch {
                articleRepository.getArticles(query, currentPage + 1).let {
                    _articles.addSource(it) { nextArticles ->
                        _articles.value = currentArticles + nextArticles
                        currentPage++
                        _dataLoading.value = false
                    }
                }
            }
        }
    }
}