package com.example.favorite.movie

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.core.ui.MoviesAdapter
import com.example.favorite.databinding.FragmentMovieFavBinding
import com.example.moviecatalogue.detail.DetailMovieActivity
import org.koin.android.viewmodel.ext.android.viewModel


class MovieFavFragment : Fragment() {

    private var fragmentFavMovieBinding: FragmentMovieFavBinding? = null
    private val binding get() = fragmentFavMovieBinding!!

    private val viewModel: MovieFavViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentFavMovieBinding = FragmentMovieFavBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val moviesAdapter = MoviesAdapter()

        moviesAdapter.onItemClick = { selectedData ->
            val intent = Intent(activity, DetailMovieActivity::class.java)
            intent.putExtra(DetailMovieActivity.EXTRA_DATA_MOVIE, selectedData)
            startActivity(intent)
        }

        viewModel.favoriteMovie.observe(this, { movie ->
            moviesAdapter.setData(movie)
            binding.progressBar.visibility = View.GONE
            binding.viewEmpty.root.visibility = if (movie.isNotEmpty()) View.GONE else View.VISIBLE
        })

        with(binding.rvFavoriteMovies) {
            layoutManager = GridLayoutManager(context, 3)
            setHasFixedSize(true)
            adapter = moviesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        fragmentFavMovieBinding = null
    }
}