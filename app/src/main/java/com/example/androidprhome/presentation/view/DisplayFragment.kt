package com.example.androidprhome.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentDisplayBinding


class DisplayFragment : Fragment() {
    private var _viewBinding: FragmentDisplayBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDisplayBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewBinding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .commit()
        }
    }

}