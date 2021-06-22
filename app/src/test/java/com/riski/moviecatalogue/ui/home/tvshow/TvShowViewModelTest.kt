package com.riski.moviecatalogue.ui.home.tvshow

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
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
class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var catalogueRepository: CatalogueRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvShowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvShowEntity>

    @Before
    fun setUp() {
        viewModel = TvShowViewModel(catalogueRepository)
    }

    @Test
    fun getTvShow() {
        val tvShowDummy = Resource.success(pagedList)
        `when`(tvShowDummy.data?.size).thenReturn(20)
        val tvShowEntities = MutableLiveData<Resource<PagedList<TvShowEntity>>>()
        tvShowEntities.value = tvShowDummy

        `when`(catalogueRepository.getTvShows()).thenReturn(tvShowEntities)
        val tvShows = viewModel.getTvShows().value?.data
        assertNotNull(tvShows)
        assertEquals(20, tvShows?.size)

        viewModel.getTvShows().observeForever(observer)
        verify(observer).onChanged(tvShowDummy)
    }
}