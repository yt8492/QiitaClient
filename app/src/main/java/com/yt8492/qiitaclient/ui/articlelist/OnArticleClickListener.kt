package com.yt8492.qiitaclient.ui.articlelist

import com.yt8492.qiitaclient.domain.model.Article

interface OnArticleClickListener {
    fun onClick(article: Article?)
}