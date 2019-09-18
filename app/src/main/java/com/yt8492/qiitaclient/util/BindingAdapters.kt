package com.yt8492.qiitaclient.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapters {

    @JvmStatic
    @BindingAdapter("imageUrl")
    fun ImageView.loadImage(url: String?) {
        Picasso.get()
            .load(url)
            .into(this)
    }
}