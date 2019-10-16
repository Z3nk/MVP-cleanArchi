package fr.zunkit.movie.data.datasources

import fr.zunkit.movie.domain.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.model.MovieEntity
import retrofit2.Call

public interface MovieRemoteDataSource{
    fun getPopularsMovie(): Call<MovieDefinitionEntity>
}

public interface MovieLocalDataSource{

}