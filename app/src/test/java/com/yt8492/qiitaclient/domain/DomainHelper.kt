package com.yt8492.qiitaclient.domain

import com.yt8492.qiitaclient.common.RandomHelper
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.domain.model.User

object DomainHelper {

    fun article(): Article = Article(
        id = RandomHelper.randomString(),
        title = RandomHelper.randomString(),
        renderedBody = RandomHelper.randomString(),
        body = RandomHelper.randomString(),
        commentsCount = RandomHelper.randomInt(),
        createdAt = RandomHelper.randomDate(),
        likesCount = RandomHelper.randomInt(),
        isPrivate = RandomHelper.randomBoolean(),
        reactionsCount = RandomHelper.randomInt(),
        tags = listOf(),
        updatedAt = RandomHelper.randomDate(),
        url = RandomHelper.randomUrl(),
        coediting = RandomHelper.randomBoolean(),
        group = null,
        viewCount = 0,
        user = user()
    )

    fun user(): User = User(
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
        twitterName = null,
        profileImageUrl = RandomHelper.randomUrl(),
        websiteUrl = null
    )
}