package com.yt8492.qiitaclient.util.view

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class InfiniteScrollListener(
    private val layoutManager: LinearLayoutManager,
    private val callback: () -> Unit
) : RecyclerView.OnScrollListener() {
    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        if (dy > 0) {
            val totalItemCount = recyclerView.adapter?.itemCount ?: return
            val childItemCount = recyclerView.childCount
            val firstPosition = layoutManager.findFirstVisibleItemPosition()
            if (totalItemCount == firstPosition + childItemCount) {
                callback()
            }
        }
    }
}