package com.yt8492.qiitaclient.data.datasource

import androidx.lifecycle.LiveData
import com.yt8492.qiitaclient.data.model.Article

interface ArticleRepository {
    fun getArticles(query: String? = null, page: Int): LiveData<List<Article>>
}