package com.example.myapplicationmoviee.features.movieSearch

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.myapplicationmoviee.base.BaseViewModel
import com.example.myapplicationmoviee.pojo.MovieDatabaseEntity
import com.example.myapplicationmoviee.pojo.MovieModel
import com.example.myapplicationmoviee.pojo.MovieSearchResultModel
import com.example.myapplicationmoviee.repository.DataRepository
import com.orhanobut.logger.Logger
import io.reactivex.disposables.CompositeDisposable

class MovieSearchViewModel(private val repository: DataRepository) : BaseViewModel() {

    private val disposable = CompositeDisposable()
    private val movieSearchData = MutableLiveData<MovieSearchResultModel>()

    fun searchMovie(movieName: String) {
        disposable.add(repository.searchMovieByName(movieName).subscribe({
            movieSearchData.value = it
        }, {
            Logger.d(it)
        }))
    }

    fun saveMovie(movieModel: MovieModel) {
        val movieDatabaseEntity = MovieDatabaseEntity()
        movieDatabaseEntity.id = movieModel.id
        movieDatabaseEntity.logoPath = movieModel.logoPath
        movieDatabaseEntity.name = movieModel.name
        movieDatabaseEntity.originCountry = movieModel.originCountry
        disposable.add(
            repository.saveMovie(movieDatabaseEntity)
                .subscribe({
                    //notify view that movie is saved
                }, {
                    Logger.d(it)
                    //notify view which save movie returned an error
                })
        )
    }

    fun getMovieSearchData(): LiveData<MovieSearchResultModel> {
        return movieSearchData
    }


    override fun onCleared() {
        super.onCleared()
        disposable.clear()
    }

}