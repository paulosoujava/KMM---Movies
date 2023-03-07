package com.paulo.movie.di

import com.paulo.movie.data.remote.MovieService
import com.paulo.movie.data.remote.RemoteDataSource
import com.paulo.movie.data.repository.MovieRepositoryImpl
import com.paulo.movie.domain.repository.MovieRepository
import com.paulo.movie.domain.usecase.GetMovieUseCase
import com.paulo.movie.domain.usecase.GetMoviesUseCase
import com.paulo.movie.util.provideDispatcher
import org.koin.dsl.module

private val dataModule = module {
    factory { RemoteDataSource(get(), get()) }
    factory { MovieService() }
}

private val utilityModule = module {
    factory { provideDispatcher() }
}

private val domainModule = module {
    single<MovieRepository> { MovieRepositoryImpl(get()) }
    factory { GetMoviesUseCase() }
    factory { GetMovieUseCase() }
}

private val sharedModules = listOf(domainModule, dataModule, utilityModule)

fun getSharedModules() = sharedModules

