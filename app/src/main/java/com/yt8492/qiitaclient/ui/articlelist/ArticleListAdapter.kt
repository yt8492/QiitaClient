package com.yt8492.qiitaclient.ui.articlelist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import com.yt8492.qiitaclient.ui.bindingmodel.ArticleBindingModel

class ArticleListAdapter(
    context: Context,
    private val listener: OnArticleClickListener
) : PagedListAdapter<ArticleBindingModel, ArticleListViewHolder>(ITEM_CALLBACK) {

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
        private val ITEM_CALLBACK = object : DiffUtil.ItemCallback<ArticleBindingModel>() {
            override fun areItemsTheSame(
                oldItem: ArticleBindingModel,
                newItem: ArticleBindingModel
            ): Boolean = oldItem.articleUrl == newItem.articleUrl

            override fun areContentsTheSame(
                oldItem: ArticleBindingModel,
                newItem: ArticleBindingModel
            ): Boolean = oldItem == newItem
        }
    }
}