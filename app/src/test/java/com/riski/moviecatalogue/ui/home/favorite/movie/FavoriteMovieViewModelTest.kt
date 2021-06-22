package com.riski.moviecatalogue.ui.home.favorite.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteMovieViewModelTest {

    private lateinit var viewModel: FavoriteMovieViewModel

    @get:Rule
    var instantTaskExecutors = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<MovieEntity>>

    @Mock
    private lateinit var pagedList: PagedList<MovieEntity>

    @Before
    fun setup() {
        viewModel = FavoriteMovieViewModel(catalogueRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val movieDummy = pagedList
        `when`(movieDummy.size).thenReturn(4)
        val movies = MutableLiveData<PagedList<MovieEntity>>()
        movies.value = movieDummy

        `when`(catalogueRepository.getFavoriteMovies()).thenReturn(movies)
        val movieEntity = viewModel.getFavoriteMovies().value
        verify(catalogueRepository).getFavoriteMovies()
        assertNotNull(movieEntity)
        assertEquals(4, movieEntity?.size)

        viewModel.getFavoriteMovies().observeForever(observer)
        verify(observer).onChanged(movieDummy)
    }
}