package com.paulo.movie.domain.repository

import com.paulo.movie.domain.model.Movie


internal interface MovieRepository {
    suspend fun getMovies(page: Int): List<Movie>

    suspend fun getMovie(movieId: Int): Movie
}