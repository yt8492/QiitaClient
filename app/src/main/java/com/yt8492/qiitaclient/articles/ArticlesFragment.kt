package com.yt8492.qiitaclient.articles

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.yt8492.qiitaclient.R
import com.yt8492.qiitaclient.data.model.Article
import com.yt8492.qiitaclient.databinding.FragmentArticlesBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ArticlesFragment : Fragment() {

    private lateinit var binding: FragmentArticlesBinding
    private lateinit var viewModel: ArticlesViewModel

    @Inject
    internal lateinit var viewModelFactory: ArticlesViewModelFactory

    private val onArticleClickListener = object : ArticlesRecyclerViewAdapter.OnArticleClickListener {
        override fun onClick(article: Article) {

        }
    }
    private val articlesAdapter = ArticlesRecyclerViewAdapter(onArticleClickListener)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProviders.of(
            this,
            viewModelFactory)
            .get(ArticlesViewModel::class.java)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articles, container, false)
        binding.articlesRecyclerView.adapter = articlesAdapter
        binding.isLoading = true
        // Set the adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ArticlesViewModel) {
        //viewModel.articles
        viewModel.articles.observe(this, Observer { articles ->
            if (articles.isNotEmpty()) {
                binding.isLoading = false
                articlesAdapter.setArticles(articles)
            }
        })
    }

    companion object {
        @JvmStatic
        fun newInstance() = ArticlesFragment()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}
