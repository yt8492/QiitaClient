package com.yt8492.qiitaclient.ui.articlelist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yt8492.qiitaclient.domain.model.Article
import com.yt8492.qiitaclient.databinding.ItemArticleBinding

class ArticleListViewHolder(
    private val binding: ItemArticleBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(article: Article?, onArticleClickListener: OnArticleClickListener) {
        binding.article = article
        binding.clickListener = onArticleClickListener
        binding.executePendingBindings()
    }

    companion object {
        fun create(
            inflater: LayoutInflater,
            container: ViewGroup,
            attachToRoot: Boolean
        ) = ArticleListViewHolder(
            ItemArticleBinding.inflate(
                inflater,
                container,
                attachToRoot
            )
        )
    }
}