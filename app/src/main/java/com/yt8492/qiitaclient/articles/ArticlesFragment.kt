package com.yt8492.qiitaclient.articles

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yt8492.qiitaclient.R
import com.yt8492.qiitaclient.data.model.Article
import com.yt8492.qiitaclient.databinding.FragmentArticlesBinding
import com.yt8492.qiitaclient.util.extention.toast
import com.yt8492.qiitaclient.util.view.InfiniteScrollListener
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ArticlesFragment : Fragment() {

    private lateinit var binding: FragmentArticlesBinding

    @Inject
    internal lateinit var viewModelFactory: ArticlesViewModelFactory

    private val viewModel: ArticlesViewModel by viewModels { viewModelFactory }

    private val onArticleClickListener = object : ArticlesRecyclerViewAdapter.OnArticleClickListener {
        override fun onClick(article: Article) {
            toast(article.title)
        }
    }
    private val articlesAdapter = ArticlesRecyclerViewAdapter(onArticleClickListener)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articles, container, false)
        binding.lifecycleOwner = this
        with(binding.articlesRecyclerView) {
            val layoutManager = LinearLayoutManager(inflater.context)
            val dividerItemDecoration = DividerItemDecoration(inflater.context, layoutManager.orientation)
            addItemDecoration(dividerItemDecoration)
            adapter = articlesAdapter
            setLayoutManager(layoutManager)
            addOnScrollListener(InfiniteScrollListener(layoutManager) {
                viewModel.loadNextPage()
            })
        }
        binding.viewModel = viewModel
        val query = arguments?.getString(KEY_QUERY)
        viewModel.start(query)
        // Set the adapter
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    companion object {
        private const val KEY_QUERY = "QUERY"

        @JvmStatic
        fun newInstance(query: String?) = ArticlesFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_QUERY, query)
            }
        }

    }
}
