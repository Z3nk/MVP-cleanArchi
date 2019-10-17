package fr.zunkit.movie.data.movie.datasources

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import retrofit2.Call

public interface MovieRemoteDataSource{
    fun getPopularsMovie(): Call<MovieDefinitionEntity>
}

public interface MovieLocalDataSource{

}