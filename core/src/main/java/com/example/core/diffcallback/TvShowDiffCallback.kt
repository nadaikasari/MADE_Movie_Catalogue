package com.example.core.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.TvShow

class TvShowDiffCallback (private val mOldTvShow: List<TvShow>, private val mNewTvShow: List<TvShow>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldTvShow.size
    }

    override fun getNewListSize(): Int {
        return mNewTvShow.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldTvShow[oldItemPosition].id == mNewTvShow[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldTvContent = mOldTvShow[oldItemPosition]
        val newTvContent = mNewTvShow[newItemPosition]
        return oldTvContent.id == newTvContent.id
    }
}