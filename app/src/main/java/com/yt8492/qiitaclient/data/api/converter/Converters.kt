package com.yt8492.qiitaclient.data.api.converter

import com.yt8492.qiitaclient.data.api.response.ArticleJson
import com.yt8492.qiitaclient.data.api.response.UserJson
import com.yt8492.qiitaclient.data.model.Article
import com.yt8492.qiitaclient.data.model.User

fun UserJson.toModel(): User =
    User(
        id = this.id,
        profileImageUrl = this.profileImageUrl
    )

fun ArticleJson.toModel(): Article =
    Article(
        id = this.id,
        title = this.title,
        url = this.url,
        user = this.user.toModel()
    )