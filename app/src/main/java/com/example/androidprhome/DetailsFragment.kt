package com.example.androidprhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView


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
            val name = bundle.getString("name")
            val about = bundle.getString("date")
            val image = bundle.getInt("imageView")
            val image2 = bundle.getInt("imageView2")


            detailsName.text = name
            detailsAbout.text = about
            detailsImage.setBackgroundResource(image)
            detailsImage2.setBackgroundResource(image2)
        }
    }
}