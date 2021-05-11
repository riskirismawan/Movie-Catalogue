package com.riski.moviecatalogue.ui.tvshow

import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class TvShowViewModelTest {

    private lateinit var viewModel: TvShowViewModel

    @Before
    fun setUp() {
        viewModel = TvShowViewModel()
    }

    @Test
    fun getTvShow() {
        val tvShowEntities = viewModel.getTvShow()
        assertNotNull(tvShowEntities)
        assertEquals(19, tvShowEntities.size)
    }
}