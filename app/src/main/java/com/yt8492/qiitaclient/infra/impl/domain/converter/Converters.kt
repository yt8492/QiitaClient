package com.yt8492.qiitaclient.infra.impl.domain.converter

import com.yt8492.qiitaclient.infra.api.json.ArticleJson
import com.yt8492.qiitaclient.infra.api.json.GroupJson
import com.yt8492.qiitaclient.infra.api.json.TagJson
import com.yt8492.qiitaclient.infra.api.json.UserJson

fun UserJson.toModel(): com.yt8492.qiitaclient.domain.model.User =
    com.yt8492.qiitaclient.domain.model.User(
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

fun TagJson.toModel(): com.yt8492.qiitaclient.domain.model.Tag =
    com.yt8492.qiitaclient.domain.model.Tag(
        name = this.name,
        iconUrl = this.iconUrl,
        followersCount = this.followersCount,
        itemsCount = this.itemsCount
    )

fun GroupJson.toModel(): com.yt8492.qiitaclient.domain.model.Group =
    com.yt8492.qiitaclient.domain.model.Group(
        id = this.id,
        name = this.name,
        urlName = this.urlName,
        isPrivate = this.isPrivate,
        createdAt = this.createdAt,
        updatedAt = this.updatedAt
    )

fun ArticleJson.toModel(): com.yt8492.qiitaclient.domain.model.Article =
    com.yt8492.qiitaclient.domain.model.Article(
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