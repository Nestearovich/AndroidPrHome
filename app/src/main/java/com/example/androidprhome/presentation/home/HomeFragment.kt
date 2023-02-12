package com.example.androidprhome.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprhome.App
import com.example.androidprhome.databinding.FragmentHomeBinding
import com.example.androidprhome.model.UserModel
import com.example.androidprhome.utils.NavHelper.replaceGraph
import javax.inject.Inject


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

        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

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