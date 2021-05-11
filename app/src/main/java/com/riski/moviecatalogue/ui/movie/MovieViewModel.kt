package com.riski.moviecatalogue.ui.movie

import androidx.lifecycle.ViewModel
import com.riski.moviecatalogue.data.MovieEntity
import com.riski.moviecatalogue.utils.DataDummy

class MovieViewModel : ViewModel() {

    fun getMovie(): List<MovieEntity> = DataDummy.generateDummyMovies()

}