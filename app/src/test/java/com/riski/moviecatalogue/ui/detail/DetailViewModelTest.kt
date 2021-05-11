package com.riski.moviecatalogue.ui.detail

import com.riski.moviecatalogue.utils.DataDummy
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class DetailViewModelTest {

    private lateinit var viewModel: DetailViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val dummyTvShow = DataDummy.generateDummyTvShows()[0]
    private val movieId = dummyMovie.movieId
    private val tvShowId = dummyTvShow.tvShowId

    @Before
    fun setUp() {
        viewModel = DetailViewModel()
        viewModel.setSelectedMovie(movieId)
        viewModel.setSelectedTvShow(tvShowId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.poster, movieEntity.poster)
        assertEquals(dummyMovie.overview, movieEntity.overview)
        assertEquals(dummyMovie.releaseDate, movieEntity.releaseDate)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.budget, movieEntity.budget)
        assertEquals(dummyMovie.revenue, movieEntity.revenue)
    }

    @Test
    fun getTvShow() {
        viewModel.setSelectedTvShow(dummyTvShow.tvShowId)
        val tvShowEntity = viewModel.getTvShow()
        assertNotNull(tvShowEntity)
        assertEquals(dummyTvShow.tvShowId, tvShowEntity.tvShowId)
        assertEquals(dummyTvShow.title, tvShowEntity.title)
        assertEquals(dummyTvShow.poster, tvShowEntity.poster)
        assertEquals(dummyTvShow.overview, tvShowEntity.overview)
        assertEquals(dummyTvShow.releaseDate, tvShowEntity.releaseDate)
        assertEquals(dummyTvShow.genre, tvShowEntity.genre)
    }
}