package com.riski.moviecatalogue.data.source.remote

import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import com.riski.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {

    private val apiKey = "003b76808a270c1366be2601621229bf"

    companion object {
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance?: synchronized(this) {
            instance?: RemoteDataSource()
        }
    }

    suspend fun getMovies(callback: LoadMovieCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovie(apiKey).await().results.let { movieList ->
            callback.onAllMovieReceived(movieList as List<MoviesItem>)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getMovieDetail(movieId: Int, callback: LoadMovieDetailCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovieById(movieId, apiKey).await().let { movie ->
            callback.onAllMovieReceived(movie)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShows(callback: LoadTvShowCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTv(apiKey).await().results.let { tvShowList ->
            callback.onAllMovieReceived(tvShowList as List<TvShowsItem>)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(tvShowId: Int, callback: LoadTvShowDetailCallback) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvById(tvShowId, apiKey).await().let { tvShow ->
            callback.onAllMovieReceived(tvShow)
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadMovieCallback {
        fun onAllMovieReceived(movieItems: List<MoviesItem>)
    }

    interface LoadMovieDetailCallback {
        fun onAllMovieReceived(movieItem: MoviesItem)
    }

    interface LoadTvShowCallback {
        fun onAllMovieReceived(tvShowItems: List<TvShowsItem>)
    }

    interface LoadTvShowDetailCallback {
        fun onAllMovieReceived(tvShowItem: TvShowsItem)
    }
}