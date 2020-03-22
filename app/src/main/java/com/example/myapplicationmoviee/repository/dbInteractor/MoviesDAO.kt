package com.example.myapplicationmoviee.repository.dbInteractor

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplicationmoviee.pojo.MovieDatabaseEntity
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface MoviesDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveMovie(movieDatabaseEntity: MovieDatabaseEntity): Completable

    @Query("SELECT * FROM movies")
    fun getAllMovies(): Single<List<MovieDatabaseEntity>>

    @Query("SELECT * FROM movies WHERE movie_id = :movieId LIMIT 1")
    fun getSpecificMovie(movieId: Long): Single<MovieDatabaseEntity>

    @Query("SELECT COUNT(*) > 0 from movies WHERE movie_id =:movieId")
    fun doesMovieExists(movieId: Long): Single<Boolean>

    @Query("DELETE from movies where movie_id = :movieId")
    fun removeMovie(movieId: Long): Completable
}