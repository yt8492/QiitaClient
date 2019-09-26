package com.yt8492.qiitaclient.infra.impl.repository

import com.google.common.truth.Truth
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.api.infra.api.QiitaApi
import com.yt8492.qiitaclient.infra.JsonHelper
import com.yt8492.qiitaclient.infra.impl.domain.repository.ArticleRepositoryImpl
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

class ArticleRepositoryImplSpec : Spek({
    Feature("ArticleRepositoryImpl") {

        val qiitaApi by memoized { mockk<QiitaApi>() }
        val subject by memoized {
            ArticleRepositoryImpl(qiitaApi)
        }

        Scenario("ArticleRepository#getArticlesで3つのArticleが返却される") {
            lateinit var result: List<Article>
            Given("QiitaApi#getArticlesで3つのArticleJsonが返却される") {
                coEvery {
                    qiitaApi.getArticles(
                        null,
                        0,
                        30
                    )
                } returns (1..3).map {
                    JsonHelper.articleJson()
                }
            }
            When("メソッドコール") {
                result = runBlocking {
                    subject.getArticles(
                        null,
                        0,
                        30
                    )
                }
            }
            Then("3つのArticleが返却される") {
                Truth.assertThat(result).hasSize(3)
            }
        }
    }
})