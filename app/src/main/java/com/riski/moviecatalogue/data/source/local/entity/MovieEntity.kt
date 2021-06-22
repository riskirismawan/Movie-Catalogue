package com.riski.moviecatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "favorite_movie")
@Parcelize
data class MovieEntity(

    @PrimaryKey
    @ColumnInfo(name = "movieId")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "poster")
    var poster: String,

    @ColumnInfo(name = "overview")
    var overview: String,

    @ColumnInfo(name = "releaseDate")
    var releaseDate: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "budget")
    var budget: Int,

    @ColumnInfo(name = "revenue")
    var revenue: Int,

    @ColumnInfo(name = "isFavorite")
    var isFavorite: Boolean
): Parcelable
