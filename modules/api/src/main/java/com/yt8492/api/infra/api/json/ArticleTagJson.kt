package com.yt8492.api.infra.api.json

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleTagJson(
    val name: String,
    val versions: List<String>
)