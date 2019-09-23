package com.yt8492.qiitaclient.domain.model

data class User(
    val id: String,
    val name: String?,
    val description: String?,
    val websiteUrl: String?,
    val profileImageUrl: String,
    val twitterName: String?,
    val githubId: String?,
    val facebookId: String?,
    val linkedinId: String?,
    val organization: String?,
    val location: String?,
    val followeesCount: Int,
    val followersCount: Int,
    val articleCount: Int,
    val isTeamOnly: Boolean
)