package com.hanseltritama.mvvmretrofitkotlin.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.hanseltritama.mvvmretrofitkotlin.R
import com.hanseltritama.mvvmretrofitkotlin.model.MovieModel
import kotlinx.android.synthetic.main.recycler_row.view.*

class MovieListAdapter(
    private val context: Context,
    private var movieList: List<MovieModel>,
    private val clickListener: ItemClickListener
)
    : RecyclerView.Adapter<MovieListAdapter.MyViewHolder>(){

    fun updateMovieList(movieListFromActivity: List<MovieModel>) {
        movieList = movieListFromActivity
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.movieTextView.text = movieList[position].movieTitleName
        holder.itemView.setOnClickListener { 
            clickListener.onMovieClick(movieList[position])
        }
        Glide.with(context)
            .load(movieList[position].movieImageList?.get(0))
            .apply(RequestOptions.centerCropTransform())
            .into(holder.movieImage)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val movieTextView: TextView = itemView.movie_title
        val movieImage: ImageView = itemView.movie_image
    }

    interface ItemClickListener {
        fun onMovieClick(movie: MovieModel)
    }
}