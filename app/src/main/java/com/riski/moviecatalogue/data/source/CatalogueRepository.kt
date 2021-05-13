package com.riski.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.riski.moviecatalogue.data.source.remote.RemoteDataSource
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource): CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource): CatalogueDataSource =
            instance?: synchronized(this) {
                instance?: CatalogueRepository(remoteDataSource)
            }
    }

    override fun getMovies(): LiveData<List<MoviesItem>> {
        val listMoviews = MutableLiveData<List<MoviesItem>>()
        CoroutineScope(Dispatchers.IO).launch {
            remoteDataSource.getMovies(object : RemoteDataSource.LoadMovieCallback {
                override fun onAllMovieReceived(movieItems: List<MoviesItem>) {
                    val movieList = ArrayList<MoviesItem>()
                    for (response in movieItems) {
                        val movie = MoviesItem(
                            response.overview,
                            response.originalLanguage,
                            response.originalTitle,
                            response.budget,
                            response.revenue,
                            response.title,
                            response.genres,
                            response.posterPath,
                            response.releaseDate,
                            response.popularity,
                            response.voteAverage,
                            response.id,
                            response.adult,
                            response.voteCount
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
                        movieItem.originalLanguage,
                        movieItem.originalTitle,
                        movieItem.budget,
                        movieItem.revenue,
                        movieItem.title,
                        movieItem.genres,
                        movieItem.posterPath,
                        movieItem.releaseDate,
                        movieItem.popularity,
                        movieItem.voteAverage,
                        movieItem.id,
                        movieItem.adult,
                        movieItem.voteCount
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
                            response.originalLanguage,
                            response.genres,
                            response.posterPath,
                            response.originCountry,
                            response.originalName,
                            response.popularity,
                            response.voteAverage,
                            response.name,
                            response.id,
                            response.voteCount
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
                        tvShowItem.originalLanguage,
                        tvShowItem.genres,
                        tvShowItem.posterPath,
                        tvShowItem.originCountry,
                        tvShowItem.originalName,
                        tvShowItem.popularity,
                        tvShowItem.voteAverage,
                        tvShowItem.name,
                        tvShowItem.id,
                        tvShowItem.voteCount
                    )
                    itemTvShow.postValue(tvShow)
                }
            })
        }
        return itemTvShow
    }

}