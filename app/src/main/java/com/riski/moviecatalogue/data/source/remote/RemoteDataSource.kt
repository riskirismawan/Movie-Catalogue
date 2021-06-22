package com.riski.moviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.riski.moviecatalogue.data.source.remote.api.ApiConfig
import com.riski.moviecatalogue.data.source.remote.response.MovieResponse
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowResponse
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import com.riski.moviecatalogue.data.source.remote.vo.ApiResponse
import com.riski.moviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSource {

    companion object {
        private val TAG = RemoteDataSource::class.java.simpleName
        @Volatile
        private var instance: RemoteDataSource? = null

        fun getInstance(): RemoteDataSource = instance?: synchronized(this) {
            instance?: RemoteDataSource().apply { instance = this }
        }
    }

    fun getMovies(): LiveData<ApiResponse<List<MoviesItem>>> {
        EspressoIdlingResource.increment()
        val movies = MutableLiveData<ApiResponse<List<MoviesItem>>>()
        val client = ApiConfig.getApiService().getMovie()

        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                movies.value = ApiResponse.success(response.body()?.results as List<MoviesItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, t.message.toString())
                EspressoIdlingResource.decrement()
            }
        })
        return movies
    }

    fun getMovieDetail(movieId: Int): LiveData<ApiResponse<MoviesItem>> {
        EspressoIdlingResource.increment()
        val detailMovie = MutableLiveData<ApiResponse<MoviesItem>>()
        val client = ApiConfig.getApiService().getMovieById(movieId)

        client.enqueue(object : Callback<MoviesItem> {
            override fun onResponse(call: Call<MoviesItem>, response: Response<MoviesItem>) {
                detailMovie.value = ApiResponse.success(response.body() as MoviesItem)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MoviesItem>, t: Throwable) {
                Log.e(TAG, t.message.toString())
                EspressoIdlingResource.decrement()
            }
        })
        return detailMovie
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShowsItem>>> {
        EspressoIdlingResource.increment()
        val tvShows = MutableLiveData<ApiResponse<List<TvShowsItem>>>()
        val client = ApiConfig.getApiService().getTv()

        client.enqueue(object : Callback<TvShowResponse>{
            override fun onResponse(call: Call<TvShowResponse>, response: Response<TvShowResponse>) {
                tvShows.value = ApiResponse.success(response.body()?.results as List<TvShowsItem>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, t.message.toString())
                EspressoIdlingResource.decrement()
            }
        })
        return tvShows
    }

    fun getTvShowDetail(tvShowId: Int): LiveData<ApiResponse<TvShowsItem>> {
        EspressoIdlingResource.increment()
        val detailTvShow = MutableLiveData<ApiResponse<TvShowsItem>>()
        val client = ApiConfig.getApiService().getTvById(tvShowId)

        client.enqueue(object : Callback<TvShowsItem>{
            override fun onResponse(call: Call<TvShowsItem>, response: Response<TvShowsItem>) {
                detailTvShow.value = ApiResponse.success(response.body() as TvShowsItem)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvShowsItem>, t: Throwable) {
                Log.e(TAG, t.message.toString())
                EspressoIdlingResource.decrement()
            }
        })
        return detailTvShow
    }
}