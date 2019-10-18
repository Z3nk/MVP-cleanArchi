package fr.zunkit.movie.presentation.home.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import fr.zunkit.movie.databinding.HomeFragmentBinding
import fr.zunkit.movie.presentation.home.adapters.MovieAdapter
import fr.zunkit.movie.presentation.home.viewmodels.HomeViewModel
import fr.zunkit.movie.presentation.model.Movie
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.KoinComponent


class HomeFragment : Fragment(), KoinComponent {
    companion object {

        const val TAG = "HomeFragment"
    }

    lateinit var binding: HomeFragmentBinding

    private val vm: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        initBindings()

        return binding.root
    }

    private fun initBindings() {
        binding.rvMovies.apply {
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity, 2)
            adapter = MovieAdapter(ArrayList()) {
                Navigation.findNavController(this).navigate(
                    HomeFragmentDirections.actionHomeFragmentToDetailsFragment(
                        it.id, it.name
                    )
                )
            }
        }
        vm.getPopularMovies().observe(viewLifecycleOwner, object : Observer<List<Movie>> {
            override fun onChanged(movies: List<Movie>?) {
                binding.lottieLoading.visibility = View.GONE
                (binding.rvMovies.adapter as MovieAdapter).refreshListWith(movies!!)
            }

        })
    }
}
