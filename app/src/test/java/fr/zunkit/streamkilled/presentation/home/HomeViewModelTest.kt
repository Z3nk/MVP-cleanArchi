package fr.zunkit.streamkilled.presentation.home

import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.home.viewmodels.HomeViewModel
import fr.zunkit.streamkilled.movieDefinitionEntity
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import retrofit2.Response

public class HomeViewModelTest {

    private lateinit var vm: HomeViewModel

    private val mockMovieInteractor: MovieInteractor = mock {
        onBlocking() {
            getPopularMovies()
        } doReturn callMovie
    }
    private val callMovie = Response.success(movieDefinitionEntity)

    @Before
    fun setUp() {
        vm = HomeViewModel(mockMovieInteractor)
    }

    @Test
    fun `get movies`() {

        // when
        vm.getPopularMovies()

        //then
        runBlocking {
            verify(mockMovieInteractor).getPopularMovies()
        }
    }
}