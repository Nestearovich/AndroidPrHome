package com.example.androidprhome.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModel
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentHomeBinding
import com.example.androidprhome.domain.model.UserModel
import com.example.androidprhome.presentation.auths.DisplayFragment
import com.example.androidprhome.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment(),HomeView {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var homePresenter: HomePresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homePresenter.setView(this)

        homePresenter.showUserCreds()

        binding.btnDisplay.setOnClickListener {
          homePresenter.goToDisplay()
        }

    }

    override fun showUserCreds(userModel: UserModel) {
        binding.userCreds.text = "${userModel.userName}\n${userModel.userPassword}"
    }

    override fun goToDisplay(destination: Int) {
        replaceGraph(destination)
    }
}