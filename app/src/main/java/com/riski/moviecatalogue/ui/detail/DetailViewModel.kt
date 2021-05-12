package com.riski.moviecatalogue.ui.detail

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riski.moviecatalogue.data.remote.ApiConfig
import com.riski.moviecatalogue.data.response.MoviesItem
import com.riski.moviecatalogue.data.response.TvShowsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailViewModel() : ViewModel() {

    private val apiKey = "003b76808a270c1366be2601621229bf"
    private val _movie = MutableLiveData<MoviesItem>()
    private val _tvShow = MutableLiveData<TvShowsItem>()
    
    fun getMovieById(dataId: Int): MutableLiveData<MoviesItem> {

        val client = ApiConfig.getApiService().getMovieById(dataId, apiKey)
        client.enqueue(object : Callback<MoviesItem> {
            override fun onResponse(call: Call<MoviesItem>, response: Response<MoviesItem>) {
                if (response.isSuccessful)
                    _movie.value = response.body()
                else
                    Log.e(TAG, "onResponse: ${response.message()}")
            }

            override fun onFailure(call: Call<MoviesItem>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}",)
            }

        })
        return _movie
    }

    fun getTvById(dataId: Int): MutableLiveData<TvShowsItem> {
        val client = ApiConfig.getApiService().getTvById(dataId, apiKey)
        client.enqueue(object : Callback<TvShowsItem> {
            override fun onResponse(call: Call<TvShowsItem>, response: Response<TvShowsItem>) {
                if (response.isSuccessful)
                    _tvShow.value = response.body()
                else
                    Log.e(TAG, "onResponse: ${response.message()}")
            }

            override fun onFailure(call: Call<TvShowsItem>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
        return _tvShow
    }

}