package fr.zunkit.movie.presentation.details

import fr.zunkit.movie.domain.movie.interactors.MovieInteractor
import fr.zunkit.movie.domain.movie.model.MovieEntity
import fr.zunkit.movie.presentation.model.Movie
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DetailsPresenter(val view: DetailsViewListener, val interactor: MovieInteractor) {
    fun getDetailMovieOf(id: String) {
        interactor.getDetailsMovieOf(id).enqueue(object : Callback<MovieEntity> {
            override fun onFailure(call: Call<MovieEntity>, t: Throwable) {
                view.displayErrorServer()
            }

            override fun onResponse(call: Call<MovieEntity>, response: Response<MovieEntity>) {
                response.body()?.let {
                    view.displayDetailsOf(Movie(it))
                }
            }


        })
    }


    interface DetailsViewListener {
        fun displayErrorServer()
        fun displayDetailsOf(movie: Movie)
    }
}