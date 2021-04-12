package tads.eaj.ufrn.segundaprovajoaogabriel.DataBase

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface MovieDAO {

    @Insert
    fun insert(movie: Movie)

    @Update
    fun update(movie: Movie): Int

    @Delete
    fun delete(movie: Movie): Int

    @Query("SELECT * FROM table_movie")
    fun listAll(): LiveData<List<Movie>>

    @Query("SELECT * FROM table_movie WHERE movieId = :movieId")
    fun findById(movieId: Int): Movie

    @Query("SELECT * FROM table_movie WHERE name = :nameMovie")
    fun findByName(nameMovie: String): Movie

}