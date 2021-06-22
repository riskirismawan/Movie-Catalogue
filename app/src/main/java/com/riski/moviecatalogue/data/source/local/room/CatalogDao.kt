package com.riski.moviecatalogue.data.source.local.room

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity

@Dao
interface CatalogDao {
    @Query("SELECT * FROM favorite_movie")
    fun getMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM favorite_tvshow")
    fun getTvShows() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM favorite_movie WHERE isFavorite = 1")
    fun getFavoriteMovies() : DataSource.Factory<Int, MovieEntity>

    @Query("SELECT * FROM favorite_tvshow WHERE isFavorite = 1")
    fun getFavoriteTvShows() : DataSource.Factory<Int, TvShowEntity>

    @Query("SELECT * FROM favorite_movie WHERE movieId = :movieId")
    fun getDetailMovieById(movieId: Int) : LiveData<MovieEntity>

    @Query("SELECT * FROM favorite_tvshow WHERE tvShowId = :tvShowId")
    fun getDetailTvShowById(tvShowId: Int) : LiveData<TvShowEntity>

    @Insert
    fun insertMovies(movies: List<MovieEntity>)

    @Insert
    fun insertTvShows(tvShows: List<TvShowEntity>)

    @Update
    fun updateMovie(movie: MovieEntity)

    @Update
    fun updateTvShow(tvShow: TvShowEntity)
}