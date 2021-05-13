package com.riski.moviecatalogue.ui.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.data.MovieEntity
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
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
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel
    private val dummyMovies = DataDummy.generateDummyMovies()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<MoviesItem>>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<List<MoviesItem>>()
        movie.value = dummyMovies

        `when`(catalogueRepository.getMovies()).thenReturn(movie)
        val movieEntities = viewModel.getMovies().value

        verify(catalogueRepository).getMovies()
        assertNotNull(movieEntities)
        assertEquals(19, movieEntities?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(dummyMovies)
    }
}