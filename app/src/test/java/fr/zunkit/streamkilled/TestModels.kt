package fr.zunkit.streamkilled

import fr.zunkit.movie.domain.movie.model.MovieDefinitionEntity
import fr.zunkit.movie.domain.movie.model.MovieEntity
import fr.zunkit.movie.presentation.model.Movie

val movie = Movie("475557", "Joker", "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg", "Bla bla bla")
val movieEntity = MovieEntity("475557", "Joker", "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg", "Bla bla bla")
val moviesEntitiesList = listOf(movieEntity)
val movieDefinitionEntity = MovieDefinitionEntity(2, 100, 5, moviesEntitiesList)
