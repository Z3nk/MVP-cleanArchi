package fr.zunkit.movie.domain.movie.model

import com.google.gson.annotations.SerializedName

public class MovieDefinitionEntity(val page: Int, @SerializedName("total_results") val total: Int, @SerializedName("total_pages") val pages: Int, val results: List<MovieEntity>)