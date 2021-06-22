package com.riski.moviecatalogue.ui.home.favorite.tvshow

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.riski.moviecatalogue.databinding.FragmentFavoriteTvShowBinding
import com.riski.moviecatalogue.utils.EspressoIdlingResource
import com.riski.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteTvShowFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteTvShowBinding
    private lateinit var viewModel: FavoriteTvShowViewModel
    private lateinit var adapter: FavoriteTvShowAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteTvShowBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, factory)[FavoriteTvShowViewModel::class.java]
        adapter = FavoriteTvShowAdapter()

        viewModel.getFavoriteTvShows().observe(viewLifecycleOwner, {tvShows ->
            adapter.submitList(tvShows)
            adapter.notifyDataSetChanged()
        })

        binding.apply {
            rvTvShowFav.layoutManager = LinearLayoutManager(requireContext())
            rvTvShowFav.setHasFixedSize(true)
            rvTvShowFav.adapter = adapter
        }
    }
}