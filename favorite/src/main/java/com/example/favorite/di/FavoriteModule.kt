package com.example.favorite.di

import com.example.favorite.movie.MovieFavViewModel
import com.example.favorite.tvshow.TvFavViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val favoriteModule = module {
    viewModel {
        MovieFavViewModel(get())
    }
    viewModel {
        TvFavViewModel(get())
    }
}