package com.example.moviecatalogue.detail

import androidx.lifecycle.ViewModel
import com.example.core.domain.model.Movie
import com.example.core.domain.model.TvShow
import com.example.core.domain.usecase.MovieUseCase

class DetailMovieViewModel (private val movieUseCase: MovieUseCase) : ViewModel() {
    fun setFavoriteMovie(movie: Movie, newStatus:Boolean) =
        movieUseCase.setFavoriteMovie(movie, newStatus)

    fun setFavoriteTv(tvShow: TvShow, newStatus:Boolean) =
        movieUseCase.setFavoriteTvShow(tvShow, newStatus)
}