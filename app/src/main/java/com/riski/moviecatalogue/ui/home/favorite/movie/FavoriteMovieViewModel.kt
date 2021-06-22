package com.riski.moviecatalogue.ui.home.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> = catalogueRepository.getFavoriteMovies()

}