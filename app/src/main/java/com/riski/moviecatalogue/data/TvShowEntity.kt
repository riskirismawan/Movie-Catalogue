package com.riski.moviecatalogue.data

data class TvShowEntity(
    var tvShowId: String,
    var title: String,
    var poster: Int,
    var overview: String,
    var releaseDate: String,
    var genre: String
)
