package com.example.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListMovieResponse (
    @SerializedName("results")
    val results: List<MovieResponse>
)
