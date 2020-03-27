package com.example.myapplicationmoviee.base.di

import com.example.myapplicationmoviee.repository.dbInteractor.MoviesDAO
import com.example.myapplicationmoviee.retrofit.RetrofitMainInterface
import com.example.myapplicationmoviee.retrofit.RetrofitModule
import com.example.myapplicationmoviee.utills.AppDatabase
import dagger.Component
import retrofit2.Retrofit
import javax.inject.Singleton

// A dagger component to provide retrofit and room

@Singleton
@Component(modules = [RetrofitModule::class, RoomModule::class])
interface DataProvidersComponent {

    fun getRetrofit(): Retrofit

    fun getRetrofitMainInterface(): RetrofitMainInterface

    fun getAppDataBase(): AppDatabase

    fun getMoviesDAO(): MoviesDAO

}