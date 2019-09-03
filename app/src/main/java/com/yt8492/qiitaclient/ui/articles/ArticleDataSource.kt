package com.yt8492.qiitaclient.ui.articles

import androidx.paging.PageKeyedDataSource
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArticleDataSource(
    private val query: String?,
    private val articleRepository: ArticleRepository
) : PageKeyedDataSource<Int, Article>() {

    private val dataSourceScope = CoroutineScope(Main + Job())

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, Article>
    ) {
        dataSourceScope.launch {
            val initialArticles = articleRepository
                .getArticles(
                    query = query,
                    page = 1,
                    perPage = params.requestedLoadSize
                )
            callback.onResult(initialArticles, null, 2)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Article>
    ) {
        dataSourceScope.launch {
            val articles = articleRepository
                .getArticles(
                    query = query,
                    page = params.key,
                    perPage = params.requestedLoadSize
                )
            callback.onResult(articles, params.key + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, Article>
    ) {
    }

}