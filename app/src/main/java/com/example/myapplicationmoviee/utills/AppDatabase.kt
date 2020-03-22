package com.example.myapplicationmoviee.utills

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplicationmoviee.pojo.MovieDatabaseEntity
import com.example.myapplicationmoviee.repository.dbInteractor.MoviesDAO

@Database(entities = [MovieDatabaseEntity::class], version = 1,exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun moviesDAO(): MoviesDAO
}