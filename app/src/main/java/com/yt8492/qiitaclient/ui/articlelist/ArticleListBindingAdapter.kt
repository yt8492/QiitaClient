package com.yt8492.qiitaclient.ui.articlelist

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object ArticleListBindingAdapter {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String?) {
        Picasso.get()
            .load(url)
            .fit()
            .into(this)
    }
}