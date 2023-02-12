package com.example.androidprhome.presentation.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidprhome.App
import com.example.androidprhome.databinding.FragmentDetailsBinding
import com.example.androidprhome.utils.BundleConstant.EMAIL
import com.example.androidprhome.utils.BundleConstant.NAME
import com.example.androidprhome.utils.BundleConstant.PHONE
import com.example.androidprhome.utils.BundleConstant.USER_NAME
import com.example.androidprhome.utils.NavHelper.replaceGraph
import javax.inject.Inject


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
        (requireActivity().applicationContext as App).provideAppComponent().inject(this)

        detailsPresenter.setView(this)

        val bundle = arguments
        bundle?.let { safeBundle ->
            detailsPresenter.getArguments(
                safeBundle.getString(NAME),
                safeBundle.getString(USER_NAME),
                safeBundle.getString(EMAIL),
                safeBundle.getString(PHONE)
            )
        }
        viewBinding.btnLogout.setOnClickListener{
            detailsPresenter.logoutUser()
        }
    }

    override fun userLoggedOut(destination: Int) {
        replaceGraph(destination)
    }

    override fun displayItemData(name: String, userName: String, email: String, phone: String) {
        viewBinding.dName.text = name
        viewBinding.dUserName.text = userName
        viewBinding.dEmail.text = email
        viewBinding.dPhone.text = phone
    }
}