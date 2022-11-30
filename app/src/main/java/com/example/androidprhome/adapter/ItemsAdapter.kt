package com.example.androidprhome.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprhome.R
import com.example.androidprhome.User.ItemsUser
import com.example.androidprhome.model.ItemsModel

class ItemsAdapter(
    private val itemsUser: ItemsUser

): RecyclerView.Adapter<ItemsViewHolder>() {

    private var listItems = mutableListOf<ItemsModel>()


    fun submitList(list:List<ItemsModel>){
        this.listItems = list.toMutableList()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.items_detail,parent,false)
        return ItemsViewHolder(view,itemsUser)
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        holder.bind(listItems[position])
    }

    override fun getItemCount(): Int {
        return listItems.size
    }
}