package fr.zunkit.movie.datasources.remote

import fr.zunkit.movie.data.datasources.MovieRemoteDataSource
import fr.zunkit.movie.domain.model.MovieDefinitionEntity
import retrofit2.Call

public class MovieRemoteDataSourceImpl(val movieApi: MovieApi) : MovieRemoteDataSource {
    override fun getPopularsMovie(): Call<MovieDefinitionEntity> {
        return movieApi.getPosts()
    }
}