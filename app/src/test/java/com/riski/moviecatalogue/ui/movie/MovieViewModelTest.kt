package com.riski.moviecatalogue.ui.movie

import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MovieViewModelTest {

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        viewModel = MovieViewModel()
    }

    @Test
    fun getMovie() {
        val movieEntities = viewModel.getMovie()
        assertNotNull(movieEntities)
        assertEquals(19, movieEntities.size)
    }
}