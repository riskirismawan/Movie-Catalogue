package com.riski.moviecatalogue.ui.home.favorite

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.riski.moviecatalogue.databinding.FragmentFavoriteBinding

class FavoriteFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        context?.let { setupViewPager(it) }
    }

    private fun setupViewPager(context: Context) {
        val sectionPagerAdapter = SectionsPagerAdapter(context, childFragmentManager)
        binding.apply {
            viewFavorite.adapter = sectionPagerAdapter
            tabFavorite.setupWithViewPager(viewFavorite)
        }
    }
}