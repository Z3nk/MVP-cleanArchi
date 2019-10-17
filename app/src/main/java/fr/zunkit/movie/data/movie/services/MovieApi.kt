package fr.zunkit.movie.data.movie.services

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface MovieApi {
    @GET("/3/discover/movie?sort_by=popularity.desc")
    fun getPosts(): Call<MovieDefinitionEntity>

    @GET("/3/movie/{id}?language=fr")
    fun getDetailsMovieOf(@Path("id")  id: String): Call<MovieEntity>
}