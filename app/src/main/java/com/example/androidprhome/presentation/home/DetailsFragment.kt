package com.example.androidprhome.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidprhome.R
import com.example.androidprhome.utils.BundleConstant.KEY_ABOUT
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE2
import com.example.androidprhome.utils.BundleConstant.KEY_NAME
import com.example.androidprhome.databinding.FragmentDetailsBinding
import com.example.androidprhome.presentation.auths.LoginFragment
import com.example.androidprhome.utils.NavHelper.replaceGraph
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class DetailsFragment : Fragment(), DetailsView {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    @Inject
    lateinit var detailsPresenter: DetailsPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentDetailsBinding.inflate(inflater,container,false)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        detailsPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getString(KEY_NAME),
                safeBundle.getString(KEY_ABOUT),
                safeBundle.getInt(KEY_IMAGE),
                safeBundle.getInt(KEY_IMAGE2))



        }
        viewBinding.btnLogout.setOnClickListener{
            detailsPresenter.logoutUser()
        }
    }

    override fun userLoggedOut(destination: Int) {
        replaceGraph(destination)
    }

    override fun displayItemData(name: String, about: String, imageView: Int) {
        viewBinding.text1.text = name
        viewBinding.text2.text = about
        viewBinding.imageView.setBackgroundResource(imageView)
    }
}