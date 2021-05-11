package com.riski.moviecatalogue.ui.tvshow

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.data.TvShowEntity
import com.riski.moviecatalogue.databinding.GridItemViewBinding
import com.riski.moviecatalogue.ui.detail.DetailActivity

class TvShowGridAdapter : RecyclerView.Adapter<TvShowGridAdapter.TvShowViewHolder>() {

    private var listTvShows = ArrayList<TvShowEntity>()

    fun setTvShows(tvShow: List<TvShowEntity>?) {
        if (tvShow == null) return
        this.listTvShows.clear()
        this.listTvShows.addAll(tvShow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvShowViewHolder {
        val binding = GridItemViewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvShowViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TvShowViewHolder, position: Int) {
        val tvShow = listTvShows[position]
        holder.bind(tvShow)
    }

    override fun getItemCount(): Int = listTvShows.size

    class TvShowViewHolder(private val binding: GridItemViewBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(tvShow: TvShowEntity) {
            with(binding) {
                Glide.with(itemView.context)
                    .load(tvShow.poster)
                    .into(poster)
                tvTitle.text = tvShow.title
                tvReleaseDate.text = tvShow.releaseDate
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailActivity::class.java)
                    intent.putExtra(DetailActivity.EXTRA_DATA, tvShow.tvShowId)
                    itemView.context.startActivity(intent)
                }
            }
        }
    }
}