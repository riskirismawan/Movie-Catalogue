package com.riski.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getMovieById(dataId: Int): LiveData<MoviesItem> = catalogueRepository.getMovieDetail(dataId)

    fun getTvById(dataId: Int): LiveData<TvShowsItem> = catalogueRepository.getTvShowDetail(dataId)

}