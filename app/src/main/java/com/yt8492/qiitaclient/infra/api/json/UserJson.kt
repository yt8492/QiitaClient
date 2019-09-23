package com.yt8492.qiitaclient.infra.api.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserJson(
    val description: String?,
    @Json(name = "facebook_id")
    val facebookId: String?,
    @Json(name = "followees_count")
    val followeesCount: Int,
    @Json(name = "followers_count")
    val followersCount: Int,
    @Json(name = "github_login_name")
    val githubId: String?,
    val id: String,
    @Json(name = "items_count")
    val articleCount: Int,
    @Json(name = "linkedin_id")
    val linkedinId: String?,
    val location: String?,
    val name: String?,
    val organization: String?,
    @Json(name = "permanent_id")
    val permanentId: Int,
    @Json(name = "profile_image_url")
    val profileImageUrl: String,
    @Json(name = "team_only")
    val isTeamOnly: Boolean,
    @Json(name = "twitter_screen_name")
    val twitterName: String?,
    @Json(name = "website_url")
    val websiteUrl: String?
)