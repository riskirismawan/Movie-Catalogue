package com.riski.moviecatalogue.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.di.Injection
import com.riski.moviecatalogue.ui.detail.DetailViewModel
import com.riski.moviecatalogue.ui.movie.MovieViewModel
import com.riski.moviecatalogue.ui.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private val catalogueRepository: CatalogueRepository) :
    ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(): ViewModelFactory = instance ?: synchronized(this) {
            instance ?: ViewModelFactory(Injection.provideCatalogueRepository())
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when {
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(
                catalogueRepository
            ) as T
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(
                catalogueRepository
            ) as T
            modelClass.isAssignableFrom(DetailViewModel::class.java) -> DetailViewModel(
                catalogueRepository
            ) as T
            else -> throw  Throwable("Unknown ViewModel class: ${modelClass.name}")
        }
    }
}