package fr.zunkit.movie.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import fr.zunkit.movie.R
import fr.zunkit.movie.presentation.home.viewholders.MovieViewHolder
import fr.zunkit.movie.presentation.model.Movie


class MovieAdapter(
    private var data: List<Movie>,
    val onClick: (movie: Movie) -> Unit
) : RecyclerView.Adapter<MovieViewHolder>() {


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = data[position]
        holder.name?.text = movie.name
        holder.container?.setOnClickListener { onClick(movie) }
        holder.background?.let {
            Glide.with(holder.itemView.context).load(movie.imageUrl).placeholder(R.drawable.ic_placeholder).into(it)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        return MovieViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.cell_movie,
                parent,
                false
            )
        )
    }

    fun refreshListWith(players: List<Movie>) {
        data = players
        notifyDataSetChanged()
    }

}