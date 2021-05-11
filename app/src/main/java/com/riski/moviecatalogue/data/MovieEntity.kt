package com.riski.moviecatalogue.data

data class MovieEntity (
    var movieId: String,
    var title: String,
    var poster: Int,
    var overview: String,
    var releaseDate: String,
    var genre: String,
    var budget: String,
    var revenue: String
)
