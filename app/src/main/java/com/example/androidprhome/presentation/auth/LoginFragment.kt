package com.example.androidprhome.presentation.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentLoginBinding
import com.example.androidprhome.presentation.home.HomeFragment
import com.example.androidprhome.presentation.home.ItemsFragment
import com.example.androidprhome.presentation.view.DisplayFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {


private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.nav.observe(viewLifecycleOwner) {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, HomeFragment())
                .commit()
        }

        viewBinding.btnLogin.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .commit()
        }
        }
    }
