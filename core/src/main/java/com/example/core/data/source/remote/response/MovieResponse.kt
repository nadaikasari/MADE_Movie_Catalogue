package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("title")
    val title: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("vote_average")
    val vote_average: Double,

    @SerializedName("release_date")
    val release_date: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("original_language")
    val original_language: String,

    @SerializedName("poster_path")
    val poster_path: String,

    @SerializedName("backdrop_path")
    val backdrop_path: String
)