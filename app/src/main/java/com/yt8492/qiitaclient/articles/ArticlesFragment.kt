package com.yt8492.qiitaclient.articles

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
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

    private val onArticleClickListener = object : OnArticleClickListener {
        override fun onClick(article: Article?) {
            if (article != null) {
                toast(article.title)
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articles, container, false)
        binding.lifecycleOwner = this
        val articlesAdapter = ArticlesAdapter(requireContext(), onArticleClickListener)
        with(binding.articlesRecyclerView) {
            val layoutManager = LinearLayoutManager(inflater.context)
            val dividerItemDecoration = DividerItemDecoration(inflater.context, layoutManager.orientation)
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
        val context = context ?: return
        val intent = ArticlesActivity.createIntent(context, query)
        startActivity(intent)
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
