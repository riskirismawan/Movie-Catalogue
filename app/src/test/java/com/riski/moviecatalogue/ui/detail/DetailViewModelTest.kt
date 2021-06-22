package com.riski.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.utils.DataDummy
import com.riski.moviecatalogue.vo.Resource
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.getDetailMovie()
    private val dummyTvShow = DataDummy.getDetailTvShow()
    private val movieId = dummyMovie.movieId
    private val tvShowId = dummyTvShow.tvShowId

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    
    @Mock
    private lateinit var catalogueRepository: CatalogueRepository
    
    @Mock
    private lateinit var movieObserver: Observer<Resource<MovieEntity>>

    @Mock
    private lateinit var tvShowObserver: Observer<Resource<TvShowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
    }

    @Test
    fun getMovie() {
        val movieDummy = Resource.success(DataDummy.getDetailMovie())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = movieDummy

        `when`(catalogueRepository.getMovieDetail(movieId)).thenReturn(movie)
        viewModel.getMovieById(movieId)
        viewModel.getMovie().observeForever(movieObserver)
        verify(catalogueRepository).getMovieDetail(movieId)
        verify(movieObserver).onChanged(movieDummy)
    }

    @Test
    fun getTvShow() {
        val tvShowDummy = Resource.success(DataDummy.getDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = tvShowDummy

        `when`(catalogueRepository.getTvShowDetail(tvShowId)).thenReturn(tvShow)
        viewModel.getTvShowById(tvShowId)
        viewModel.getTvShow().observeForever(tvShowObserver)
        verify(catalogueRepository).getTvShowDetail(tvShowId)
        verify(tvShowObserver).onChanged(tvShowDummy)
    }

    @Test
    fun setFavoriteMovie() {
        val movieDummy = Resource.success(DataDummy.getDetailMovie())
        val movie = MutableLiveData<Resource<MovieEntity>>()
        movie.value = movieDummy

        `when`(catalogueRepository.getMovieDetail(movieId)).thenReturn(movie)
        viewModel.getMovieById(movieId)
        viewModel.setFavoriteMovie()
        verify(catalogueRepository).setFavoriteMovie(movie.value!!.data as MovieEntity, true)
        verifyNoMoreInteractions(movieObserver)
    }

    @Test
    fun setFavoriteTvShow() {
        val tvShowDummy = Resource.success(DataDummy.getDetailTvShow())
        val tvShow = MutableLiveData<Resource<TvShowEntity>>()
        tvShow.value = tvShowDummy

        `when`(catalogueRepository.getTvShowDetail(tvShowId)).thenReturn(tvShow)
        viewModel.getTvShowById(tvShowId)
        viewModel.setFavoriteTvShow()
        verify(catalogueRepository).setFavoriteTvShow(tvShow.value!!.data as TvShowEntity, true)
        verifyNoMoreInteractions(tvShowObserver)
    }
}