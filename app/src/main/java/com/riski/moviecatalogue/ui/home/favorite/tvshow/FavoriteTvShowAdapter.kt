package com.riski.moviecatalogue.ui.home.favorite.tvshow

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
import com.riski.moviecatalogue.databinding.ListItemViewBinding
import com.riski.moviecatalogue.ui.detail.DetailActivity

class FavoriteTvShowAdapter : PagedListAdapter<TvShowEntity, FavoriteTvShowAdapter.FavoriteTvShowViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvShowEntity>() {
            override fun areItemsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                    oldItem.tvShowId == newItem.tvShowId

            override fun areContentsTheSame(oldItem: TvShowEntity, newItem: TvShowEntity): Boolean =
                    oldItem == newItem
        }
    }

    override fun onBindViewHolder(holder: FavoriteTvShowAdapter.FavoriteTvShowViewHolder, position: Int) {
        getItem(position)?.let { holder.bind(it) }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteTvShowAdapter.FavoriteTvShowViewHolder {
        val binding = LayoutInflater.from(parent.context).inflate(R.layout.list_item_view, parent, false)
        return FavoriteTvShowViewHolder(binding)
    }

    class FavoriteTvShowViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        private val binding = ListItemViewBinding.bind(itemView)
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                Glide.with(itemView.context)
                        .load("https://image.tmdb.org/t/p/original${tvShow.poster}")
                        .into(imgPoster)
                tvTitle.text = tvShow.title
                tvOverview.text = tvShow.overview
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