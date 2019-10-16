package fr.zunkit.movie.domain.interactors

import fr.zunkit.movie.domain.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.repositories.MovieRepository
import retrofit2.Call

public class MovieInteractor(private val movieRepository: MovieRepository) {
    fun getPopularMovies(): Call<MovieDefinitionEntity> {
        return movieRepository.getPopularsMovie()
    }

}