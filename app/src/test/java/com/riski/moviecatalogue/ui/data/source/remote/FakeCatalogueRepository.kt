package com.riski.moviecatalogue.ui.data.source.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.riski.moviecatalogue.data.source.CatalogueDataSource
import com.riski.moviecatalogue.data.source.remote.RemoteDataSource
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FakeCatalogueRepository(private val remoteDataSource: RemoteDataSource):
    CatalogueDataSource {

    override fun getMovies(): LiveData<List<MoviesItem>> {
        val listMoviews = MutableLiveData<List<MoviesItem>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovies(object : RemoteDataSource.LoadMovieCallback {
                override fun onAllMovieReceived(movieItems: List<MoviesItem>) {
                    val movieList = ArrayList<MoviesItem>()
                    for (response in movieItems) {
                        val movie = MoviesItem(
                            response.overview,
                            response.budget,
                            response.revenue,
                            response.title,
                            response.genres,
                            response.posterPath,
                            response.releaseDate,
                            response.id
                        )
                        movieList.add(movie)
                    }
                    listMoviews.postValue(movieList)
                }
            })
        }
        return listMoviews
    }

    override fun getMovieDetail(movieId: Int): LiveData<MoviesItem> {
        val itemMovie = MutableLiveData<MoviesItem>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovieDetail(movieId, object : RemoteDataSource.LoadMovieDetailCallback {
                override fun onAllMovieReceived(movieItem: MoviesItem) {
                    val movie = MoviesItem(
                        movieItem.overview,
                        movieItem.budget,
                        movieItem.revenue,
                        movieItem.title,
                        movieItem.genres,
                        movieItem.posterPath,
                        movieItem.releaseDate,
                        movieItem.id
                    )
                    itemMovie.postValue(movie)
                }
            })
        }
        return itemMovie
    }

    override fun getTvShows(): LiveData<List<TvShowsItem>> {
        val listTvShows = MutableLiveData<List<TvShowsItem>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvShows(object : RemoteDataSource.LoadTvShowCallback {
                override fun onAllMovieReceived(tvShowItems: List<TvShowsItem>) {
                    val tvShowList = ArrayList<TvShowsItem>()
                    for (response in tvShowItems) {
                        val tvShow = TvShowsItem(
                            response.firstAirDate,
                            response.overview,
                            response.genres,
                            response.posterPath,
                            response.name,
                            response.id
                        )
                        tvShowList.add(tvShow)
                    }
                    listTvShows.postValue(tvShowList)
                }
            })
        }
        return listTvShows
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<TvShowsItem> {
        val itemTvShow = MutableLiveData<TvShowsItem>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getTvShowDetail(tvShowId, object : RemoteDataSource.LoadTvShowDetailCallback{
                override fun onAllMovieReceived(tvShowItem: TvShowsItem) {
                    val tvShow = TvShowsItem(
                        tvShowItem.firstAirDate,
                        tvShowItem.overview,
                        tvShowItem.genres,
                        tvShowItem.posterPath,
                        tvShowItem.name,
                        tvShowItem.id
                    )
                    itemTvShow.postValue(tvShow)
                }
            })
        }
        return itemTvShow
    }

}