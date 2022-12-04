package com.example.androidprhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView

const val KEY_NAME = "name"
const val  KEY_ABOUT = "about"
const val  KEY_IMAGE = "imageView"
const val  KEY_IMAGE2 = "imageView"

class DetailsFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_details, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val detailsName = view.findViewById<TextView>(R.id.text1)
        val detailsAbout = view.findViewById<TextView>(R.id.text2)
        val detailsImage = view.findViewById<ImageView>(R.id.imageView)
        val detailsImage2 = view.findViewById<ImageView>(R.id.imageStar)


        val bundle = arguments
        bundle?.let{ safeBundle ->
            val name = bundle.getString(KEY_NAME)
            val about = bundle.getString(KEY_ABOUT)
            val image = bundle.getInt(KEY_IMAGE)
            val image2 = bundle.getInt(KEY_IMAGE2)


            detailsName.text = name
            detailsAbout.text = about
            detailsImage.setBackgroundResource(image)
            detailsImage2.setBackgroundResource(image2)
        }
    }
}