package fr.zunkit.movie.data.movie.datasources.remote

import fr.zunkit.movie.data.movie.datasources.MovieRemoteDataSource
import fr.zunkit.movie.data.movie.services.MovieApi
import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import retrofit2.Response

public class MovieRemoteDataSourceImpl(val movieApi: MovieApi) : MovieRemoteDataSource {
    override suspend fun getDetailsMovieOf(id: String): Response<MovieEntity> =  movieApi.getDetailsMovieOf(id)

    override suspend fun getPopularsMovie(): Response<MovieDefinitionEntity> = movieApi.getPopularsMovie()
}