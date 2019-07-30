package com.yt8492.qiitaclient.data.api.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArticleTag(
    val name: String,
    val versions: List<String>
)