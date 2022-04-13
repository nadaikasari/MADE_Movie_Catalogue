package com.example.core.data.source.remote.network

import com.example.core.data.source.remote.response.ListMovieResponse
import com.example.core.data.source.remote.response.ListTvShowResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    suspend fun getMovies(@Query("api_key") api_key: String) : ListMovieResponse

    @GET("discover/tv")
    suspend fun getTvShows(@Query("api_key") api_key: String) : ListTvShowResponse

    @GET("search/movie")
    suspend fun getSearchDataMovie(@Query("api_key") api_key: String, @Query("query") query: String) : ListMovieResponse

    @GET("search/tv")
    suspend fun getSearchDataTv(@Query("api_key") api_key: String, @Query("query") query: String) : ListTvShowResponse
}