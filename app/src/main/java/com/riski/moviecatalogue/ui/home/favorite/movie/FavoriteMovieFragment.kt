package com.riski.moviecatalogue.ui.home.favorite.movie

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.riski.moviecatalogue.databinding.FragmentFavoriteMovieBinding
import com.riski.moviecatalogue.viewmodel.ViewModelFactory

class FavoriteMovieFragment : Fragment() {

    private lateinit var binding: FragmentFavoriteMovieBinding
    private lateinit var viewModel: FavoriteMovieViewModel
    private lateinit var adapter: FavoriteMovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentFavoriteMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val factory = ViewModelFactory.getInstance(requireContext())
        viewModel = ViewModelProvider(this, factory)[FavoriteMovieViewModel::class.java]
        adapter = FavoriteMovieAdapter()

        viewModel.getFavoriteMovies().observe(viewLifecycleOwner, {movies ->
            adapter.submitList(movies)
            adapter.notifyDataSetChanged()
        })

        binding.apply {
            rvMovie.layoutManager = LinearLayoutManager(requireContext())
            rvMovie.setHasFixedSize(true)
            rvMovie.adapter = adapter
        }
    }
}