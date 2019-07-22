package com.yt8492.qiitaclient.data.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Group(
    @Json(name = "created_at")
    val createdAt: Date,
    val id: Int,
    val name: String,
    @Json(name = "private")
    val isPrivate: Boolean,
    @Json(name = "updated_at")
    val updatedAt: Date,
    @Json(name = "url_name")
    val urlName: String
)