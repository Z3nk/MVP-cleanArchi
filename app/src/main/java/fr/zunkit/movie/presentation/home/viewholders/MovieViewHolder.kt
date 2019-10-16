package fr.zunkit.movie.presentation.home.viewholders

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.zunkit.movie.R

class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    //https://image.tmdb.org/t/p/w1000_and_h563_face
    //https://image.tmdb.org/t/p/w1000_and_h563_face/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg
    val container: View? = itemView.findViewById(R.id.container)
    val name: TextView? = itemView.findViewById(R.id.tv_name)
    val background: ImageView? = itemView.findViewById(R.id.iv_background)
}