package com.yt8492.api.infra.api.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TagJson(
    @Json(name = "followers_count")
    val followersCount: Int,
    @Json(name = "icon_url")
    val iconUrl: String?,
    @Json(name = "id")
    val name: String,
    @Json(name = "items_count")
    val itemsCount: Int
)