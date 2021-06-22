package com.riski.moviecatalogue.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.nhaarman.mockitokotlin2.*
import com.riski.moviecatalogue.data.source.local.LocalDataSource
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.utils.AppExecutors
import com.riski.moviecatalogue.utils.LiveDataTestUtil
import com.riski.moviecatalogue.utils.DataDummy
import com.riski.moviecatalogue.utils.PageListUtils
import com.riski.moviecatalogue.vo.Resource
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class CatalogueRepositoryTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)

    private val catalogueRepository = FakeCatalogueRepository(remote, local, appExecutors)

    private val listMovies = DataDummy.generateDummyMovies()
    private val movieId = listMovies[0].movieId
    private val movie = DataDummy.generateDummyMovies()[0]
    private val listTvShow = DataDummy.generateDummyTvShows()
    private val tvShowId = listTvShow[0].tvShowId
    private val tvShow = DataDummy.generateDummyTvShows()[0]

    @Test
    fun getMovies() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getMovies()

        val movies = Resource.success(PageListUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getMovies()
        assertNotNull(movies.data)
        assertEquals(listMovies.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun getMovieDetail() {
        val movieDummy = MutableLiveData<MovieEntity>()
        movieDummy.value = DataDummy.getDetailMovie()
        `when`(local.getDetailMovie(movieId)).thenReturn(movieDummy)

        val movieDetail = LiveDataTestUtil.getValue(catalogueRepository.getMovieDetail(movieId))
        verify(local).getDetailMovie(movieId)

        assertNotNull(movieDetail)
        assertEquals(movie.movieId, movieDetail.data?.movieId)
    }

    @Test
    fun getTvShows() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getTvShows()

        val tvShows = Resource.success(PageListUtils.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getTvShows()
        assertNotNull(tvShows)
        assertEquals(listTvShow.size.toLong(), tvShows.data?.size?.toLong())
    }

    @Test
    fun getTvShowDetail() {
        val tvShowDummy = MutableLiveData<TvShowEntity>()
        tvShowDummy.value = DataDummy.getDetailTvShow()
        `when`(local.getDetailTvShows(tvShowId)).thenReturn(tvShowDummy)

        val tvShowDetail = LiveDataTestUtil.getValue(catalogueRepository.getTvShowDetail(tvShowId))
        verify(local).getDetailTvShows(tvShowId)

        assertNotNull(tvShowDetail)
        assertEquals(tvShow.tvShowId, tvShowDetail.data?.tvShowId)
    }

    @Test
    fun gerFavoriteMovie() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        `when`(local.getFavoriteMovies()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteMovies()

        val movies = Resource.success(PageListUtils.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavoriteMovies()
        assertNotNull(movies)
        assertEquals(listMovies.size.toLong(), movies.data?.size?.toLong())
    }

    @Test
    fun gerFavoriteTvShow() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvShowEntity>
        `when`(local.getFavoriteTvShows()).thenReturn(dataSourceFactory)
        catalogueRepository.getFavoriteTvShows()

        val tvShows = Resource.success(PageListUtils.mockPagedList(DataDummy.generateDummyTvShows()))
        verify(local).getFavoriteTvShows()
        assertNotNull(tvShows)
        assertEquals(listTvShow.size.toLong(), tvShows.data?.size?.toLong())
    }

    @Test
    fun setFavoriteMovie() {
        catalogueRepository.setFavoriteMovie(DataDummy.getDetailMovie(), true)
        verify(local).setFavoriteMovie(DataDummy.getDetailMovie(), true)
        verifyNoMoreInteractions(local)
    }

    @Test
    fun setFavoriteTvShow() {
        catalogueRepository.setFavoriteTvShow(DataDummy.getDetailTvShow(), true)
        verify(local).setFavoriteTvShow(DataDummy.getDetailTvShow(), true)
        verifyNoMoreInteractions(local)
    }

}