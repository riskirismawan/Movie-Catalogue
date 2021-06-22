package com.riski.moviecatalogue.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.di.Injection
import com.riski.moviecatalogue.ui.detail.DetailViewModel
import com.riski.moviecatalogue.ui.home.favorite.movie.FavoriteMovieViewModel
import com.riski.moviecatalogue.ui.home.favorite.tvshow.FavoriteTvShowViewModel
import com.riski.moviecatalogue.ui.home.movie.MovieViewModel
import com.riski.moviecatalogue.ui.home.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val catalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideCatalogueRepository(context))
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(catalogueRepository) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(catalogueRepository) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(catalogueRepository) as T
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> FavoriteMovieViewModel(catalogueRepository) as T
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> FavoriteTvShowViewModel(catalogueRepository) as T
            else -> throw  Throwable("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}