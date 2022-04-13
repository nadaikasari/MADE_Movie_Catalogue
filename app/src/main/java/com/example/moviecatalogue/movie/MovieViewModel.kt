package com.example.moviecatalogue.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.core.data.Resource
import com.example.core.domain.model.Movie
import com.example.core.domain.usecase.MovieUseCase

class MovieViewModel(private val movieUseCase: MovieUseCase) : ViewModel() {
    val movie = movieUseCase.getAllMovies().asLiveData()

    fun searchData(query: String): LiveData<Resource<List<Movie>>> {
        return movieUseCase.findDataMovie(query).asLiveData()
    }
}