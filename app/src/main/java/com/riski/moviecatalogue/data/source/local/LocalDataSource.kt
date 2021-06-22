package com.riski.moviecatalogue.data.source.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.data.source.local.room.CatalogDao

class LocalDataSource private constructor(private val catalogDao: CatalogDao) {

    companion object {
        private var INSTANCE: LocalDataSource? = null
        fun getInstance(catalogDao: CatalogDao): LocalDataSource =
            INSTANCE?: LocalDataSource(catalogDao)
    }

    fun getMovies() : DataSource.Factory<Int, MovieEntity> = catalogDao.getMovies()

    fun getTvShows() : DataSource.Factory<Int, TvShowEntity> = catalogDao.getTvShows()

    fun getFavoriteMovies() : DataSource.Factory<Int, MovieEntity> = catalogDao.getFavoriteMovies()

    fun getFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity> = catalogDao.getFavoriteTvShows()

    fun getDetailMovie(movieId: Int) : LiveData<MovieEntity> = catalogDao.getDetailMovieById(movieId)

    fun getDetailTvShows(tvShowId: Int) : LiveData<TvShowEntity> = catalogDao.getDetailTvShowById(tvShowId)

    fun insertMovies(movies: List<MovieEntity>) = catalogDao.insertMovies(movies)

    fun insertTvShows(tvShows: List<TvShowEntity>) = catalogDao.insertTvShows(tvShows)

    fun setFavoriteMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        catalogDao.updateMovie(movie)
    }

    fun setFavoriteTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        catalogDao.updateTvShow(tvShow)
    }

    fun updateMovie(movie: MovieEntity, newState: Boolean) {
        movie.isFavorite = newState
        catalogDao.updateMovie(movie)
    }

    fun updateTvShow(tvShow: TvShowEntity, newState: Boolean) {
        tvShow.isFavorite = newState
        catalogDao.updateTvShow(tvShow)
    }
}