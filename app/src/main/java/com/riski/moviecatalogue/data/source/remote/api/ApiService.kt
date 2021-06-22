package com.riski.moviecatalogue.data.source.remote.api

import com.riski.moviecatalogue.data.source.remote.response.MovieResponse
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowResponse
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") api_key: String = "API_KEY"
    ): Call<MovieResponse>

    @GET("discover/tv")
    fun getTv(
        @Query("api_key") api_key: String = "API_KEY"
    ): Call<TvShowResponse>

    @GET("movie/{movie_id}")
    fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String = "API_KEY"
    ): Call<MoviesItem>

    @GET("tv/{tv_id}")
    fun getTvById(
        @Path("tv_id") tvId: Int,
        @Query("api_key") api_key: String = "API_KEY"
    ): Call<TvShowsItem>
}