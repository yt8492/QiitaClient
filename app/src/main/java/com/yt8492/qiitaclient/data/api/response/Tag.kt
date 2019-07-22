package com.yt8492.qiitaclient.data.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tag(
    @Json(name = "followers_count")
    val followersCount: Int,
    @Json(name = "iconUrl")
    val iconUrl: String?,
    @Json(name = "id")
    val name: String,
    @Json(name = "items_count")
    val itemsCount: Int
)