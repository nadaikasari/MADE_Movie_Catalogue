package com.example.moviecatalogue.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.core.domain.model.Movie
import com.example.core.domain.model.TvShow
import com.example.moviecatalogue.R
import com.example.moviecatalogue.databinding.ActivityDetailMovieBinding
import org.koin.android.viewmodel.ext.android.viewModel

class DetailMovieActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA_MOVIE = "extra_data_movie"
        const val EXTRA_DATA_TVSHOW = "extra_data_tv_show"
    }

    private val detailMovieViewModel: DetailMovieViewModel by viewModel()
    private lateinit var binding: ActivityDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailMovieBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val detailMovie = intent.getParcelableExtra<Movie>(EXTRA_DATA_MOVIE)
        showDetailMovie(detailMovie)
        val detailTvShow = intent.getParcelableExtra<TvShow>(EXTRA_DATA_TVSHOW)
        showDetailTvShow(detailTvShow)
    }

    private fun showDetailTvShow(detailTvShow: TvShow?) {
        detailTvShow?.let {
            supportActionBar?.title = detailTvShow.original_name
            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500" + detailTvShow.poster_path)
                .apply(
                    RequestOptions.placeholderOf(com.example.core.R.drawable.ic_image)
                        .error(com.example.core.R.drawable.ic_error_image)
                )
                .into(binding.imagePoster)

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500" + detailTvShow.poster_path)
                .into(binding.ivDetailImage)

            binding.textTitle.text = detailTvShow.original_name
            binding.textOverview.text = detailTvShow.overview
            binding.textScore.text = detailTvShow.vote_average.toString()
            binding.textRealiseDate.text = detailTvShow.first_air_date
            binding.textPopularity.text = detailTvShow.popularity.toString()
            binding.textLanguage.text = detailTvShow.original_language
            var statusFavorite = detailTvShow.favorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteTv(detailTvShow, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun showDetailMovie(detailMovie: Movie?) {
        detailMovie?.let {
            supportActionBar?.title = detailMovie.title
            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500" + detailMovie.poster_path)
                .apply(
                    RequestOptions.placeholderOf(com.example.core.R.drawable.ic_image)
                        .error(com.example.core.R.drawable.ic_error_image)
                )
                .into(binding.imagePoster)

            Glide.with(this@DetailMovieActivity)
                .load("https://image.tmdb.org/t/p/w500" + detailMovie.backdrop_path)
                .into(binding.ivDetailImage)

            binding.textTitle.text = detailMovie.title
            binding.textOverview.text = detailMovie.overview
            binding.textScore.text = detailMovie.vote_average.toString()
            binding.textRealiseDate.text = detailMovie.release_date
            binding.textPopularity.text = detailMovie.popularity.toString()
            binding.textLanguage.text = detailMovie.original_language
            var statusFavorite = detailMovie.favorite
            setStatusFavorite(statusFavorite)
            binding.fab.setOnClickListener {
                statusFavorite = !statusFavorite
                detailMovieViewModel.setFavoriteMovie(detailMovie, statusFavorite)
                setStatusFavorite(statusFavorite)
            }
        }
    }

    private fun setStatusFavorite(statusFavorite: Boolean) {
        if (statusFavorite) {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite))
        } else {
            binding.fab.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_favorite_border))
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}