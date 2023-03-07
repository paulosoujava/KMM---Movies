package com.paulo.movie.data.remote

import com.paulo.movie.util.Dispatcher
import kotlinx.coroutines.withContext

internal data class RemoteDataSource(
    private val apiService: MovieService,
    private val dispatcher: Dispatcher
){
    suspend fun getMovies(page: Int) = withContext(dispatcher.io){
        apiService.getMovies(page = page)
    }
    suspend fun getMovie(movieId: Int) = withContext(dispatcher.io){
        apiService.getMovie(movieId = movieId)
    }
}
