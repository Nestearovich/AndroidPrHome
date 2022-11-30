package com.example.androidprhome.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprhome.R
import com.example.androidprhome.User.ItemsUser
import com.example.androidprhome.model.ItemsModel

class ItemsViewHolder(
    private val view: View,
    private val itemsUser: ItemsUser
) : RecyclerView.ViewHolder(view) {


    fun bind(itemsModel: ItemsModel) {

        val name = view.findViewById<TextView>(R.id.textView)
        val imageView = view.findViewById<ImageView>(R.id.imageView2)
        val about = view.findViewById<TextView>(R.id.textView2)
        val imageView2 = view.findViewById<ImageView>(R.id.imageStar)

        name.text = itemsModel.name
        imageView.setBackgroundResource(itemsModel.image)
        about.text = itemsModel.about
        imageView2.setBackgroundResource(itemsModel.image2)


        imageView.setOnClickListener {
            itemsUser.onClick()
        }

        itemView.setOnClickListener {
            itemsUser.onElementSelected(
                itemsModel.name,
                itemsModel.about,
                itemsModel.image,
                itemsModel.image2
            )
        }
    }
}