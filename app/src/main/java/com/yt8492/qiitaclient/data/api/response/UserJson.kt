package com.yt8492.qiitaclient.data.api.response

import com.squareup.moshi.Json

data class UserJson(
    val id: String,
    @Json(name = "profile_image_url")
    val profileImageUrl: String
)