package fr.zunkit.movie.domain.movie.model

import com.google.gson.annotations.SerializedName

public class MovieEntity(val id: String, @SerializedName("original_title") val name: String, @SerializedName("backdrop_path") val imageUrl: String, @SerializedName("overview") val description: String)