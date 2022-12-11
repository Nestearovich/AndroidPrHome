package com.example.androidprhome.presentation.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprhome.R
import com.example.androidprhome.databinding.ItemsDetailBinding
import com.example.androidprhome.presentation.adapter.User.ItemsUser
import com.example.androidprhome.model.ItemsModel

class ItemsViewHolder(
    private val viewBinding: ItemsDetailBinding,
    private val itemsUser: ItemsUser
) : RecyclerView.ViewHolder(viewBinding.root) {


    fun bind(itemsModel: ItemsModel) {

        viewBinding.textView.text = itemsModel.name
        viewBinding.imageView2.setBackgroundResource(itemsModel.image)
        viewBinding.textView2.text = itemsModel.about
        viewBinding.imageStar.setBackgroundResource(itemsModel.image2)


            viewBinding.imageView2.setOnClickListener {
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