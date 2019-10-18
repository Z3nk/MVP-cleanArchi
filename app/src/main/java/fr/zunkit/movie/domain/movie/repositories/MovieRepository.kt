package fr.zunkit.movie.domain.movie.repositories

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import retrofit2.Response

interface MovieRepository {
    suspend fun getPopularsMovie(): Response<MovieDefinitionEntity>
    suspend fun getDetailsMovieOf(id: String): Response<MovieEntity>
}