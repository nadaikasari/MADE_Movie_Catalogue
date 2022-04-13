package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class TvShowResponse(

    @SerializedName("id")
    val id: Int,

    @SerializedName("original_name")
    val original_name: String,

    @SerializedName("overview")
    val overview: String,

    @SerializedName("vote_average")
    val vote_average: Double,

    @SerializedName("first_air_date")
    val first_air_date: String,

    @SerializedName("popularity")
    val popularity: Double,

    @SerializedName("original_language")
    val original_language: String,

    @SerializedName("poster_path")
    val poster_path: String
)