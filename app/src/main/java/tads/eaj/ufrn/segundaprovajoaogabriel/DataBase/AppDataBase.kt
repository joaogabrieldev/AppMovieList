package tads.eaj.ufrn.segundaprovajoaogabriel.DataBase

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Movie::class], version = 1)
abstract class AppDataBase : RoomDatabase() {
    abstract fun MovieDAO(): MovieDAO
}