package com.riski.moviecatalogue.ui.tvshow

import android.content.ContentValues.TAG
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.riski.moviecatalogue.data.remote.ApiConfig
import com.riski.moviecatalogue.data.response.TvShowResponse
import com.riski.moviecatalogue.data.response.TvShowsItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TvShowViewModel : ViewModel() {

    private val apiKey = "003b76808a270c1366be2601621229bf"
    private val _tvShows = MutableLiveData<ArrayList<TvShowsItem>>()
    val tvShow: LiveData<ArrayList<TvShowsItem>> = getTvShows()

    fun getTvShows(): MutableLiveData<ArrayList<TvShowsItem>> {
        val client = ApiConfig.getApiService().getTv(apiKey)
        client.enqueue(object : Callback<TvShowResponse> {
            override fun onResponse(
                call: Call<TvShowResponse>,
                response: Response<TvShowResponse>
            ) {
                if (response.isSuccessful)
                    _tvShows.value = response.body()?.results as ArrayList<TvShowsItem>
                else
                    Log.e(TAG, "onResponse: ${response.message()}")
            }

            override fun onFailure(call: Call<TvShowResponse>, t: Throwable) {
                Log.e(TAG, "onFailure: ${t.message}")
            }

        })
        return _tvShows
    }

}