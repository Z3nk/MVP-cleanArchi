package fr.zunkit.movie.presentation.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DetailsViewModel(val interactor: MovieInteractor): ViewModel() {


    suspend fun getDetailMovieOf(id: String): MutableLiveData<Movie> {
        val oMovie = MutableLiveData<Movie>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = interactor.getDetailsMovieOf(id)
                if (response.isSuccessful) {
                    val movie = Movie(response.body()!!)
                    withContext(Dispatchers.Main) {
                        oMovie.value = movie
                    }
                } else {
                    // CRYY
                }
            }catch (e: Exception){
                // CRY AGAIN !!
            }
        }

        return oMovie;
    }
}