package com.example.myapplicationmoviee.pojo

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class MovieModel {

    @SerializedName("id")
    @Expose
    var id: Int = -1
    @SerializedName("logo_path")
    @Expose
    var logoPath: String? = null
    @SerializedName("name")
    @Expose
    var name: String? = null
    @SerializedName("origin_country")
    @Expose
    var originCountry: String? = null

}