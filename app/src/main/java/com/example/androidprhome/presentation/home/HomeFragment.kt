package com.example.androidprhome.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentHomeBinding
import com.example.androidprhome.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _viewBinding: FragmentHomeBinding? = null
    private val viewBinding get() = _viewBinding!!

    private  val viewModel: HomeViewModel by viewModels()



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.showUserData()

        viewModel.userCreds.observe(viewLifecycleOwner) {
            viewBinding.tvUserCreds.text = "${it.userName}\n${it.userPassword}"
        }

        viewBinding.btnGotoDisplay.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.activity_container, ItemsFragment())
                .commit()
        }
        viewModel.nav.observe(viewLifecycleOwner){
            if (it != null) {
                replaceGraph(it)
            }
        }

    }
}