package com.yt8492.qiitaclient.domain.model

import java.util.Date

data class Group(
    val id: Int,
    val name: String,
    val urlName: String,
    val isPrivate: Boolean,
    val createdAt: Date,
    val updatedAt: Date
)