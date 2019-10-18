package fr.zunkit.movie.data.movie.repositories

import fr.zunkit.movie.data.movie.datasources.MovieRemoteDataSource
import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import fr.zunkit.movie.domain.movie.repositories.MovieRepository
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.Response

public class MovieRepositoryImpl(val moveRemoteDataSource: MovieRemoteDataSource) : MovieRepository{
    override suspend fun getDetailsMovieOf(id: String): Response<MovieEntity> = moveRemoteDataSource.getDetailsMovieOf(id)

    override suspend fun getPopularsMovie(): Response<MovieDefinitionEntity> = moveRemoteDataSource.getPopularsMovie()

}