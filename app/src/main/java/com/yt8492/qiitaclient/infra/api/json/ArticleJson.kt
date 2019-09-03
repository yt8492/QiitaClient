package com.yt8492.qiitaclient.infra.api.json

data class ArticleJson(
    val id: String,
    val title: String,
    val url: String,
    val user: UserJson
)