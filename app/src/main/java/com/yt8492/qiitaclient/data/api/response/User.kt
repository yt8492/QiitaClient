package com.yt8492.qiitaclient.data.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class User(
    val id: String,
    @Json(name = "profile_image_url")
    val profileImageUrl: String
)