package fr.zunkit.streamkilled.data.movie.repositories

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import fr.zunkit.movie.data.movie.datasources.MovieRemoteDataSource
import fr.zunkit.movie.data.movie.repositories.MovieRepositoryImpl
import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.repositories.MovieRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

public class MovieRepositoryImplTest(){

    private lateinit var movieRepository: MovieRepository

    private val movieRemoteDataSource: MovieRemoteDataSource = mock()
    private val mockMovieDefinition : MovieDefinitionEntity = mock()
    private val callMovie = Response.success(mockMovieDefinition)
    @Before
    fun setUp() {
        movieRepository = MovieRepositoryImpl(movieRemoteDataSource)
    }

    @Test
    fun `get movies`() {
        // given
        runBlocking {

            whenever(movieRemoteDataSource.getPopularsMovie()).thenReturn(callMovie)

            // when
            movieRepository.getPopularsMovie()

            //then
            verify(movieRemoteDataSource).getPopularsMovie()
        }

    }
}