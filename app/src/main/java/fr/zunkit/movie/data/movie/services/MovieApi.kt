package fr.zunkit.movie.data.movie.services

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import retrofit2.Call
import retrofit2.http.GET

interface MovieApi {
    @GET("/3/discover/movie?sort_by=popularity.desc")
    fun getPosts(): Call<MovieDefinitionEntity>
}