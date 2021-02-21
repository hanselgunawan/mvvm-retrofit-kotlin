package com.hanseltritama.mvvmretrofitkotlin.model

import com.google.gson.annotations.SerializedName

data class MovieModel(val movieTitle: String, val movieList: List<String>) {

    @SerializedName("Title")
    val movieTitleName: String? = null
    @SerializedName("Images")
    val movieImageList: List<String>? = null

}
