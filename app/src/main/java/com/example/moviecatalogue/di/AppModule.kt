package com.example.moviecatalogue.di

import com.example.core.domain.usecase.MovieInteractor
import com.example.core.domain.usecase.MovieUseCase
import com.example.moviecatalogue.detail.DetailMovieViewModel
import com.example.moviecatalogue.movie.MovieViewModel
import com.example.moviecatalogue.tvshow.TvViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { MovieViewModel(get()) }
    viewModel { TvViewModel(get()) }
    viewModel { DetailMovieViewModel(get()) }
}