package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    val id: Int?,
    val title: String?,
    val overview: String?,
    val vote_average: Double?,
    val release_date: String?,
    val popularity: Double?,
    val original_language: String?,
    val poster_path: String?,
    val backdrop_path: String?,
    var favorite: Boolean
) : Parcelable