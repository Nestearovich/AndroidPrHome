package com.example.androidprhome.presentation.auths

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprhome.App
import com.example.androidprhome.databinding.FragmentDisplayBinding
import com.example.androidprhome.utils.NavHelper.navigate
import javax.inject.Inject


class DisplayFragment : Fragment(), DisplayView {

    private var _viewBinding: FragmentDisplayBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var displayPresenter:DisplayPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDisplayBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        displayPresenter.setView(this)

        viewBinding.btnNext.setOnClickListener {
            displayPresenter.goToItemsFragment()
        }
    }

    override fun goToItemsFragment(destination: Int) {
        navigate(destination)
    }

}