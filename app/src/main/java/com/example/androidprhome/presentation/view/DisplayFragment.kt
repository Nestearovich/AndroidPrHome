package com.example.androidprhome.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.NavOptions
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentDisplayBinding
import com.example.androidprhome.presentation.home.ItemsFragment
import com.example.androidprhome.utils.NavHelper.navigateWithDeletedBackStack


class DisplayFragment : Fragment() {

    private var _viewBinding: FragmentDisplayBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: DisplayViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding = FragmentDisplayBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.finishPerformed()

        viewBinding.btnNext.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .commit()
        }
        viewModel.nav.observe(viewLifecycleOwner) {
            if (it != null) {
                val navOptions = NavOptions.Builder()
                navOptions.setPopUpTo(R.id.displayFragment, true)
                navigateWithDeletedBackStack(
                    it.destinationId,
                    it.removeFragmentId
                )
            }
        }
    }
}