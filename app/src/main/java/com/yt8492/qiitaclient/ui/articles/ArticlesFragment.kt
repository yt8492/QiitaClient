package com.yt8492.qiitaclient.ui.articles

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yt8492.qiitaclient.R
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.databinding.FragmentArticlesBinding
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ArticlesFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ArticlesViewModelFactory

    private val viewModel: ArticlesViewModel by viewModels { viewModelFactory }

    private val onArticleClickListener = object : OnArticleClickListener {
        override fun onClick(article: Article?) {
            if (article != null) {
                val tabsIntent = CustomTabsIntent.Builder()
                    .setShowTitle(true)
                    .setToolbarColor(requireContext().getColor(R.color.colorPrimary))
                    .build()
                tabsIntent.launchUrl(requireContext(), article.url.toUri())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val binding = FragmentArticlesBinding.inflate(
            inflater,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        val articlesAdapter = ArticlesAdapter(inflater.context, onArticleClickListener)
        with(binding.articlesRecyclerView) {
            val linearLayoutManager = LinearLayoutManager(inflater.context)
            val dividerItemDecoration =
                DividerItemDecoration(inflater.context, linearLayoutManager.orientation)
            addItemDecoration(dividerItemDecoration)
            adapter = articlesAdapter
            layoutManager = linearLayoutManager
        }
        viewModel.pagedArticleList.observe(viewLifecycleOwner, Observer {
            articlesAdapter.submitList(it)
        })
        val query = arguments?.getString(KEY_QUERY)
        viewModel.start(query)
        return binding.root
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
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
        val intent = ArticlesActivity.createIntent(requireContext(), query)
        startActivity(intent)
    }

    companion object {
        private const val KEY_QUERY = "QUERY"

        fun newInstance(query: String?) = ArticlesFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_QUERY, query)
            }
        }
    }
}
