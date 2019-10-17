package fr.zunkit.movie.data.movie.repositories

import fr.zunkit.movie.data.movie.datasources.MovieRemoteDataSource
import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import fr.zunkit.movie.domain.movie.repositories.MovieRepository
import retrofit2.Call

public class MovieRepositoryImpl(val moveRemoteDataSource: MovieRemoteDataSource) : MovieRepository{
    override fun getDetailsMovieOf(id: String): Call<MovieEntity> {
        return moveRemoteDataSource.getDetailsMovieOf(id)
    }

    override fun getPopularsMovie(): Call<MovieDefinitionEntity> {
        return moveRemoteDataSource.getPopularsMovie()
    }

}