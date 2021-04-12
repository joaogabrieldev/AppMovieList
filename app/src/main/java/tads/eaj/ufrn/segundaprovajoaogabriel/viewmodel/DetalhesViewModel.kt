package tads.eaj.ufrn.segundaprovajoaogabriel.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.AppDataBase
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.Movie

@Suppress("DEPRECATION")
class DetalhesViewModel(application: Application) : AndroidViewModel(application){

    var name: String? = ""
    var genre: String? = ""
    var yearRelease: String =  ""
    var rating = ""
    var description: String? = ""
    var director: String? = ""

    val db: AppDataBase by lazy {
        Room.databaseBuilder(
                application.applicationContext,
                AppDataBase::class.java,
                "Movies.sqlite"
        ).build()
    }

    fun setDadosMovie(id: Int){
        var movie = GetAsync(db, id).execute().get()
        name = movie.name
        genre = movie.genre
        yearRelease = movie.yearRelease.toString()
        rating = movie.rating.toString()
        description = movie.description
        director = movie.director
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetAsync(var db:AppDataBase, var id:Int) : AsyncTask<Unit, Unit, Movie>() {
        override fun doInBackground(vararg params: Unit?): Movie {
            return db.MovieDAO().findById(id)
        }
    }

}