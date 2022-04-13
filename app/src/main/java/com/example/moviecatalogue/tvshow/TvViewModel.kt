package com.example.moviecatalogue.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.data.Resource
import com.example.core.domain.model.TvShow
import com.example.core.domain.usecase.MovieUseCase

class TvViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    val tvShow = movieUseCase.getAllTvShow().asLiveData()

    fun searchData(query: String): LiveData<Resource<List<TvShow>>> {
        return movieUseCase.findDataTv(query).asLiveData()
    }
}