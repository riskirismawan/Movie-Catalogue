package com.riski.moviecatalogue.ui.movie

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riski.moviecatalogue.data.remote.ApiConfig
import com.riski.moviecatalogue.data.response.MovieResponse
import com.riski.moviecatalogue.data.response.MoviesItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieViewModel : ViewModel() {

    private val apiKey = "003b76808a270c1366be2601621229bf"
    private val _movies = MutableLiveData<ArrayList<MoviesItem>>()
    val movie: LiveData<ArrayList<MoviesItem>> = _movies

    init {
        getMovies()
    }

    fun getMovies(): MutableLiveData<ArrayList<MoviesItem>> {
        val client = ApiConfig.getApiService().getMovie(apiKey)
        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                if (response.isSuccessful)
                    _movies.value = response.body()?.results as ArrayList<MoviesItem>
                else
                    Log.e(TAG, "onResponse: ${response.message()}")
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
        return _movies
    }

}