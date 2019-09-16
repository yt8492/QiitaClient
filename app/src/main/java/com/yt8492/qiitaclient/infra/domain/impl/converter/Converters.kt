package com.yt8492.qiitaclient.infra.domain.impl.converter

import com.yt8492.qiitaclient.infra.api.json.ArticleJson
import com.yt8492.qiitaclient.infra.api.json.UserJson
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.domain.model.User

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