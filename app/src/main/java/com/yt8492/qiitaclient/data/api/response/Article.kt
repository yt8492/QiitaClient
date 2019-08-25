package com.yt8492.qiitaclient.data.api.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Article(
    val id: String,
    val title: String,
    val url: String,
    val user: User
)