package fr.zunkit.movie.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.zunkit.movie.databinding.HomeFragmentBinding


class HomeFragment : Fragment(), HomePresenter.HomeViewListener {

    companion object {
        const val TAG = "HomeFragment"
    }

    lateinit var binding: HomeFragmentBinding

    val mPresenter by lazy { HomePresenter(this) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        subscribeUI()
        return binding.root
    }

    private fun subscribeUI() {
    }
}
