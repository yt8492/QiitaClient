package com.yt8492.qiitaclient

import java.util.*
import kotlin.random.Random

object RandomHelper {

    fun randomInt(): Int = Random.nextInt()

    fun randomLong(): Long = Random.nextLong()

    fun randomBoolean(): Boolean = Random.nextBoolean()

    fun randomString(): String = UUID.randomUUID().toString()

    fun randomUrl(): String = "https://${randomString()}"

    fun randomDate(): Date = Date(randomLong())
}