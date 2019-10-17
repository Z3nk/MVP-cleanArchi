package fr.zunkit.movie.presentation.details

import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.model.Movie


class DetailsPresenter(val view: DetailsViewListener, val interactor: MovieInteractor) {
    suspend fun getDetailMovieOf(id: String) =
        view.displayDetailsOf(Movie(interactor.getDetailsMovieOf(id)))


    interface DetailsViewListener {
        fun displayErrorServer()
        fun displayDetailsOf(movie: Movie)
    }
}