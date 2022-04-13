package com.example.core.domain.usecase

import com.example.core.domain.model.Movie
import com.example.core.domain.model.TvShow
import com.example.core.domain.repository.IMovieRepository

class MovieInteractor(private val iMovieRepository: IMovieRepository): MovieUseCase {

    override fun getAllMovies() = iMovieRepository.getAllMovies()

    override fun findDataMovie(query: String) = iMovieRepository.findDataMovie(query)

    override fun getFavoriteMovie() = iMovieRepository.getFavoriteMovie()

    override fun setFavoriteMovie(movie: Movie, state: Boolean) = iMovieRepository.setFavoriteMovie(movie, state)

    override fun getAllTvShow() = iMovieRepository.getAllTvShow()

    override fun findDataTv(query: String) = iMovieRepository.findDataTv(query)

    override fun getFavoriteTvShow() = iMovieRepository.getFavoriteTvShow()

    override fun setFavoriteTvShow(tvShow: TvShow, state: Boolean) = iMovieRepository.setFavoriteTvShow(tvShow, state)
}