package fr.zunkit.streamkilled.domain.movie.interactors

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.repositories.MovieRepository
import org.junit.Before
import org.junit.Test
import retrofit2.Response
import retrofit2.mock.Calls

public class MovieInteractorTest {

    private lateinit var interactor: MovieInteractor

    private val mockMovieRepository: MovieRepository = mock()
    private val mockMovieDefinition : MovieDefinitionEntity = mock()
    private val callMovie = Calls.response(Response.success(mockMovieDefinition))
    @Before
    fun setUp() {
        interactor = MovieInteractor(mockMovieRepository)
    }

    @Test
    fun `get movies`() {
        // given
        whenever(mockMovieRepository.getPopularsMovie()).thenReturn(callMovie)

        // when
        interactor.getPopularMovies()

        //then
        verify(mockMovieRepository).getPopularsMovie()
    }
}