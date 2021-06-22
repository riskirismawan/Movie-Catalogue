package com.riski.moviecatalogue.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.vo.Resource

class TvShowViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> = catalogueRepository.getTvShows()

}