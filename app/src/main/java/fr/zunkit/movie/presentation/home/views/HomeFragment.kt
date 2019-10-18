package fr.zunkit.movie.presentation.home.views

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import fr.zunkit.movie.databinding.HomeFragmentBinding
import fr.zunkit.movie.presentation.home.adapters.MovieAdapter
import fr.zunkit.movie.presentation.home.presenters.HomePresenter
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.KoinComponent
import org.koin.core.parameter.parametersOf


class HomeFragment : Fragment(), HomePresenter.HomeViewListener , KoinComponent{
    companion object {

        const val TAG = "HomeFragment"
    }

    lateinit var binding: HomeFragmentBinding

    val mPresenter: HomePresenter by inject { parametersOf(this) }

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
        lifecycleScope.launch(Dispatchers.Main) {
            mPresenter.getPopularMovies()
        }
    }

    override fun displayErrorServer() {
        Toast.makeText(activity, "Probleme avec le serveur", Toast.LENGTH_SHORT).show()
    }

    override fun displayMovies(movies: List<Movie>) {
        binding.lottieLoading.visibility = View.GONE
        (binding.rvMovies.adapter as MovieAdapter).refreshListWith(movies)
    }
}
