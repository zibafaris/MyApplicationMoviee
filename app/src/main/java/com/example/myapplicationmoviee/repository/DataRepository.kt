package com.example.myapplicationmoviee.repository

import com.example.myapplicationmoviee.base.BaseApplication
import com.example.myapplicationmoviee.pojo.MovieDatabaseEntity
import com.example.myapplicationmoviee.pojo.MovieSearchResultModel
import com.example.myapplicationmoviee.repository.dbInteractor.MoviesDAO
import com.example.myapplicationmoviee.repository.di.DaggerDataProviderComponent
import com.example.myapplicationmoviee.repository.networkInteractor.NetworkInteractor
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DataRepository @Inject constructor() {

    private var network: NetworkInteractor
    private var database: MoviesDAO

    init {
        val component = DaggerDataProviderComponent.builder()
            .dataProvidersComponent(BaseApplication.getDataProviderComponent()).build()

        network = component.getNetworkInteractor()
        database = component.getDbInteractor()
    }

    fun searchMovieByName(movieName: String): Observable<MovieSearchResultModel> {
        return network.searchMovieByName(movieName)
    }

    fun getMovieDetails(movieId: Long): Observable<Any> {
        return network.getMovieDetails(movieId)
    }

    fun getAllSavedMovies(): Single<List<MovieDatabaseEntity>> {
        return database.getAllMovies()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun saveMovie(movieDatabaseEntity: MovieDatabaseEntity): Completable {
        return database.saveMovie(movieDatabaseEntity)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun doesMovieExists(movieId: Long): Single<Boolean> {
        return database.doesMovieExists(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun removeMovie(movieId: Long): Completable {
        return database.removeMovie(movieId)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}