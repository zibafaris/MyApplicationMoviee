package com.example.myapplicationmoviee.pojo

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
class MovieDatabaseEntity {

    @PrimaryKey
    @ColumnInfo(name = "movie_id")
    var id: Int = -1

    @ColumnInfo(name = "logo_path")
    var logoPath: String? = null
    @ColumnInfo(name = "name")
    var name: String? = null
    @ColumnInfo(name = "origin_country")
    var originCountry: String? = null

}