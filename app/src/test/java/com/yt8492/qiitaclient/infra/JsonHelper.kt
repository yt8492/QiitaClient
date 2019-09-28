package com.yt8492.qiitaclient.infra

import com.yt8492.qiitaclient.common.RandomHelper
import com.yt8492.api.infra.api.json.ArticleJson
import com.yt8492.api.infra.api.json.UserJson

object JsonHelper {

    fun articleJson(): ArticleJson =
        ArticleJson(
            renderedBody = RandomHelper.randomString(),
            body = RandomHelper.randomString(),
            commentsCount = RandomHelper.randomInt(),
            createdAt = RandomHelper.randomDate(),
            likesCount = RandomHelper.randomInt(),
            isPrivate = RandomHelper.randomBoolean(),
            reactionsCount = RandomHelper.randomInt(),
            tags = listOf(),
            title = RandomHelper.randomString(),
            updatedAt = RandomHelper.randomDate(),
            url = RandomHelper.randomUrl(),
            user = userJson(),
            coediting = RandomHelper.randomBoolean(),
            group = null,
            id = RandomHelper.randomString(),
            viewCount = null
        )

    fun userJson(): UserJson = UserJson(
        description = null,
        facebookId = null,
        followeesCount = RandomHelper.randomInt(),
        followersCount = RandomHelper.randomInt(),
        githubId = null,
        articleCount = RandomHelper.randomInt(),
        linkedinId = null,
        id = RandomHelper.randomString(),
        location = null,
        name = null,
        organization = null,
        isTeamOnly = RandomHelper.randomBoolean(),
        permanentId = RandomHelper.randomInt(),
        twitterName = null,
        profileImageUrl = RandomHelper.randomUrl(),
        websiteUrl = null
    )
}