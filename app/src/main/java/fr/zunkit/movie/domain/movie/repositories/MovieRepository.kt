package fr.zunkit.movie.domain.movie.repositories

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import retrofit2.Call

interface MovieRepository {
    fun getPopularsMovie(): Call<MovieDefinitionEntity>
    suspend fun getDetailsMovieOf(id: String): MovieEntity
}