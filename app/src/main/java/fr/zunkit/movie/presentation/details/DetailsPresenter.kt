package fr.zunkit.movie.presentation.details

import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailsPresenter(val view: DetailsViewListener, val interactor: MovieInteractor) {
    suspend fun getDetailMovieOf(id: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val movie = Movie(interactor.getDetailsMovieOf(id))
            withContext(Dispatchers.Main) {
                view.displayDetailsOf(movie)
            }
        }
    }


    interface DetailsViewListener {
        fun displayErrorServer()
        fun displayDetailsOf(movie: Movie)
    }
}