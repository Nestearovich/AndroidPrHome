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

        viewBinding.tvId.text = "${itemsModel.id}"
        viewBinding.tvName.text = itemsModel.name
        viewBinding.tvUserName.text = itemsModel.userName
        viewBinding.tvEmail.text = itemsModel.email
        viewBinding.tvStreet.text = itemsModel.street
        viewBinding.tvSuite.text = itemsModel.suite
        viewBinding.tvCity.text = itemsModel.city
        viewBinding.tvZipcode.text = itemsModel.zipcode
        viewBinding.tvLat.text = itemsModel.lat
        viewBinding.tvLng.text = itemsModel.lng
        viewBinding.tvPhone.text = itemsModel.phone
        viewBinding.tvWebsite.text = itemsModel.website
        viewBinding.tvCompanyName.text = itemsModel.companyName
        viewBinding.tvCatchPhrase.text = itemsModel.catchPhrase
        viewBinding.tvBs.text = itemsModel.bs


//            viewBinding.imageView2.setOnClickListener {
//            itemsUser.onClick()
//        }

        itemView.setOnClickListener {
            itemsUser.onElementSelected(
                itemsModel.id,
                itemsModel.name,
                itemsModel.userName,
                itemsModel.email,
                itemsModel.street,
                itemsModel.suite,
                itemsModel.city,
                itemsModel.zipcode,
                itemsModel.lat,
                itemsModel.lng,
                itemsModel.phone,
                itemsModel.website,
                itemsModel.companyName,
                itemsModel.catchPhrase,
                itemsModel.bs,
            )
        }
    }
}