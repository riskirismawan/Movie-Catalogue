package com.riski.moviecatalogue.ui.home.favorite

import android.content.Context
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.riski.moviecatalogue.R
import com.riski.moviecatalogue.ui.home.favorite.movie.FavoriteMovieFragment
import com.riski.moviecatalogue.ui.home.favorite.tvshow.FavoriteTvShowFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter(private val mContext: Context, fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.movies, R.string.tv_shows)
    }

    override fun getItem(position: Int): Fragment =
        when (position) {
            0 -> FavoriteMovieFragment()
            1 -> FavoriteTvShowFragment()
            else -> Fragment()
        }

    override fun getPageTitle(position: Int): CharSequence = mContext.resources.getString(
        TAB_TITLES[position])

    override fun getCount(): Int = 2

}