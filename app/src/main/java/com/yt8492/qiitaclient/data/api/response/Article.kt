package com.yt8492.qiitaclient.data.api.response

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class Article(
    @Json(name = "rendered_body")
    val renderedBody: String,
    val body: String,
    val coediting: Boolean,
    @Json(name = "comments_count")
    val commentsCount: Int,
    @Json(name = "created_at")
    val createdAt: Date,
    val group: Group?,
    val id: String,
    @Json(name = "likes_count")
    val likesCount: Int,
    @Json(name = "private")
    val isPrivate: Boolean,
    @Json(name = "reactions_count")
    val reactionsCount: Int,
    val tags: List<ArticleTag>,
    val title: String,
    @Json(name = "updated_at")
    val updatedAt: Date,
    val url: String,
    val user: User,
    @Json(name = "page_views_count")
    val viewCount: Int?
)