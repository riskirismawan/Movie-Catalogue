package com.riski.moviecatalogue.ui.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import com.riski.moviecatalogue.utils.DataDummy
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel
    private val dummyTvShow = DataDummy.generateDummyTvShows()

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<List<TvShowsItem>>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<List<TvShowsItem>>()
        tvShow.value = dummyTvShow

        `when`(catalogueRepository.getTvShows()).thenReturn(tvShow)
        val tvShowEntities = viewModel.getTvShows().value

        verify(catalogueRepository).getTvShows()
        assertNotNull(tvShowEntities)
        assertEquals(19, tvShowEntities?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }
}