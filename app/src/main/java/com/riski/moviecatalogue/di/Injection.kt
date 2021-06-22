package com.riski.moviecatalogue.di

import android.content.Context
import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.local.LocalDataSource
import com.riski.moviecatalogue.data.source.local.room.CatalogDatabase
import com.riski.moviecatalogue.data.source.remote.RemoteDataSource
import com.riski.moviecatalogue.utils.AppExecutors

object Injection {

    fun provideCatalogueRepository(context: Context): CatalogueRepository {
        val database = CatalogDatabase.getInstance(context)
        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.catalogDao())
        val appExecutors = AppExecutors()

        return CatalogueRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}