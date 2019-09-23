package com.yt8492.qiitaclient.ui.converter

import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel

fun Article.toBindingModel(): ArticleBindingModel =
    ArticleBindingModel(
        title = this.title,
        articleUrl = this.url,
        userImageUrl = this.user.profileImageUrl,
        userId = this.user.id
    )