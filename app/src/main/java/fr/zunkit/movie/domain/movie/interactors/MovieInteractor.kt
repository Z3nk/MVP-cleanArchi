package fr.zunkit.movie.domain.movie.interactors

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import fr.zunkit.movie.domain.movie.repositories.MovieRepository
import retrofit2.Response

public class MovieInteractor(private val movieRepository: MovieRepository) {
    suspend fun getPopularMovies(): Response<MovieDefinitionEntity> = movieRepository.getPopularsMovie()

    suspend fun getDetailsMovieOf(id: String): Response<MovieEntity> = movieRepository.getDetailsMovieOf(id)

}