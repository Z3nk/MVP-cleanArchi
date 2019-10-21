package fr.zunkit.movie.presentation.details

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import fr.zunkit.movie.App
import fr.zunkit.movie.R
import fr.zunkit.movie.databinding.DetailsFragmentBinding
import fr.zunkit.movie.presentation.model.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


class DetailsFragment : Fragment(), DetailsPresenter.DetailsViewListener {
    override fun displayErrorServer() {
        Toast.makeText(activity, "Probleme avec le serveur", Toast.LENGTH_SHORT).show()
    }

    override fun displayDetailsOf(movie: Movie) {
        binding.lottieLoading.visibility = View.GONE
        Glide.with(activity!!).load(movie.imageUrl).placeholder(R.drawable.ic_placeholder)
            .into(binding.ivBackground)
        binding.tvDescription.text = movie.description
        binding.tvTitle.text = movie.name
    }

    companion object {
        const val TAG = "DetailsFragment"
    }

    lateinit var binding: DetailsFragmentBinding

    val mPresenter: DetailsPresenter by inject { parametersOf(this) }
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

        lifecycleScope.launch {
            for(i in App.publisher.openSubscription()){
                Toast.makeText(activity, "Detail : $i", Toast.LENGTH_SHORT).show()
            }
//            App.publisher.consumeEach {
//                Toast.makeText(activity, "Home : $it", Toast.LENGTH_SHORT).show()
//            }
        }
        lifecycleScope.launch {
            for (value in App.channel) {
                println(value)
            }
        }

        arguments?.getString("id")?.let {
            lifecycleScope.launch(Dispatchers.Main) {
                mPresenter.getDetailMovieOf(it)
            }
        }

    }
}
