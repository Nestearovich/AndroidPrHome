package com.example.androidprhome.presentation.home.adapter

import android.net.Uri
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprhome.databinding.ItemFavoritesBinding
import com.example.androidprhome.model.FavoritesModel
import com.squareup.picasso.Picasso

class FavoritesViewHolder(
    private val viewBinding: ItemFavoritesBinding,

    ): RecyclerView.ViewHolder(viewBinding.root) {

    fun bind(favItems: FavoritesModel){
        viewBinding.tvName.text = favItems.name
        Picasso.get().load(Uri.parse(favItems.name)).into(viewBinding.image)

    }
}