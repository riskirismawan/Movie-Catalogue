package com.riski.moviecatalogue.ui.data.source.remote

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import com.riski.moviecatalogue.LiveDataTestUtil
import com.riski.moviecatalogue.data.source.remote.RemoteDataSource
import com.riski.moviecatalogue.utils.DataDummy
import junit.framework.Assert.assertEquals
import junit.framework.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class CatalogueRepository {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val catalogueRepository = FakeCatalogueRepository(remote)

    private val listMovies = DataDummy.generateDummyMovies()
    private val movieId = listMovies[0].id
    private val listTvShow = DataDummy.generateDummyTvShows()
    private val tvShowId = listTvShow[0].id
    private val movie = DataDummy.generateDummyMovies()[0]
    private val tvShow = DataDummy.generateDummyTvShows()[0]

    @Test
    fun getMovies() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadMovieCallback).onAllMovieReceived(listMovies)
                null
            }.`when`(remote).getMovies(any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getMovies())

        runBlocking {
            verify(remote).getMovies(any())
        }

        assertNotNull(data)
        assertEquals(listMovies.size.toLong(), data.size.toLong())
    }

    @Test
    fun getMovieDetail() {
        runBlocking {
                doAnswer { invocation ->
                    (invocation.arguments[1] as RemoteDataSource.LoadMovieDetailCallback).onAllMovieReceived(movie)
                    null
                }.`when`(remote).getMovieDetail(eq(movieId!!), any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getMovieDetail(movieId!!))

        runBlocking {
            verify(remote).getMovieDetail(eq(movieId), any())
        }

        assertNotNull(data)
        assertEquals(movie.id, data.id)
    }

    @Test
    fun getTvShows() {
        runBlocking {
            doAnswer { invocation ->
                (invocation.arguments[0] as RemoteDataSource.LoadTvShowCallback).onAllMovieReceived(listTvShow)
                null
            }.`when`(remote).getTvShows(any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getTvShows())

        runBlocking {
            verify(remote).getTvShows(any())
        }

        assertNotNull(data)
        assertEquals(listTvShow.size.toLong(), data.size.toLong())
    }

    @Test
    fun getTvShowDetail() {
        runBlocking {
                doAnswer { invocation ->
                    (invocation.arguments[1] as RemoteDataSource.LoadTvShowDetailCallback).onAllMovieReceived(tvShow)
                    null
                }.`when`(remote).getTvShowDetail(eq(tvShowId!!), any())
        }

        val data = LiveDataTestUtil.getValue(catalogueRepository.getTvShowDetail(tvShowId!!))

        runBlocking {
            verify(remote).getTvShowDetail(eq(tvShowId), any())
        }

        assertNotNull(data)
        assertEquals(tvShow.id, data.id)
    }

}