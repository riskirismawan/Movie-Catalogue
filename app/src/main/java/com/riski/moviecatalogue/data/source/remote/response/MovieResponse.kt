package com.riski.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<MoviesItem>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)

data class MoviesItem(

	@field:SerializedName("overview")
	val overview: String,

	@field:SerializedName("budget")
	val budget: Int,

	@field:SerializedName("revenue")
	val revenue: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("genres")
	val genres: List<GenreResponse>,

	@field:SerializedName("poster_path")
	val posterPath: String,

	@field:SerializedName("release_date")
	val releaseDate: String,

	@field:SerializedName("id")
	val id: Int,
)
