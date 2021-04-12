package tads.eaj.ufrn.segundaprovajoaogabriel.viewmodel

import android.annotation.SuppressLint
import android.app.Application
import android.os.AsyncTask
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.room.Room
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.AppDataBase
import tads.eaj.ufrn.segundaprovajoaogabriel.DataBase.Movie

@Suppress("DEPRECATION")
class HomeViewModel(application: Application) : AndroidViewModel(application) {
    var listMovies: LiveData<List<Movie>>


    init {
        val db: AppDataBase by lazy {
            Room.databaseBuilder(
                    application.applicationContext,
                    AppDataBase::class.java,
                    "Movies.sqlite"
            ).build()
        }
        listMovies = GetAllAsync(db).execute().get()
    }

    @SuppressLint("StaticFieldLeak")
    private inner class GetAllAsync(var db:AppDataBase) : AsyncTask<Unit, Unit, LiveData<List<Movie>>>() {
        override fun doInBackground(vararg params: Unit?): LiveData<List<Movie>> {
            return db.MovieDAO().listAll()
        }
    }

}