package com.riski.moviecatalogue.ui.home.favorite.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import junit.framework.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class FavoriteTvShowViewModelTest {

    private lateinit var viewModel: FavoriteTvShowViewModel

    @get:Rule
    var instantTaskExecutors = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvShowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setup() {
        viewModel = FavoriteTvShowViewModel(catalogueRepository)
    }

    @Test
    fun getFavoriteMovies() {
        val tvShowDummy = pagedList
        Mockito.`when`(tvShowDummy.size).thenReturn(4)
        val tvShows = MutableLiveData<PagedList<TvShowEntity>>()
        tvShows.value = tvShowDummy

        Mockito.`when`(catalogueRepository.getFavoriteTvShows()).thenReturn(tvShows)
        val tvShowEntity = viewModel.getFavoriteTvShows().value
        verify(catalogueRepository).getFavoriteTvShows()
        Assert.assertNotNull(tvShowEntity)
        Assert.assertEquals(4, tvShowEntity?.size)

        viewModel.getFavoriteTvShows().observeForever(observer)
        verify(observer).onChanged(tvShowDummy)
    }
}