package com.hanseltritama.mvvmretrofitkotlin.network

import com.hanseltritama.mvvmretrofitkotlin.model.MovieModel
import retrofit2.Call
import retrofit2.http.GET

interface APIService {

    @GET("Film.JSON")
    fun getMovieList(): Call<List<MovieModel>>
}
