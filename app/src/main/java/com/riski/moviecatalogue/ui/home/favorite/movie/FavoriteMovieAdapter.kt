package com.riski.moviecatalogue.ui.home.favorite.movie

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.databinding.ListItemViewBinding
import com.riski.moviecatalogue.ui.detail.DetailActivity

class FavoriteMovieAdapter : PagedListAdapter<MovieEntity, FavoriteMovieAdapter.FavoriteMovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                    oldItem.movieId == newItem.movieId

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean =
                    oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: FavoriteMovieAdapter.FavoriteMovieViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteMovieAdapter.FavoriteMovieViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return FavoriteMovieViewHolder(binding)
    }

    class FavoriteMovieViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemViewBinding.bind(itemView)
        fun bind(movie: MovieEntity) {
            with(binding) {
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/original${movie.poster}")
                        .into(imgPoster)
                tvTitle.text = movie.title
                tvOverview.text = movie.overview
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, movie.movieId)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "movie")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }

}