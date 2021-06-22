package com.riski.moviecatalogue.ui.home.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.databinding.GridItemViewBinding
import com.riski.moviecatalogue.ui.detail.DetailActivity

class TvShowGridAdapter : PagedListAdapter<TvShowEntity ,TvShowGridAdapter.TvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                oldItem.tvShowId == newItem.tvShowId

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.grid_item_view, parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    class TvShowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = GridItemViewBinding.bind(itemView)
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                Glide.with(itemView.context).clear(poster)
                Glide.with(itemView.context)
                    .load("https://image.tmdb.org/t/p/original${tvShow.poster}")
                    .into(poster)
                tvTitle.text = tvShow.title
                tvReleaseDate.text = tvShow.firstAirDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_ID, tvShow.tvShowId)
                    intent.putExtra(DetailActivity.EXTRA_TYPE, "tv")
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}