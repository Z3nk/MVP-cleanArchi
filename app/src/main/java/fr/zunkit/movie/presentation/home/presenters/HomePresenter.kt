package fr.zunkit.movie.presentation.home.presenters

import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.presentation.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class HomePresenter(val view: HomeViewListener, val interactor: MovieInteractor) {
    fun getPopularMovies() {
        interactor.getPopularMovies().enqueue(object : Callback<MovieDefinitionEntity> {
            override fun onFailure(call: Call<MovieDefinitionEntity>, t: Throwable) {
                view.displayErrorServer()
            }

            override fun onResponse(
                call: Call<MovieDefinitionEntity>,
                response: Response<MovieDefinitionEntity>
            ) {
                response.body()?.results?.map { Movie(it) }?.let { view.displayMovies(it) }
            }

        })
    }

    interface HomeViewListener {
        fun displayErrorServer()
        fun displayMovies(body: List<Movie>)
    }
}