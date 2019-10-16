package fr.zunkit.movie.domain.repositories

import fr.zunkit.movie.domain.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.model.MovieEntity
import retrofit2.Call

interface MovieRepository {
    fun getPopularsMovie(): Call<MovieDefinitionEntity>
}