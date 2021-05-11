package com.riski.moviecatalogue.ui.tvshow

import androidx.lifecycle.ViewModel
import com.riski.moviecatalogue.data.TvShowEntity
import com.riski.moviecatalogue.utils.DataDummy

class TvShowViewModel : ViewModel() {

    fun getTvShow(): List<TvShowEntity> = DataDummy.generateDummyTvShows()

}