package com.riski.moviecatalogue.data.remote

import com.riski.moviecatalogue.data.response.MovieResponse
import com.riski.moviecatalogue.data.response.MoviesItem
import com.riski.moviecatalogue.data.response.TvShowResponse
import com.riski.moviecatalogue.data.response.TvShowsItem
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("discover/movie")
    fun getMovie(
        @Query("api_key") api_key: String
    ): Call<MovieResponse>

    @GET("discover/tv")
    fun getTv(
        @Query("api_key") api_key: String
    ): Call<TvShowResponse>

    @GET("movie/{movie_id}")
    fun getMovieById(
        @Path("movie_id") movieId: Int,
        @Query("api_key") api_key: String
    ): Call<MoviesItem>

    @GET("tv/{tv_id}")
    fun getTvById(
        @Path("tv_id") tvId: Int,
        @Query("api_key") api_key: String
    ): Call<TvShowsItem>
}