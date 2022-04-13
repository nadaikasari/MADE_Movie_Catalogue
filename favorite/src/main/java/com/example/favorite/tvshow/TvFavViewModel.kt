package com.example.favorite.tvshow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.domain.usecase.MovieUseCase

class TvFavViewModel(movieUseCase: MovieUseCase) : ViewModel() {
    val favoriteTvShow = movieUseCase.getFavoriteTvShow().asLiveData()
}