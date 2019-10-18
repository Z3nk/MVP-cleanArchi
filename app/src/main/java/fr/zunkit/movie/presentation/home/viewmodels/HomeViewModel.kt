package fr.zunkit.movie.presentation.home.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class HomeViewModel(val interactor: MovieInteractor) : ViewModel() {
    fun getPopularMovies(): MutableLiveData<List<Movie>> {
        val oMovies = MutableLiveData<List<Movie>>()
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = interactor.getPopularMovies()
                if (response.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        response.body()?.results?.map { Movie(it) }?.let { oMovies.value = it }
                    }
                }
                else {
                    // CRY
                }
            } catch (e: Exception) {
                // CRY AGAIN
            }
        }
        return oMovies
    }
}