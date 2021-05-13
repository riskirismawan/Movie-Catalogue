package com.riski.moviecatalogue.ui.movie

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.riski.moviecatalogue.databinding.FragmentMovieBinding
import com.riski.moviecatalogue.viewmodel.ViewModelFactory

class MovieFragment : Fragment() {

    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMovieBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance()
            val viewModel = ViewModelProvider(
                this,
                factory
            )[MovieViewModel::class.java]

            viewModel.getMovies().observe(viewLifecycleOwner, { movies ->
                binding.rvMovie.adapter = MovieGridAdapter(movies)
                binding.progressBar.visibility = View.INVISIBLE
            })

            with(binding.rvMovie) {
                layoutManager = GridLayoutManager(this@MovieFragment.context, 2)
                setHasFixedSize(true)
            }

        }
    }
}