package com.riski.moviecatalogue.ui.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.data.response.MoviesItem
import com.riski.moviecatalogue.databinding.GridItemViewBinding
import com.riski.moviecatalogue.ui.detail.DetailActivity

class MovieGridAdapter(private val movies: ArrayList<MoviesItem>) : RecyclerView.Adapter<MovieGridAdapter.MovieGridViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieGridViewHolder {
        val binding = GridItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieGridViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MovieGridViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int = movies.size

    class MovieGridViewHolder(private val binding: GridItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MoviesItem) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                    .into(poster)
                tvTitle.text = movie.title
                tvReleaseDate.text = movie.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, movie.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "movie")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}