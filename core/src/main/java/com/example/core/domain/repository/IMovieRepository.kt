package com.example.core.domain.repository

import com.example.core.data.Resource
import com.example.core.domain.model.Movie
import com.example.core.domain.model.TvShow
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {

    fun getAllMovies(): Flow<Resource<List<Movie>>>
    fun getAllTvShow(): Flow<Resource<List<TvShow>>>
    fun getFavoriteMovie(): Flow<List<Movie>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
    fun getFavoriteTvShow(): Flow<List<TvShow>>
    fun setFavoriteTvShow(tvShow: TvShow, state: Boolean)
    fun findDataTv(query: String): Flow<Resource<List<TvShow>>>
    fun findDataMovie(query: String): Flow<Resource<List<Movie>>>
}