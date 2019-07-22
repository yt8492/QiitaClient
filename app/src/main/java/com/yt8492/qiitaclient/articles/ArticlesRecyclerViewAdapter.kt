package com.yt8492.qiitaclient.articles

import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DiffUtil
import com.yt8492.qiitaclient.R
import com.yt8492.qiitaclient.data.model.Article
import com.yt8492.qiitaclient.databinding.ItemArticleBinding

class ArticlesRecyclerViewAdapter(
    private val listener: OnArticleClickListener
) : RecyclerView.Adapter<ArticlesRecyclerViewAdapter.ViewHolder>() {

    private var articles: List<Article> = emptyList()

    fun setArticles(articles: List<Article>) {
        val diffResult = DiffUtil.calculateDiff(object : DiffUtil.Callback() {
            override fun getOldListSize(): Int {
                return this@ArticlesRecyclerViewAdapter.articles.size
            }

            override fun getNewListSize(): Int {
                return articles.size
            }

            override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return this@ArticlesRecyclerViewAdapter.articles[oldItemPosition].id == articles[newItemPosition].id
            }

            override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return this@ArticlesRecyclerViewAdapter.articles[oldItemPosition].id == articles[newItemPosition].id
            }
        })
        this.articles = articles
        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DataBindingUtil.inflate<ItemArticleBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_article,
            parent,
            false
        ).apply {
            clickListener = listener
        }
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.article = article
        holder.binding.executePendingBindings()
    }

    override fun getItemCount(): Int = articles.size

    interface OnArticleClickListener {
        fun onClick(article: Article)
    }

    inner class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)
}
