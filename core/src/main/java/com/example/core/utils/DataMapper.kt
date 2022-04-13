package com.example.core.utils

import com.example.core.data.source.local.entity.MovieEntity
import com.example.core.data.source.local.entity.TvShowEntity
import com.example.core.data.source.remote.response.MovieResponse
import com.example.core.data.source.remote.response.TvShowResponse
import com.example.core.domain.model.Movie
import com.example.core.domain.model.TvShow

object DataMapper {

    fun mapMovieResponsesToEntities(input: List<MovieResponse>): List<MovieEntity> {
        val movieList = ArrayList<MovieEntity>()

        input.map {
            val movie = MovieEntity(
                id = it.id,
                title = it.title,
                overview = it.overview,
                vote_average = it.vote_average,
                release_date = it.release_date,
                popularity = it.popularity,
                original_language = it.original_language,
                poster_path = it.poster_path,
                backdrop_path = it.backdrop_path,
                favorite = false
            )
            movieList.add(movie)
        }
        return movieList
    }

    fun mapMovieEntitiesToDomain(input: List<MovieEntity>): List<Movie> =
        input.map {
            Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                vote_average = it.vote_average,
                release_date = it.release_date,
                popularity = it.popularity,
                original_language = it.original_language,
                poster_path = it.poster_path,
                backdrop_path = it.backdrop_path,
                favorite = it.favorite
            )
        }

    fun mapMovieDomainToEntity(input: Movie) = MovieEntity(
        id = input.id,
        title = input.title,
        overview = input.overview,
        vote_average = input.vote_average,
        release_date = input.release_date,
        popularity = input.popularity,
        original_language = input.original_language,
        poster_path = input.poster_path,
        backdrop_path = input.backdrop_path,
        favorite = input.favorite
    )

    fun mapTvShowResponsesToEntities(input: List<TvShowResponse>): List<TvShowEntity> {
        val tvShowList = ArrayList<TvShowEntity>()

        input.map {
            val tvShow = TvShowEntity(
                id = it.id,
                original_name = it.original_name,
                overview = it.overview,
                vote_average = it.vote_average,
                first_air_date = it.first_air_date,
                popularity = it.popularity,
                original_language = it.original_language,
                poster_path = it.poster_path,
                favorite = false
            )
            tvShowList.add(tvShow)
        }
        return tvShowList
    }

    fun mapTvShowEntitiesToDomain(input: List<TvShowEntity>): List<TvShow> =
        input.map {
            TvShow(
                id = it.id,
                original_name = it.original_name,
                overview = it.overview,
                vote_average = it.vote_average,
                first_air_date = it.first_air_date,
                popularity = it.popularity,
                original_language = it.original_language,
                poster_path = it.poster_path,
                favorite = it.favorite
            )
        }

    fun mapTvShowDomainToEntity(input: TvShow) = TvShowEntity(
        id = input.id,
        original_name = input.original_name,
        overview = input.overview,
        vote_average = input.vote_average,
        first_air_date = input.first_air_date,
        popularity = input.popularity,
        original_language = input.original_language,
        poster_path = input.poster_path,
        favorite = input.favorite
    )
}