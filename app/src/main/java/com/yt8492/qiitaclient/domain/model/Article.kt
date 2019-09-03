package com.yt8492.qiitaclient.domain.model

data class Article(
    val id: String,
    val title: String,
    val url: String,
    val user: User
)