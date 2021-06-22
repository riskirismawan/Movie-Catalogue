package com.riski.moviecatalogue.data.source

import androidx.lifecycle.LiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.riski.moviecatalogue.data.source.local.LocalDataSource
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.data.source.remote.RemoteDataSource
import com.riski.moviecatalogue.data.source.remote.response.MoviesItem
import com.riski.moviecatalogue.data.source.remote.response.TvShowsItem
import com.riski.moviecatalogue.data.source.remote.vo.ApiResponse
import com.riski.moviecatalogue.utils.AppExecutors
import com.riski.moviecatalogue.vo.Resource

class CatalogueRepository private constructor(private val remoteDataSource: RemoteDataSource, private val localDataSource: LocalDataSource, private val appExecutors: AppExecutors): CatalogueDataSource {

    companion object {
        @Volatile
        private var instance: CatalogueRepository? = null

        fun getInstance(remoteDataSource: RemoteDataSource, localDataSource: LocalDataSource, appExecutors: AppExecutors): CatalogueRepository =
            instance?: synchronized(this) {
                instance?: CatalogueRepository(remoteDataSource, localDataSource, appExecutors).apply { instance = this }
            }
    }

    override fun getMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<MoviesItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()
                return LivePagedListBuilder(localDataSource.getMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isNullOrEmpty()

            override fun createCall(): LiveData<ApiResponse<List<MoviesItem>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(dbSource: List<MoviesItem>) {
                val movies = ArrayList<MovieEntity>()
                for (data in dbSource) {
                    val genres = StringBuilder().append("")
                    if (!data.genres.isNullOrEmpty()) {
                        for (i in data.genres.indices) {
                            if (i < data.genres.size - 1)
                                genres.append("${data.genres[i].name}, ")
                            else
                                genres.append(data.genres[i].name)
                        }
                    }
                    val movie = MovieEntity(
                            data.id,
                            data.title,
                            data.posterPath,
                            data.overview,
                            data.releaseDate,
                            genres.toString(),
                            data.budget,
                            data.revenue,
                            false
                    )
                    movies.add(movie)
                }
                localDataSource.insertMovies(movies)
            }
        }.asLiveData()
    }

    override fun getMovieDetail(movieId: Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, MoviesItem>(appExecutors) {
            override fun loadFromDB(): LiveData<MovieEntity> =
                localDataSource.getDetailMovie(movieId)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data != null && data.genre.isEmpty()

            override fun createCall(): LiveData<ApiResponse<MoviesItem>> =
                remoteDataSource.getMovieDetail(movieId)

            override fun saveCallResult(dbSource: MoviesItem) {
                val genres = StringBuilder().append("")
                if (!dbSource.genres.isNullOrEmpty()) {
                    for (i in dbSource.genres.indices) {
                        if (i < dbSource.genres.size - 1)
                            genres.append("${dbSource.genres[i].name}, ")
                        else
                            genres.append(dbSource.genres[i].name)
                    }
                }
                val movie = MovieEntity(
                        dbSource.id,
                        dbSource.title,
                        dbSource.posterPath,
                        dbSource.overview,
                        dbSource.releaseDate,
                        genres.toString(),
                        dbSource.budget,
                        dbSource.revenue,
                        false
                )
                localDataSource.updateMovie(movie, false)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteMovies(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(movie, state) }
    }

    override fun getTvShows(): LiveData<Resource<PagedList<TvShowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvShowEntity>, List<TvShowsItem>>(appExecutors) {
            override fun loadFromDB(): LiveData<PagedList<TvShowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(6)
                    .setPageSize(6)
                    .build()
                return LivePagedListBuilder(localDataSource.getTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvShowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShowsItem>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(dbSource: List<TvShowsItem>) {
                val tvShows = ArrayList<TvShowEntity>()
                for (data in dbSource) {
                    val genres = java.lang.StringBuilder().append("")
                    if (!data.genres.isNullOrEmpty()) {
                        for (i in data.genres.indices) {
                            if (i < data.genres.size - 1)
                                genres.append("${data.genres[i].name}, ")
                            else
                                genres.append(data.genres[i].name)
                        }
                    }
                    val tvShow = TvShowEntity(
                            data.id,
                            data.name,
                            data.posterPath,
                            data.overview,
                            data.firstAirDate,
                            genres.toString(),
                            false
                    )
                    tvShows.add(tvShow)
                }
                localDataSource.insertTvShows(tvShows)
            }
        }.asLiveData()
    }

    override fun getTvShowDetail(tvShowId: Int): LiveData<Resource<TvShowEntity>> {
        return object : NetworkBoundResource<TvShowEntity, TvShowsItem>(appExecutors) {
            override fun loadFromDB(): LiveData<TvShowEntity> =
                localDataSource.getDetailTvShows(tvShowId)

            override fun shouldFetch(data: TvShowEntity?): Boolean =
                data != null && data.genre == ""

            override fun createCall(): LiveData<ApiResponse<TvShowsItem>> =
                remoteDataSource.getTvShowDetail(tvShowId)

            override fun saveCallResult(dbSource: TvShowsItem) {
                val genres = java.lang.StringBuilder().append("")
                if (!dbSource.genres.isNullOrEmpty()) {
                    for (i in dbSource.genres.indices) {
                        if (i < dbSource.genres.size - 1)
                            genres.append("${dbSource.genres[i].name}, ")
                        else
                            genres.append(dbSource.genres[i].name)
                    }
                }
                val tvShow = TvShowEntity(
                        dbSource.id,
                        dbSource.name,
                        dbSource.posterPath,
                        dbSource.overview,
                        dbSource.firstAirDate,
                        genres.toString(),
                        false
                )
                localDataSource.updateTvShow(tvShow, false)
            }
        }.asLiveData()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<TvShowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()
        return LivePagedListBuilder(localDataSource.getFavoriteTvShows(), config).build()
    }

    override fun setFavoriteTvShow(tvShow: TvShowEntity, state: Boolean) {
        appExecutors.diskIO().execute { localDataSource.setFavoriteTvShow(tvShow, state) }
    }
}