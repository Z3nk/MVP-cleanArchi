package fr.zunkit.movie.data.movie.datasources

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import retrofit2.Call

public interface MovieRemoteDataSource{
    fun getPopularsMovie(): Call<MovieDefinitionEntity>
    fun getDetailsMovieOf(id: String): Call<MovieEntity>
}

public interface MovieLocalDataSource{

}