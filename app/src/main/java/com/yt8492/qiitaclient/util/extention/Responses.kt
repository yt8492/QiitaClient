package com.yt8492.qiitaclient.util.extention

import com.yt8492.qiitaclient.data.api.response.Article
import com.yt8492.qiitaclient.data.api.response.User

fun User.toModel(): com.yt8492.qiitaclient.data.model.User =
    com.yt8492.qiitaclient.data.model.User(
        id = this.id,
        profileImageUrl = this.profileImageUrl
    )

fun Article.toModel(): com.yt8492.qiitaclient.data.model.Article =
    com.yt8492.qiitaclient.data.model.Article(
        id = this.id,
        title = this.title,
        url = this.url,
        user = this.user.toModel()
    )