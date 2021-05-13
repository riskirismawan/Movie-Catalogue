package com.riski.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem

interface CatalogueDataSource {

    fun getMovies(): LiveData<List<MoviesItem>>

    fun getMovieDetail(movieId: Int): LiveData<MoviesItem>

    fun getTvShows(): LiveData<List<TvShowsItem>>

    fun getTvShowDetail(tvShowId: Int): LiveData<TvShowsItem>
}