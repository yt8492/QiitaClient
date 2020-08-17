package com.yt8492.qiitaclient.ui.articlelist

import androidx.paging.PagingSource
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel
import com.yt8492.qiitaclient.ui.converter.toBindingModel

class ArticlePagingSource(
    private val query: String?,
    private val articleRepository: ArticleRepository
) : PagingSource<Int, ArticleBindingModel>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, ArticleBindingModel> {
        return try {
            val page = params.key ?: 1
            val articles = articleRepository.findAll(
                query,
                page,
                params.loadSize
            ).map(Article::toBindingModel)
            LoadResult.Page(
                articles,
                null,
                page + 1
            )
        } catch (e: Exception) {
            LoadResult.Error(e)
        }
    }
}
