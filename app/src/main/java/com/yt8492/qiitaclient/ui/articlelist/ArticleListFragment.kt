package com.yt8492.qiitaclient.ui.articlelist

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadState
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yt8492.qiitaclient.R
import com.yt8492.qiitaclient.databinding.FragmentArticleListBinding
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel
import com.yt8492.qiitaclient.util.extention.toast
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.flow.collectLatest
import javax.inject.Inject

class ArticleListFragment : Fragment() {

    @Inject
    lateinit var viewModelFactoryProvider: ArticleListViewModelFactory.Provider

    private val onArticleClickListener = object : OnArticleClickListener {
        override fun onClick(article: ArticleBindingModel?) {
            if (article != null) {
                val tabsIntent = CustomTabsIntent.Builder()
                    .setToolbarColor(requireContext().getColor(R.color.colorPrimary))
                    .setShowTitle(true)
                    .build()
                tabsIntent.launchUrl(requireContext(), article.articleUrl.toUri())
            }
        }
    }

    @ExperimentalPagingApi
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val query = arguments?.getString(KEY_QUERY)
        val binding = FragmentArticleListBinding.inflate(
            inflater,
            container,
            false
        )
        val viewModel = ViewModelProvider(
            this,
            viewModelFactoryProvider.provide(query)
        ).get<ArticleListViewModel>()
        binding.lifecycleOwner = viewLifecycleOwner
        val articlesAdapter = ArticlePagingDataAdapter(
            inflater.context,
            onArticleClickListener
        )
        with(binding.articlesRecyclerView) {
            val layoutManager = LinearLayoutManager(inflater.context)
            val dividerItemDecoration =
                DividerItemDecoration(inflater.context, layoutManager.orientation)
            addItemDecoration(dividerItemDecoration)
            adapter = articlesAdapter
        }
        binding.articlesSwipeView.setOnRefreshListener {
            articlesAdapter.refresh()
        }
        lifecycleScope.launchWhenStarted {
            articlesAdapter.dataRefreshFlow.collectLatest {
                binding.articlesSwipeView.isRefreshing = it
            }
        }
        lifecycleScope.launchWhenStarted {
            articlesAdapter.loadStateFlow.collectLatest {
                val refresh = it.refresh
                if (refresh is LoadState.Error) {
                    toast(refresh.error.message ?: "error")
                }
                val append = it.append
                if (append is LoadState.Error) {
                    toast(append.error.message ?: "error")
                }
            }
        }
        lifecycleScope.launchWhenStarted {
            viewModel.pagedArticleFlow.collectLatest {
                articlesAdapter.submitData(it)
            }
        }
        return binding.root
    }

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu, menu)
        val menuItem = menu.findItem(R.id.toolbarSearch)
        val searchView = menuItem.actionView as SearchView
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                search(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    private fun search(query: String?) {
        val context = requireContext()
        val intent = ArticleListActivity.createIntent(
            context,
            query
        )
        startActivity(intent)
    }

    companion object {
        private const val KEY_QUERY = "QUERY"

        @JvmStatic
        fun newInstance(query: String?) = ArticleListFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_QUERY, query)
            }
        }

    }
}
