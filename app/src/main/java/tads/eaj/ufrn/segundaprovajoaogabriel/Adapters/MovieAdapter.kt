package tads.eaj.ufrn.segundaprovajoaogabriel.Adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.Movie
import tads.eaj.ufrn.segundaprovajoaogabriel.R

class MovieAdapter:RecyclerView.Adapter<MovieViewHolder>() {
     var movies:List<Movie> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_movie_layout, parent, false)
        val holder = MovieViewHolder(view)
        return holder
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = movies[position]
        holder.movieName.text = movie.name
        holder.movieGenero.text = movie.genre
    }
}

