package com.yt8492.qiitaclient.ui.articlelist

import com.google.common.truth.Truth
import com.yt8492.qiitaclient.common.LiveDataSpekHelper
import com.yt8492.qiitaclient.common.ViewModelSpekHelper
import com.yt8492.qiitaclient.domain.DomainHelper
import com.yt8492.qiitaclient.domain.repository.ArticleRepository
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel
import io.mockk.clearMocks
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.gherkin.Feature

@ExperimentalCoroutinesApi
class ArticleListViewModelSpec : Spek({
    ViewModelSpekHelper.setup(this)
    Feature("ArticleListViewModel") {
        val articleRepository by memoized { mockk<ArticleRepository>() }
        val query = "Kotlin"
        val subject by memoized {
            ArticleListViewModel(
                articleRepository,
                query
            )
        }

        Scenario("refreshが呼ばれるとページが更新される") {
            lateinit var firstArticles: List<ArticleBindingModel>
            Given("1回目のArticleRepository#findAllが100個のArticleを返す") {
                coEvery {
                    articleRepository.findAll(
                        query,
                        1,
                        100
                    )
                } returns List(100) {
                    DomainHelper.article()
                }
            }
            Given("ライフサイクルがRESUMEになる") {
                LiveDataSpekHelper.makeLifecycleToResume(subject.pagedArticleList)
            }
            Given("1回目の検索結果の取得") {
                firstArticles = runBlocking {
                    subject.pagedArticleList.value!!.snapshot()
                }
            }
            Given("2回目のArticleRepository#findAllが100個のArticleを返す") {
                clearMocks(articleRepository)
                coEvery {
                    articleRepository.findAll(
                        query,
                        1,
                        100
                    )
                } returns List(100) {
                    DomainHelper.article()
                }
            }
            When("refreshが呼ばれる") {
                coEvery {
                    subject.refresh().join()
                }
            }
            Then("1回目と異なる検索結果が得られる") {
                Truth.assertThat(subject.pagedArticleList.value!!.snapshot()).isNotEqualTo(firstArticles)
            }
        }
    }
})