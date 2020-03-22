package com.example.myapplicationmoviee.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieSearchResultModel {

    @SerializedName("page")
    @Expose
    var page: Int? = null
    @SerializedName("results")
    @Expose
    var movies: List<MovieModel>? = null
    @SerializedName("total_pages")
    @Expose
    var totalPages: Int? = null
    @SerializedName("total_results")
    @Expose
    var totalResults: Int? = null

}