package com.example.myapplicationmoviee.base.di

import androidx.room.Room
import com.example.myapplicationmoviee.base.BaseApplication
import com.example.myapplicationmoviee.repository.dbInteractor.MoviesDAO
import com.example.myapplicationmoviee.utills.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RoomModule(private val baseApplication: BaseApplication) {

    @Singleton
    @Provides
    fun database(): AppDatabase {
        return Room.databaseBuilder(baseApplication.applicationContext, AppDatabase::class.java, "movies.db").build()

    }

    @Singleton
    @Provides
    fun provideMoviesDAO(appDatabase: AppDatabase): MoviesDAO {
        return appDatabase.moviesDAO()
    }

}