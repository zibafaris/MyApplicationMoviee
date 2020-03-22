package com.example.myapplicationmoviee.features.movieSearch

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationmoviee.R
import com.example.myapplicationmoviee.pojo.MovieModel
import com.example.myapplicationmoviee.pojo.MovieSearchResultModel

class MovieRecyclerAdapter (private val onItemClick: (MovieModel)->Unit): RecyclerView.Adapter<MovieItemViewHolder>() {

    private var movieTMDBClass =  MovieSearchResultModel()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.movie_item_layout,parent,false)
        return MovieItemViewHolder(view)
    }

    override fun getItemCount(): Int = movieTMDBClass.movies?.size ?: 0

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movieTMDBClass.movies!![position],onItemClick)
    }

    fun setMovieSearchResult(movieSearchResultModel: MovieSearchResultModel){
        this.movieTMDBClass = movieSearchResultModel
        notifyDataSetChanged()
    }
}