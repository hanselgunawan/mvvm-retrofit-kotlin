package com.hanseltritama.mvvmretrofitkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.hanseltritama.mvvmretrofitkotlin.adapter.MovieListAdapter
import com.hanseltritama.mvvmretrofitkotlin.model.MovieModel
import com.hanseltritama.mvvmretrofitkotlin.viewmodel.MovieListViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MovieListAdapter.ItemClickListener {

    private var movieList: List<MovieModel> = ArrayList()
    private var adapter: MovieListAdapter? = null
    private val movieListViewModel by lazy {
        ViewModelProvider(this).get(MovieListViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUI()
        setupObservers()
        movieListViewModel.makeApiCall()
    }

    private fun setupUI() {
        val layoutManager: LinearLayoutManager = GridLayoutManager(this, 1)
        adapter = MovieListAdapter(this, movieList, this)
        movie_recycler_view.layoutManager = layoutManager
        movie_recycler_view.adapter = adapter
    }

    private fun setupObservers() {
        movieListViewModel.getMovieListObserver().observe(this, Observer<List<MovieModel>> {
            if (it != null) {
                movieList = it
                adapter?.updateMovieList(it)
                no_result_text.visibility = View.GONE
            } else {
                no_result_text.visibility = View.VISIBLE
            }
        })
    }

    override fun onMovieClick(movie: MovieModel) {
        Toast.makeText(this, "Movie Name: " + movie.movieTitleName, Toast.LENGTH_SHORT).show()
    }
}