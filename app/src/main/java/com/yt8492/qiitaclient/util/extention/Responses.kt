package com.yt8492.qiitaclient.util.extention

import com.yt8492.qiitaclient.data.api.response.Article
import com.yt8492.qiitaclient.data.api.response.Group
import com.yt8492.qiitaclient.data.api.response.Tag
import com.yt8492.qiitaclient.data.api.response.User

fun User.toModel(): com.yt8492.qiitaclient.data.model.User =
    com.yt8492.qiitaclient.data.model.User(
        id = this.id,
        name = this.name,
        description = this.description,
        websiteUrl = this.websiteUrl,
        profileImageUrl = this.profileImageUrl,
        twitterName = this.twitterName,
        githubId = this.githubId,
        facebookId = this.facebookId,
        linkedinId = this.linkedinId,
        organization = this.organization,
        location = this.location,
        followeesCount = this.followeesCount,
        followersCount = this.followersCount,
        articleCount = this.articleCount,
        isTeamOnly = this.isTeamOnly
    )

fun Tag.toModel(): com.yt8492.qiitaclient.data.model.Tag =
    com.yt8492.qiitaclient.data.model.Tag(
        name = this.name,
        iconUrl = this.iconUrl,
        followersCount = this.followersCount,
        itemsCount = this.itemsCount
    )

fun Group.toModel(): com.yt8492.qiitaclient.data.model.Group =
    com.yt8492.qiitaclient.data.model.Group(
        id = this.id,
        name = this.name,
        urlName = this.urlName,
        isPrivate = this.isPrivate,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )

fun Article.toModel(): com.yt8492.qiitaclient.data.model.Article =
    com.yt8492.qiitaclient.data.model.Article(
        id = this.id,
        title = this.title,
        url = this.url,
        body = this.body,
        renderedBody = this.renderedBody,
        user = this.user.toModel(),
        tags = this.tags.map { it.name },
        group = this.group?.toModel(),
        commentsCount = this.commentsCount,
        likesCount = this.likesCount,
        viewCount = this.viewCount ?: 0,
        reactionsCount = this.reactionsCount,
        isPrivate = this.isPrivate,
        coediting = this.coediting,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )