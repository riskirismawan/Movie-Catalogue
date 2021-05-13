package com.riski.moviecatalogue.ui.detail

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.databinding.ActivityDetailBinding
import com.riski.moviecatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance()
        val viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        val extra = intent.extras
        if (extra != null) {
            val extraType = extra.getString(EXTRA_TYPE)
            if (extraType.equals("movie")) {
                viewModel.getMovieById(extra.getInt(EXTRA_ID)).observe(this, { movie ->
                    binding.apply {
                        Glide.with(this@DetailActivity)
                            .load("https://image.tmdb.org/t/p/original${movie.posterPath}")
                            .into(poster)
                        tvDate.text = movie.releaseDate
                        val genres = movie.genres
                        var genre: String? = null
                        for (i in genres!!.indices) {
                            genre = if (genre.isNullOrEmpty())
                                genres[i]?.name
                            else
                                "$genre, ${genres[i]?.name}"
                        }
                        tvGenreList.text = genre
                        val budget = "$" + movie.budget.toString()
                        tvBudgetValue.text = budget
                        val revenue = "$" + movie.revenue.toString()
                        tvRevenueValue.text = revenue
                        tvTitle.text = movie.title
                        tvOverviewDesc.text = movie.overview
                        progressBar.visibility = View.INVISIBLE
                    }
                })
            } else {
                viewModel.getTvById(extra.getInt(EXTRA_ID)).observe(this, { tvShow ->
                    binding.apply {
                        Glide.with(this@DetailActivity)
                            .load("https://image.tmdb.org/t/p/original${tvShow.posterPath}")
                            .into(poster)
                        tvDate.text = tvShow.firstAirDate
                        val genres = tvShow.genres
                        var genre: String? = null
                        for (i in genres!!.indices) {
                            genre = if (genre.isNullOrEmpty())
                                genres[i]?.name
                            else
                                "$genre, ${genres[i]?.name}"
                        }
                        tvGenreList.text = genre
                        tvBudget.visibility = View.INVISIBLE
                        tvBudgetValue.visibility = View.INVISIBLE
                        tvRevenue.visibility = View.INVISIBLE
                        tvRevenueValue.visibility = View.INVISIBLE
                        tvTitle.text = tvShow.name
                        tvOverviewDesc.text = tvShow.overview
                        progressBar.visibility = View.INVISIBLE
                    }
                })
            }
        }
    }
}