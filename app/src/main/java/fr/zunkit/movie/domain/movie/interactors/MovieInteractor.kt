package fr.zunkit.movie.domain.movie.interactors

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import fr.zunkit.movie.domain.movie.repositories.MovieRepository
import retrofit2.Call

public class MovieInteractor(private val movieRepository: MovieRepository) {
    fun getPopularMovies(): Call<MovieDefinitionEntity> {
        return movieRepository.getPopularsMovie()
    }

    fun getDetailsMovieOf(id: String): Call<MovieEntity> {
        return movieRepository.getDetailsMovieOf(id)
    }

}