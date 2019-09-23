package com.yt8492.qiitaclient.ui.articlelist

import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel

interface OnArticleClickListener {
    fun onClick(article: ArticleBindingModel?)
}