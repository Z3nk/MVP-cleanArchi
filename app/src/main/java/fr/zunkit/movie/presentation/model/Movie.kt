package fr.zunkit.movie.presentation.model

import fr.zunkit.movie.domain.movie.model.MovieEntity

class Movie(val id: String, val name: String, val imageUrl: String, val description: String) {
    constructor(movieEntity: MovieEntity) : this(
        movieEntity.id,
        movieEntity.name,
        "https://image.tmdb.org/t/p/w500_and_h282_face/" + movieEntity.imageUrl,
        movieEntity.description
    )

    override fun equals(other: Any?): Boolean {
        return other is Movie && (other as Movie).id == id
    }
}