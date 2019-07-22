package com.yt8492.qiitaclient.di.modlue

import android.app.Application
import com.yt8492.qiitaclient.articles.ArticlesViewModel
import com.yt8492.qiitaclient.data.datasource.ArticleRepository
import dagger.Module
import dagger.Provides

@Module
class ArticlesModule(private val application: Application,
                     private val query: String?) {

    @Provides
    fun provideViewModelFactory(articleRepository: ArticleRepository): ArticlesViewModel.Factory {
        return ArticlesViewModel.Factory(application, query, articleRepository)
    }
}