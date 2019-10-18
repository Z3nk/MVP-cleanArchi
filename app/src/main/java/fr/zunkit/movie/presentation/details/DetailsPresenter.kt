package fr.zunkit.movie.presentation.details

import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailsPresenter(val view: DetailsViewListener, val interactor: MovieInteractor) {
    suspend fun getDetailMovieOf(id: String) {
//        Dispatchers.Main – Use this dispatcher to run a coroutine on the main Android thread. This should be used only for interacting with the UI and performing quick work. Examples include calling suspend functions, running Android UI framework operations, and updating LiveData objects.
//        Dispatchers.IO – This dispatcher is optimized to perform disk or network I/O outside of the main thread. Examples include using the Room component, reading from or writing to files, and running any network operations.
//        Dispatchers.Default – This dispatcher is optimized to perform CPU-intensive work outside of the main thread. Example use cases include sorting a list and parsing JSON.
        CoroutineScope(Dispatchers.IO).launch {
            val response = interactor.getDetailsMovieOf(id)
            if (response.isSuccessful) {
                val movie = Movie(response.body()!!)
                withContext(Dispatchers.Main) {
                    view.displayDetailsOf(movie)
                }
            } else {
                // CRYY
            }
        }
    }


    interface DetailsViewListener {
        fun displayErrorServer()
        fun displayDetailsOf(movie: Movie)
    }
}