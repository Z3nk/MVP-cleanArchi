package fr.zunkit.movie.presentation.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import fr.zunkit.movie.R
import fr.zunkit.movie.databinding.DetailsFragmentBinding
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel


class DetailsFragment : Fragment() {
    companion object {
        const val TAG = "DetailsFragment"
    }

    lateinit var binding: DetailsFragmentBinding

    private val vm: DetailsViewModel by viewModel()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.d(TAG, "onCreateView")
        binding = DetailsFragmentBinding.inflate(inflater, container, false)
        subscribeUI()
        return binding.root
    }

    private fun subscribeUI() {
        arguments?.getString("id")?.let {
            lifecycleScope.launch(Dispatchers.Main) {
                vm.getDetailMovieOf(it).observe(
                    viewLifecycleOwner,
                    onDetailMovie()
                )
            }
        }
    }

    private fun onDetailMovie(): Observer<Movie> {
        return Observer { movie ->
            movie?.let {
                binding.lottieLoading.visibility = View.GONE
                Glide.with(activity!!).load(it.imageUrl)
                    .placeholder(R.drawable.ic_placeholder)
                    .into(binding.ivBackground)
                binding.tvDescription.text = it.description
                binding.tvTitle.text = it.name
            }
        }
    }
}
