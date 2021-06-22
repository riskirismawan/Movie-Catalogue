package com.riski.moviecatalogue.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.vo.Resource

class DetailViewModel(private val catalogueRepository: CatalogueRepository) : ViewModel() {

    private lateinit var movie: LiveData<Resource<MovieEntity>>
    private lateinit var tvShow: LiveData<Resource<TvShowEntity>>

    fun getMovieById(movieId: Int) {
        movie = catalogueRepository.getMovieDetail(movieId)
    }

    fun getTvShowById(tvShowId: Int) {
        tvShow = catalogueRepository.getTvShowDetail(tvShowId)
    }

    fun getMovie() = movie

    fun getTvShow() = tvShow

    fun setFavoriteMovie() {
        val movieValue = movie.value
        if (movieValue?.data != null) {
            val newState = !movieValue.data.isFavorite
            catalogueRepository.setFavoriteMovie(movieValue.data, newState)
        }
    }

    fun setFavoriteTvShow() {
        val tvShowValue = tvShow.value
        if (tvShowValue?.data != null) {
            val newState = !tvShowValue.data.isFavorite
            catalogueRepository.setFavoriteTvShow(tvShowValue.data, newState)
        }
    }

}