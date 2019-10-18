package fr.zunkit.movie.presentation.home.presenters

import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.model.Movie


class HomePresenter(val view: HomeViewListener, val interactor: MovieInteractor) {
    suspend fun getPopularMovies() {
        try {
            val response = interactor.getPopularMovies()
            if (response.isSuccessful) {
                response.body()?.results?.map { Movie(it) }?.let { view.displayMovies(it) }
            } else {
                view.displayErrorServer()
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