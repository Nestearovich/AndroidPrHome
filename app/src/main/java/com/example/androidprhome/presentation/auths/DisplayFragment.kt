package com.example.androidprhome.presentation.auths

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprhome.databinding.FragmentDisplayBinding
import com.example.androidprhome.presentation.home.ItemsFragment
import com.example.androidprhome.utils.NavHelper.navigate


class DisplayFragment : Fragment(), DisplayView {

    private var _viewBinding: FragmentDisplayBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var displayPresenter: DisplayPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDisplayBinding.inflate(inflater,container,false)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        displayPresenter.setView(this)

        viewBinding.btnNext.setOnClickListener {
            displayPresenter.goToItemsFragment()
        }
    }

    override fun goToItemsFragment(destination: Int) {
        navigate(destination)
    }

}