package fr.zunkit.movie.presentation.model

import fr.zunkit.movie.domain.movie.model.MovieEntity

class Movie(val id: String, val name: String, val imageUrl: String) {
    constructor(movieEntity: MovieEntity) : this(movieEntity.id, movieEntity.name, "https://image.tmdb.org/t/p/w500_and_h282_face/" + movieEntity.imageUrl)
}