package tads.eaj.ufrn.segundaprovajoaogabriel.DataBase

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "Table_Movie")
data class Movie(
        @PrimaryKey(autoGenerate = true)
        val movieId: Int?,
        var name: String?,
        var genre: String?,
        var yearRelease: Int?,
        var rating: Double,
        var description: String?,
        var director: String?

) {

}