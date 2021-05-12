package com.riski.moviecatalogue.ui.home

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.databinding.ActivityHomeBinding
import com.riski.moviecatalogue.ui.movie.MovieFragment
import com.riski.moviecatalogue.ui.tvshow.TvShowFragment


class HomeActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val mFragmentManager = supportFragmentManager
        val movieFragment = MovieFragment()
        mFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container, movieFragment)
            .addToBackStack(null)
            .commit()

        binding.bottomNav.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_movie -> {
                val mFragmentManager = supportFragmentManager
                val movieFragment = MovieFragment()
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, movieFragment)
                    .addToBackStack(null)
                    .commit()
            }
            R.id.nav_tv_show -> {
                val mFragmentManager = supportFragmentManager
                val tvShowFragment = TvShowFragment()
                mFragmentManager
                    .beginTransaction()
                    .replace(R.id.fragment_container, tvShowFragment)
                    .addToBackStack(null)
                    .commit()
            }
        }
        return true
    }

}