package com.riski.moviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class MovieResponse(

	@field:SerializedName("page")
	val page: Int? = null,

	@field:SerializedName("total_pages")
	val totalPages: Int? = null,

	@field:SerializedName("results")
	val results: List<MoviesItem?>? = null,

	@field:SerializedName("total_results")
	val totalResults: Int? = null
)

data class MoviesItem(

	@field:SerializedName("overview")
	val overview: String? = null,

	@field:SerializedName("budget")
	val budget: Int? = null,

	@field:SerializedName("revenue")
	val revenue: Int? = null,

	@field:SerializedName("title")
	val title: String? = null,

	@field:SerializedName("genres")
	val genres: List<GenreResponse?>? = null,

	@field:SerializedName("poster_path")
	val posterPath: String? = null,

	@field:SerializedName("release_date")
	val releaseDate: String? = null,

	@field:SerializedName("id")
	val id: Int? = null,
)
