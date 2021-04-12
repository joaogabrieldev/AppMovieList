package tads.eaj.ufrn.segundaprovajoaogabriel.Adapters

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import tads.eaj.ufrn.segundaprovajoaogabriel.R


class MovieViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    var movieName : TextView
    var movieGenero : TextView

    init {
        movieName = v.findViewById(R.id.titleMovie)
        movieGenero = v.findViewById(R.id.GeneroName)
    }


}