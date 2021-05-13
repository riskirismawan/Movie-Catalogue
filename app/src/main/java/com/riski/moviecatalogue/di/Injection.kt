package com.riski.moviecatalogue.di

import com.riski.moviecatalogue.data.source.CatalogueRepository
import com.riski.moviecatalogue.data.source.remote.RemoteDataSource

object Injection {

    fun provideCatalogueRepository(): CatalogueRepository {
        val remoteDataSource = RemoteDataSource.getInstance()
        return CatalogueRepository.getInstance(remoteDataSource) as CatalogueRepository
    }
}