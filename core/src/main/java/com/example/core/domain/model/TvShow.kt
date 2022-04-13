package com.example.core.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class TvShow(
    val id: Int?,
    val original_name: String?,
    val overview: String?,
    val vote_average: Double?,
    val first_air_date: String?,
    val popularity: Double?,
    val original_language: String?,
    val poster_path: String?,
    var favorite: Boolean
) : Parcelable