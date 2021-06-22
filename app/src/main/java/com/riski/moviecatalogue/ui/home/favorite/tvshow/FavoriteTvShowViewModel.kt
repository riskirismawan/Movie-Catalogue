package com.riski.moviecatalogue.ui.home.favorite.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity

class FavoriteTvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> = catalogueRepository.getFavoriteTvShows()

}