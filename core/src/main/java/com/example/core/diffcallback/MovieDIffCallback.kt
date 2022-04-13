package com.example.core.diffcallback

import androidx.recyclerview.widget.DiffUtil
import com.example.core.domain.model.Movie

class MovieDIffCallback (private val mOldMovie: List<Movie>, private val mNewMovie: List<Movie>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return mOldMovie.size
    }

    override fun getNewListSize(): Int {
        return mNewMovie.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return mOldMovie[oldItemPosition].id == mNewMovie[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldMovieContent = mOldMovie[oldItemPosition]
        val newMovieContent = mNewMovie[newItemPosition]
        return oldMovieContent.id == newMovieContent.id

    }
}