package com.paulo.movie.data.repository

import com.paulo.movie.data.mapper.toMovie
import com.paulo.movie.data.remote.RemoteDataSource
import com.paulo.movie.domain.model.Movie
import com.paulo.movie.domain.repository.MovieRepository

internal  class MovieRepositoryImpl(
    private val  dataSource: RemoteDataSource
): MovieRepository {
    override suspend fun getMovies(page: Int): List<Movie> {
        return dataSource.getMovies(page).results.map { it.toMovie() }
    }

    override suspend fun getMovie(movieId: Int): Movie {
        return dataSource.getMovie(movieId).toMovie()
    }
}