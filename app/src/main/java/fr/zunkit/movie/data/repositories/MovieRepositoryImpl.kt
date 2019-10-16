package fr.zunkit.movie.data.repositories

import fr.zunkit.movie.data.datasources.MovieRemoteDataSource
import fr.zunkit.movie.domain.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.repositories.MovieRepository
import retrofit2.Call

public class MovieRepositoryImpl(val moveRemoteDataSource: MovieRemoteDataSource) : MovieRepository{
    override fun getPopularsMovie(): Call<MovieDefinitionEntity> {
        return moveRemoteDataSource.getPopularsMovie()
    }

}