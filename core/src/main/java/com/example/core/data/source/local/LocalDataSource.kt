package com.example.core.data.source.local

import com.example.core.data.source.local.entity.MovieEntity
import com.example.core.data.source.local.entity.TvShowEntity
import com.example.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getAllMovies(): Flow<List<MovieEntity>> = movieDao.getAllMovies()

    fun findDataMovie(query: String): Flow<List<MovieEntity>> =
        movieDao.findDataMovie(query)

    suspend fun insertMovie(movies: List<MovieEntity>) {
        movieDao.insertMovie(movies)
    }

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateMovie(movie)
    }

    fun getFavoriteMovie(): Flow<List<MovieEntity>> = movieDao.getFavMovies()

    fun getAllTvShows(): Flow<List<TvShowEntity>> = movieDao.getAllTvShow()

    fun findDataTv(query: String): Flow<List<TvShowEntity>> =
        movieDao.findDataTv(query)

    suspend fun insertTvShows(tvShows: List<TvShowEntity>) {
        movieDao.insertTvShow(tvShows)
    }

    fun setFavoriteTv(movie: TvShowEntity, newState: Boolean) {
        movie.favorite = newState
        movieDao.updateTvShow(movie)
    }

    fun getFavoriteTv(): Flow<List<TvShowEntity>> = movieDao.getFavTvShow()

}