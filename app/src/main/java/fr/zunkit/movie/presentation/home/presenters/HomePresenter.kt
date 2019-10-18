package fr.zunkit.movie.presentation.home.presenters

import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomePresenter(val view: HomeViewListener, val interactor: MovieInteractor) {
    fun getPopularMovies() {
        try {
            CoroutineScope(Dispatchers.IO).launch {
                val response = interactor.getPopularMovies()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        response.body()?.results?.map { Movie(it) }?.let { view.displayMovies(it) }
                    }
                } else {
                    view.displayErrorServer()
                }
            }
        } catch (e: Exception) {
            view.displayErrorServer()
        }
    }

    interface HomeViewListener {
        fun displayErrorServer()
        fun displayMovies(body: List<Movie>)
    }
}