package com.example.androidprhome.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprhome.databinding.ItemFavoritesBinding
import com.example.androidprhome.model.FavoritesModel

class FavoritesAdapter (

): RecyclerView.Adapter<FavoritesViewHolder>() {

    private var listItems = mutableListOf<FavoritesModel>()

    fun submitList(list:List<FavoritesModel>){
        this.listItems.clear()
        this.listItems = list.toMutableList()
        this.notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoritesViewHolder {
        val viewBinding = ItemFavoritesBinding.inflate(
            LayoutInflater.from(parent.context),parent,false

        )
        return FavoritesViewHolder(viewBinding)
    }

    override fun onBindViewHolder(holder: FavoritesViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}