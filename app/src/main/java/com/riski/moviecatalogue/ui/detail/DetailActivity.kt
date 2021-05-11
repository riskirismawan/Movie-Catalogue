package com.riski.moviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_DATA = "extra_data"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailViewModel::class.java]

        val extra = intent.extras
        if (extra != null) {
            val extraId = extra.getString(EXTRA_DATA)
            if (extraId != null) {
                if (extraId.substring(0, 1) == "m") {
                    viewModel.setSelectedMovie(extraId)
                    val movie = viewModel.getMovie()
                    with(binding) {
                        Glide.with(this@DetailActivity)
                            .load(movie.poster)
                            .into(poster)
                        tvDate.text = movie.releaseDate
                        tvGenreList.text = movie.genre
                        tvBudgetValue.text = movie.budget
                        tvRevenueValue.text = movie.revenue
                        tvTitle.text = movie.title
                        tvOverviewDesc.text = movie.overview
                    }
                } else {
                    viewModel.setSelectedTvShow(extraId)
                    val tvShow = viewModel.getTvShow()
                    with(binding) {
                        Glide.with(this@DetailActivity)
                            .load(tvShow.poster)
                            .into(poster)
                        tvDate.text = tvShow.releaseDate
                        tvGenreList.text = tvShow.genre
                        tvBudget.visibility = View.INVISIBLE
                        tvBudgetValue.visibility = View.INVISIBLE
                        tvRevenue.visibility = View.INVISIBLE
                        tvRevenueValue.visibility = View.INVISIBLE
                        tvTitle.text = tvShow.title
                        tvOverviewDesc.text = tvShow.overview
                    }
                }

            }
        }
    }
}