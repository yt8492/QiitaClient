package com.yt8492.qiitaclient.infra.api.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserJson(
    val id: String,
    @Json(name = "profile_image_url")
    val profileImageUrl: String
)