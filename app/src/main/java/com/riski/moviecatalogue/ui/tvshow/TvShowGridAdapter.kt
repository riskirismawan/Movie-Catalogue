package com.riski.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.data.response.TvShowsItem
import com.riski.moviecatalogue.databinding.GridItemViewBinding
import com.riski.moviecatalogue.ui.detail.DetailActivity

class TvShowGridAdapter(private val tvShows: ArrayList<TvShowsItem>) :
    RecyclerView.Adapter<TvShowGridAdapter.TvShowViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding =
            GridItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        holder.bind(tvShows[position])
    }

    override fun getItemCount(): Int = tvShows.size

    class TvShowViewHolder(private val binding: GridItemViewBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowsItem) {
            with(binding) {
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/original${tvShow.posterPath}")
                    .into(poster)
                tvTitle.text = tvShow.name
                tvReleaseDate.text = tvShow.firstAirDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, tvShow.id)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "tv")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}