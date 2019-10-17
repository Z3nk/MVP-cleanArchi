package fr.zunkit.movie.data.movie.datasources

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import retrofit2.Call

public interface MovieRemoteDataSource{
    fun getPopularsMovie(): Call<MovieDefinitionEntity>
    suspend fun getDetailsMovieOf(id: String): MovieEntity
}

public interface MovieLocalDataSource{

}