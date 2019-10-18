package fr.zunkit.streamkilled.presentation.home

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.home.presenters.HomePresenter
import fr.zunkit.movie.presentation.model.Movie
import fr.zunkit.streamkilled.movieDefinitionEntity
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

public class HomePresenterTest {

    private lateinit var presenter: HomePresenter

    private val mockMovieInteractor: MovieInteractor = mock()
    private val mockHomeView: HomePresenter.HomeViewListener = mock()
    private val callMovie = Response.success(movieDefinitionEntity)

    @Before
    fun setUp() {
        presenter = HomePresenter(mockHomeView, mockMovieInteractor)
    }

    @Test
    fun `get movies`() {
        runBlocking {
            // given
            whenever(mockMovieInteractor.getPopularMovies()).thenReturn(callMovie)

            // when
            presenter.getPopularMovies()

            //then
            verify(mockMovieInteractor).getPopularMovies()
            verify(mockHomeView).displayMovies(movieDefinitionEntity.results.map { Movie(it) })
        }
    }
}