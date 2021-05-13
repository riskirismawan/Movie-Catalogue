package com.riski.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import com.riski.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.id
    private val tvShowId = dummyTvShow.id

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()
    
    @Mock
    private lateinit var catalogueRepository: CatalogueRepository
    
    @Mock
    private lateinit var movieObserver: Observer<MoviesItem>

    @Mock
    private lateinit var tvShowObserver: Observer<TvShowsItem>

    @Before
    fun setUp() {
        viewModel = DetailViewModel(catalogueRepository)
        if (movieId != null) {
            viewModel.getMovieById(movieId)
        }
        if (tvShowId != null) {
            viewModel.getTvById(tvShowId)
        }
    }

    @Test
    fun getMovie() {
        val movieDummy = MutableLiveData<MoviesItem>()
        movieDummy.value = dummyMovie

        `when`(catalogueRepository.getMovieDetail(movieId!!)).thenReturn(movieDummy)
        val movieItem = viewModel.getMovieById(movieId).value as MoviesItem

        assertNotNull(movieItem)
        assertEquals(dummyMovie.id, movieItem.id)
        assertEquals(dummyMovie.title, movieItem.title)
        assertEquals(dummyMovie.posterPath, movieItem.posterPath)
        assertEquals(dummyMovie.overview, movieItem.overview)
        assertEquals(dummyMovie.releaseDate, movieItem.releaseDate)
        assertEquals(dummyMovie.genres, movieItem.genres)
        assertEquals(dummyMovie.budget, movieItem.budget)
        assertEquals(dummyMovie.revenue, movieItem.revenue)

        viewModel.getMovieById(movieId).observeForever(movieObserver)
        verify(movieObserver).onChanged(dummyMovie)
    }

    @Test
    fun getTvShow() {
        val tvShowDummy = MutableLiveData<TvShowsItem>()
        tvShowDummy.value = dummyTvShow

        `when`(catalogueRepository.getTvShowDetail(tvShowId!!)).thenReturn(tvShowDummy)
        val tvShowsItem = viewModel.getTvById(tvShowId).value as TvShowsItem

        assertNotNull(tvShowsItem)
        assertEquals(dummyTvShow.id, tvShowsItem.id)
        assertEquals(dummyTvShow.name, tvShowsItem.name)
        assertEquals(dummyTvShow.posterPath, tvShowsItem.posterPath)
        assertEquals(dummyTvShow.overview, tvShowsItem.overview)
        assertEquals(dummyTvShow.firstAirDate, tvShowsItem.firstAirDate)
        assertEquals(dummyTvShow.genres, tvShowsItem.genres)

        viewModel.getTvById(tvShowId).observeForever(tvShowObserver)
        verify(tvShowObserver).onChanged(dummyTvShow)
    }
}