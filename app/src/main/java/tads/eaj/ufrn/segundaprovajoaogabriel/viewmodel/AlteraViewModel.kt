@file:Suppress("DEPRECATION")

package tads.eaj.ufrn.segundaprovajoaogabriel.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.AppDataBase
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.Movie


class AlteraViewModel(application: Application) : AndroidViewModel(application) {
    lateinit var movie:Movie
    var id = 0
    var name = ""
    var genre = ""
    var yearRelease = ""
    var rating =  0.0F
    var description = ""
    var director = ""

    val db : AppDataBase by lazy {
        Room.databaseBuilder(
            application.applicationContext,
            AppDataBase::class.java,
            "Movies"
        ).build()
    }

    fun setMovie(movieId:Int) {
        id = movieId
        movie = GetAsync(db,id).execute().get()
        name = movie.name.toString()
        genre = movie.genre.toString()
        yearRelease = movie.yearRelease.toString()
        rating = movie.rating.toFloat()
        description = movie.description.toString()
        director = movie.director.toString()
    }

    fun update(){
        var movie = Movie(null, name, genre, yearRelease.toInt(), rating.toDouble(), description, director )
        UpAsync(db, movie).execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetAsync(var db:AppDataBase, var id:Int) : AsyncTask<Unit, Unit, Movie>() {
        override fun doInBackground(vararg params: Unit?): Movie {
            return db.MovieDAO().findById(id)
        }
    }

    @SuppressLint("StaticFieldLeak")
    private inner class UpAsync(var db:AppDataBase, var movie:Movie) : AsyncTask<Unit, Unit, Int>() {
        override fun doInBackground(vararg params: Unit?): Int {
            return db.MovieDAO().update(movie)
        }
    }
}