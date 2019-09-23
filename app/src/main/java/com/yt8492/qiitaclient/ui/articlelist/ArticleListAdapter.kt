package com.yt8492.qiitaclient.ui.articlelist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.yt8492.qiitaclient.domain.model.Article

class ArticleListAdapter(
    context: Context,
    private val listener: OnArticleClickListener
) : PagedListAdapter<Article, ArticleListViewHolder>(ITEM_CALLBACK) {

    private val inflater = LayoutInflater.from(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleListViewHolder =
        ArticleListViewHolder.create(
            inflater,
            parent,
            false
        )

    override fun onBindViewHolder(holder: ArticleListViewHolder, position: Int) {
        holder.bind(getItem(position), listener)
    }

    companion object {
        private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean = oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean = oldItem == newItem
        }
    }
}