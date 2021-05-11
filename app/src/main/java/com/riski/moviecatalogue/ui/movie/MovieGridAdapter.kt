package com.riski.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.data.MovieEntity
import com.riski.moviecatalogue.databinding.GridItemViewBinding
import com.riski.moviecatalogue.ui.detail.DetailActivity

class MovieGridAdapter : RecyclerView.Adapter<MovieGridAdapter.MovieGridViewHolder>() {
    
    private var listMovie = ArrayList<MovieEntity>()
    
    fun setMovies(movies: List<MovieEntity>) {
        if (movies == null) return
        listMovie.clear()
        listMovie.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGridViewHolder {
        val binding = GridItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieGridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieGridViewHolder, position: Int) {
        val movie = listMovie[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovie.size

    class MovieGridViewHolder(private val binding: GridItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(movie.poster)
                    .into(poster)
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, movie.movieId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}