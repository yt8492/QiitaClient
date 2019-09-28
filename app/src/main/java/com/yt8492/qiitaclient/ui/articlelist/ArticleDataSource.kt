package com.yt8492.qiitaclient.ui.articlelist

import androidx.paging.PageKeyedDataSource
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel
import com.yt8492.qiitaclient.ui.converter.toBindingModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class ArticleDataSource(
    private val query: String?,
    private val articleRepository: ArticleRepository
) : PageKeyedDataSource<Int, ArticleBindingModel>() {

    private val dataSourceScope = CoroutineScope(Main + Job())

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ArticleBindingModel>
    ) {
        dataSourceScope.launch {
            params.requestedLoadSize
            val initialArticles = articleRepository
                .findAll(
                    query,
                    1,
                    params.requestedLoadSize
                ).map(Article::toBindingModel)
            callback.onResult(initialArticles, null, 2)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, ArticleBindingModel>
    ) {
        dataSourceScope.launch {
            val articles = articleRepository
                .findAll(
                    query,
                    params.key,
                    params.requestedLoadSize
                ).map(Article::toBindingModel)
            callback.onResult(articles, params.key + 1)
        }
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, ArticleBindingModel>
    ) {
    }

}