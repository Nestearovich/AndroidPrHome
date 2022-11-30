package com.example.androidprhome

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.androidprhome.User.ItemsUser
import com.example.androidprhome.adapter.ItemsAdapter
import com.example.androidprhome.model.ItemsModel


class ItemsFragment : Fragment(),ItemsUser {
    private lateinit var itemsAdapter: ItemsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_items, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        recyclerView.adapter = itemsAdapter

        val listItems = listOf<ItemsModel>(
            ItemsModel(
                R.drawable.iavengers,
            "Avengers",
            "First",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.iavengers,
                "Avengers 2",
                "Age Altron",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.iavengers,
                "Avengers 3",
                "Infinity War",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.iavengers,
                "Avengers 4",
                "End",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.spider,
                "Spider-man",
                "Homecoming",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.spider2,
                "Spider-man 2",
                "Far from home",
                R.drawable.star
            ),
            ItemsModel(
                R.drawable.spider,
                "Spider-man 3",
                "No way home",
                R.drawable.star
            ),

        )
        itemsAdapter.submitList(listItems.toList())
    }

    override fun onClick() {
        Toast.makeText(context,"ImageView clicked",Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, about: String, imageView: Int, imageView2: Int) {
        val detailFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString("name",name)
        bundle.putString("about",about)
        bundle.putInt("imageView",imageView)
        bundle.putInt("imageView",imageView2)
        detailFragment.arguments = bundle


        parentFragmentManager.beginTransaction()
            .replace(R.id.activity_container,DetailsFragment())
            .addToBackStack("Details")
            .commit()
    }

}