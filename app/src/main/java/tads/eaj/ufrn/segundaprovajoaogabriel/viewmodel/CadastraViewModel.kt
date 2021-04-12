package tads.eaj.ufrn.segundaprovajoaogabriel.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.room.Room
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.AppDataBase
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.Movie

class CadastraViewModel(application: Application): AndroidViewModel(application) {
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
                "Movies.sqlite")
                .allowMainThreadQueries()
                .build()
    }

    fun saveMovie(){
        var movie = Movie(null, name, genre, yearRelease.toInt(), rating.toDouble(), description, director )
        db.MovieDAO().insert(movie)
    }
}