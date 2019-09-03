package com.yt8492.qiitaclient.infra.api

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class QiitaApiFactory {

    fun create(): QiitaApi {
        val moshi = MoshiConverterFactory.create(
            Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(moshi)
            .build()
            .create()
    }

    companion object {
        private const val BASE_URL = "https://qiita.com"
    }
}