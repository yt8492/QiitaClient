package com.yt8492.qiitaclient.data.datasource

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.yt8492.qiitaclient.data.api.service.QiitaApi
import com.yt8492.qiitaclient.data.model.Article
import com.yt8492.qiitaclient.util.extention.toModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val qiitaApi: QiitaApi
) : ArticleRepository {
    override fun getArticles(query: String?, page: Int): LiveData<List<Article>> {
        val liveData = MutableLiveData<List<Article>>()
        qiitaApi.getArticles(query, page, PER_PAGE)
            .enqueue(object : Callback<List<com.yt8492.qiitaclient.data.api.response.Article>> {
                override fun onResponse(
                    call: Call<List<com.yt8492.qiitaclient.data.api.response.Article>>,
                    response: Response<List<com.yt8492.qiitaclient.data.api.response.Article>>
                ) {
                    val articles = response.body()?.map { it.toModel() }
                    Log.d("hogehoge", "response size: ${articles?.size}")
                    liveData.postValue(articles)
                }

                override fun onFailure(
                    call: Call<List<com.yt8492.qiitaclient.data.api.response.Article>>,
                    t: Throwable
                ) {
                    t.printStackTrace()
                    liveData.postValue(null)
                }

            })
        return liveData
    }

    companion object {
        private const val PER_PAGE = 100
    }
}