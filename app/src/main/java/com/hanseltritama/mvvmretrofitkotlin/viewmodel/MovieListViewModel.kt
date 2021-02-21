package com.hanseltritama.mvvmretrofitkotlin.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.hanseltritama.mvvmretrofitkotlin.model.MovieModel
import com.hanseltritama.mvvmretrofitkotlin.network.APIService
import com.hanseltritama.mvvmretrofitkotlin.network.RetroInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListViewModel : ViewModel() {

    private val movieLiveData: MutableLiveData<List<MovieModel>> = MutableLiveData()

    fun getMovieListObserver(): MutableLiveData<List<MovieModel>> {
        return movieLiveData
    }

    fun makeApiCall() {
        val apiService: APIService? = RetroInstance.getRetrofitClient()?.create(APIService::class.java)
        val call: Call<List<MovieModel>>? = apiService?.getMovieList()
        call?.enqueue(object: Callback<List<MovieModel>> {
            override fun onResponse(
                call: Call<List<MovieModel>>,
                response: Response<List<MovieModel>>
            ) {
                movieLiveData.postValue(response.body())
            }
            override fun onFailure(call: Call<List<MovieModel>>, t: Throwable) {
                movieLiveData.postValue(null)
            }
        })
    }
}
