package com.yt8492.qiitaclient.infra.api.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleJson(
    val id: String,
    val title: String,
    val url: String,
    val user: UserJson
)