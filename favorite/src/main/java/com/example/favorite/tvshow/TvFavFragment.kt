package com.example.favorite.tvshow

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.ui.TvShowAdapter
import com.example.favorite.databinding.FragmentTvFavBinding
import com.example.moviecatalogue.detail.DetailMovieActivity
import org.koin.android.viewmodel.ext.android.viewModel

class TvFavFragment : Fragment() {

    private var fragmentTvShowBinding: FragmentTvFavBinding? = null
    private val binding get() = fragmentTvShowBinding!!

    private val viewModel: TvFavViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentTvShowBinding = FragmentTvFavBinding.inflate(inflater, container, false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvShowAdapter = TvShowAdapter()

        tvShowAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA_TVSHOW, selectedData)
            startActivity(intent)
        }

        viewModel.favoriteTvShow.observe(this, { tvShow ->
            tvShowAdapter.setData(tvShow)
            binding.progressBar.visibility = View.GONE
            binding.viewEmpty.root.visibility = if (tvShow.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvFavoriteTvShow) {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            adapter = tvShowAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentTvShowBinding = null
    }


}