package com.yt8492.qiitaclient.infra.api.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class ArticleJson(
    @Json(name = "rendered_body")
    val renderedBody: String,
    val body: String,
    val coediting: Boolean,
    @Json(name = "comments_count")
    val commentsCount: Int,
    @Json(name = "created_at")
    val createdAt: Date,
    val group: GroupJson?,
    val id: String,
    @Json(name = "likes_count")
    val likesCount: Int,
    @Json(name = "private")
    val isPrivate: Boolean,
    @Json(name = "reactions_count")
    val reactionsCount: Int,
    val tags: List<ArticleTagJson>,
    val title: String,
    @Json(name = "updated_at")
    val updatedAt: Date,
    val url: String,
    val user: UserJson,
    @Json(name = "page_views_count")
    val viewCount: Int?
)