package com.riski.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.data.source.local.entity.MovieEntity
import com.riski.moviecatalogue.data.source.local.entity.TvShowEntity
import com.riski.moviecatalogue.databinding.ActivityDetailBinding
import com.riski.moviecatalogue.viewmodel.ViewModelFactory

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_ID = "extra_id"
        const val EXTRA_TYPE = "extra_type"
    }

    private lateinit var binding: ActivityDetailBinding
    private lateinit var viewModel: DetailViewModel
    private var extraType: String = ""
    private var extraId: Int = 0
    private var movieEntity: MovieEntity? = null
    private var tvShowEntity: TvShowEntity? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailViewModel::class.java]

        showLoading(true, extraType)

        val extra = intent.extras
        if (extra != null) {
            extraType = extra.getString(EXTRA_TYPE).toString()
            extraId = extra.getInt(EXTRA_ID)

            if (extraType == "movie") {
                viewModel.getMovieById(extraId)
                viewModel.getMovie().observe(this, { movie ->
                    if (movie.data != null) {
                        movieEntity = movie.data

                        binding.apply {
                            Glide.with(this@DetailActivity)
                                    .load("https://image.tmdb.org/t/p/original${movie.data.poster}")
                                    .into(poster)

                            tvDate.text = movie.data.releaseDate
                            tvGenreList.text = movie.data.genre
                            val budget = "$" + movie.data.budget.toString()
                            tvBudgetValue.text = budget
                            val revenue = "$" + movie.data.revenue.toString()
                            tvRevenueValue.text = revenue
                            tvTitle.text = movie.data.title
                            tvOverviewDesc.text = movie.data.overview
                            showLoading(false, extraType)
                        }
                    }
                })
            } else {
                viewModel.getTvShowById(extraId)
                viewModel.getTvShow().observe(this, { tvShow ->
                    if (tvShow.data != null) {
                        tvShowEntity = tvShow.data
                        binding.apply {
                            Glide.with(this@DetailActivity)
                                    .load("https://image.tmdb.org/t/p/original${tvShow.data.poster}")
                                    .into(poster)

                            tvDate.text = tvShow.data.firstAirDate
                            tvGenreList.text = tvShow.data.genre
                            tvTitle.text = tvShow.data.title
                            tvOverviewDesc.text = tvShow.data.overview
                            showLoading(false, extraType)
                        }
                    }
                })
            }
        }
    }

    private fun setFavorite(item: MenuItem) {
        when {
            movieEntity != null -> {
                if (movieEntity!!.isFavorite) {
                    Toast.makeText(this, "${movieEntity!!.title} remove from favorite", Toast.LENGTH_SHORT).show()
                    setFavoriteIcon(movieEntity!!.isFavorite, item)
                    viewModel.setFavoriteMovie()
                } else {
                    Toast.makeText(this, "${movieEntity!!.title} add to favorite", Toast.LENGTH_SHORT).show()
                    setFavoriteIcon(movieEntity!!.isFavorite, item)
                    viewModel.setFavoriteMovie()
                }
            }
            tvShowEntity != null -> {
                if (tvShowEntity!!.isFavorite) {
                    Toast.makeText(this, "${tvShowEntity!!.title} remove from favorite", Toast.LENGTH_SHORT).show()
                    setFavoriteIcon(tvShowEntity!!.isFavorite, item)
                    viewModel.setFavoriteTvShow()
                } else {
                    Toast.makeText(this, "${tvShowEntity!!.title} add to favorite", Toast.LENGTH_SHORT).show()
                    setFavoriteIcon(tvShowEntity!!.isFavorite, item)
                    viewModel.setFavoriteTvShow()
                }
            }
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.nav_menu, menu)

        if (extraType == "movie") {
            viewModel.getMovie().observe(this, { movie ->
                if (movie.data?.isFavorite == true)
                    menu?.getItem(0)?.icon = resources.getDrawable(R.drawable.ic_baseline_favorite_24)
                else
                    menu?.getItem(0)?.icon = resources.getDrawable(R.drawable.ic_baseline_favorite_border_24)
            })
        } else {
            viewModel.getTvShow().observe(this, { tvShow ->
                if (tvShow.data?.isFavorite == true)
                    menu?.getItem(0)?.icon = resources.getDrawable(R.drawable.ic_baseline_favorite_24)
                else
                    menu?.getItem(0)?.icon = resources.getDrawable(R.drawable.ic_baseline_favorite_border_24)
            })
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.favorite -> {
                setFavorite(item)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @Suppress("DEPRECATION")
    @SuppressLint("UseCompatLoadingForDrawables")
    private fun setFavoriteIcon(isFavorite: Boolean, item: MenuItem) {
        if (!isFavorite)
            item.icon = resources.getDrawable(R.drawable.ic_baseline_favorite_24)
        else
            item.icon = resources.getDrawable(R.drawable.ic_baseline_favorite_border_24)
    }

    private fun showLoading(state: Boolean, extraType: String) {
        binding.apply {
            if (state) {
                tvReleaseDate.visibility = View.INVISIBLE
                tvDate.visibility = View.INVISIBLE
                tvGenre.visibility = View.INVISIBLE
                tvGenreList.visibility = View.INVISIBLE
                tvBudget.visibility = View.INVISIBLE
                tvBudgetValue.visibility = View.INVISIBLE
                tvRevenue.visibility = View.INVISIBLE
                tvRevenueValue.visibility = View.INVISIBLE
                tvTitle.visibility = View.INVISIBLE
                tvOverview.visibility = View.INVISIBLE
                tvOverviewDesc.visibility = View.INVISIBLE
                progressBar.visibility = View.VISIBLE
            } else {
                if (extraType == "movie") {
                    tvReleaseDate.visibility = View.VISIBLE
                    tvDate.visibility = View.VISIBLE
                    tvGenre.visibility = View.VISIBLE
                    tvGenreList.visibility = View.VISIBLE
                    tvBudget.visibility = View.VISIBLE
                    tvBudgetValue.visibility = View.VISIBLE
                    tvRevenue.visibility = View.VISIBLE
                    tvRevenueValue.visibility = View.VISIBLE
                    tvTitle.visibility = View.VISIBLE
                    tvOverview.visibility = View.VISIBLE
                    tvOverviewDesc.visibility = View.VISIBLE
                    progressBar.visibility = View.INVISIBLE
                } else {
                    tvReleaseDate.visibility = View.VISIBLE
                    tvDate.visibility = View.VISIBLE
                    tvGenre.visibility = View.VISIBLE
                    tvGenreList.visibility = View.VISIBLE
                    tvTitle.visibility = View.VISIBLE
                    tvOverview.visibility = View.VISIBLE
                    tvOverviewDesc.visibility = View.VISIBLE
                    progressBar.visibility = View.INVISIBLE
                }
            }
        }
    }
}