package com.example.core.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.core.R
import com.example.core.databinding.ItemListMovieBinding
import com.example.core.diffcallback.TvShowDiffCallback
import com.example.core.domain.model.TvShow
import java.util.*

class TvShowAdapter : RecyclerView.Adapter<TvShowAdapter.ListViewHolder>() {
    private var listData = ArrayList<TvShow>()
    var onItemClick: ((TvShow) -> Unit)? = null

    fun setData(newListData: List<TvShow>) {
        val diffCallback = TvShowDiffCallback(this.listData, newListData)
        val diffResult = DiffUtil.calculateDiff(diffCallback)

        listData.clear()
        listData.addAll(newListData)

        diffResult.dispatchUpdatesTo(this)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ListViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false)
        )

    override fun getItemCount() = listData.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val data = listData[position]
        holder.bind(data)
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemListMovieBinding.bind(itemView)
        fun bind(data: TvShow) {
            with(binding) {
                val link = StringBuilder("https://image.tmdb.org/t/p/w500")
                link.append(data.poster_path)
                Glide.with(itemView.context)
                    .load(link.toString())
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_image)
                            .error(R.drawable.ic_error_image)
                    )
                    .into(imgPoster)
            }
        }

        init {
            binding.root.setOnClickListener {
                onItemClick?.invoke(listData[adapterPosition])
            }
        }
    }
}