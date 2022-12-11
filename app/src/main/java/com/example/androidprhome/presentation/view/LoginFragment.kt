package com.example.androidprhome.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {
private var _viewBinding: FragmentLoginBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _viewBinding = FragmentLoginBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewBinding.btnLogin.setOnClickListener{
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container, DisplayFragment())
                .commit()
        }
    }
}