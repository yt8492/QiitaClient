package com.yt8492.qiitaclient.ui.articles

import com.yt8492.qiitaclient.data.model.Article

interface OnArticleClickListener {
    fun onClick(article: Article?)
}