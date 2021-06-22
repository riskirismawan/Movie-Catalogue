package com.riski.moviecatalogue.ui.home.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.vo.Resource
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<MovieEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setUp() {
        viewModel = MovieViewModel(catalogueRepository)
    }

    @Test
    fun getMovie() {
        val movieDummy = Resource.success(pagedList)
        `when`(movieDummy.data?.size).thenReturn(20)
        val movieEntities = MutableLiveData<Resource<PagedList<MovieEntity>>>()
        movieEntities.value = movieDummy

        `when`(catalogueRepository.getMovies()).thenReturn(movieEntities)
        val movies = viewModel.getMovies().value?.data

        verify(catalogueRepository).getMovies()
        assertNotNull(movies)
        assertEquals(20, movies?.size)

        viewModel.getMovies().observeForever(observer)
        verify(observer).onChanged(movieDummy)
    }
}