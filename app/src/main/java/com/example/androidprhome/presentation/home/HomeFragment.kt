package com.example.androidprhome.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentHomeBinding
import com.example.androidprhome.presentation.auths.DisplayFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    private val viewModel: HomeViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.showUserData()

        binding.btnDisplay.setOnClickListener {
            parentFragmentManager.beginTransaction()
                .replace(R.id.activity_container,DisplayFragment())
                .commit()
        }
        viewModel.userCreds.observe(viewLifecycleOwner){
            binding.userCreds.text = "${it.userName}\n${it.userPassword}"
        }
    }
}