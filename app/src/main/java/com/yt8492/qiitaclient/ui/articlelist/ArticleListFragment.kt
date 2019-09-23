package com.yt8492.qiitaclient.ui.articlelist

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.yt8492.qiitaclient.R
import com.yt8492.qiitaclient.databinding.FragmentArticleListBinding
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class ArticleListFragment : Fragment() {

    private lateinit var binding: FragmentArticleListBinding

    @Inject
    internal lateinit var viewModelFactory: ArticleListViewModelFactory

    private val viewModel: ArticleListViewModel by viewModels { viewModelFactory }

    private val onArticleClickListener = object :
        OnArticleClickListener {
        override fun onClick(article: ArticleBindingModel?) {
            if (article != null) {
                val tabsIntent = CustomTabsIntent.Builder()
                    .setShowTitle(true)
                    .build()
                tabsIntent.launchUrl(requireContext(), article.articleUrl.toUri())
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_article_list,
            container,
            false
        )
        binding.lifecycleOwner = viewLifecycleOwner
        val articlesAdapter = ArticleListAdapter(
            requireContext(),
            onArticleClickListener
        )
        with(binding.articlesRecyclerView) {
            val layoutManager = LinearLayoutManager(inflater.context)
            val dividerItemDecoration =
                DividerItemDecoration(inflater.context, layoutManager.orientation)
            addItemDecoration(dividerItemDecoration)
            adapter = articlesAdapter
            setLayoutManager(layoutManager)
        }
        val query = arguments?.getString(KEY_QUERY)
        viewModel.start(query).observe(viewLifecycleOwner, Observer {
            articlesAdapter.submitList(it)
        })
        // Set the adapter
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
