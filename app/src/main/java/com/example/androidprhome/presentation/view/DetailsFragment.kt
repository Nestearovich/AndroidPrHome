package com.example.androidprhome.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.androidprhome.utils.BundleConstant.KEY_ABOUT
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE2
import com.example.androidprhome.utils.BundleConstant.KEY_NAME
import com.example.androidprhome.databinding.FragmentDetailsBinding



class DetailsFragment : Fragment() {

    private var _viewBinding: FragmentDetailsBinding? = null
    private val viewBinding get() = _viewBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentDetailsBinding.inflate(inflater)
        return viewBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        


        val bundle = arguments
        bundle?.let { safeBundle ->
            val name = bundle.getString(KEY_NAME)
            val about = bundle.getString(KEY_ABOUT)
            val image = bundle.getInt(KEY_IMAGE)
            val image2 = bundle.getInt(KEY_IMAGE2)


            viewBinding.text1.text = name
            viewBinding.text2.text = about
            viewBinding.imageView.setBackgroundResource(image)
            viewBinding.imageView.setBackgroundResource(image2)
        }
    }
}