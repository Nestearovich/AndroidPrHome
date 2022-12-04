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





class ItemsFragment : Fragment(),ItemsUser {


    private lateinit var itemsAdapter: ItemsAdapter
    private val viewModel: ItemsViewModel by viewModel()

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

        viewModel.getAbout()

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)

        }
        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show()
        }



        viewModel.bundle.observe(viewLifecycleOwner){navBundle ->
            val detailFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putString("name",navBundle.name)
            bundle.putString("date",navBundle.about)
            bundle.putInt("imageView",navBundle.image)
            bundle.putInt("imageView2",navBundle.imageView2)
            detailFragment.arguments =bundle

            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container,DetailsFragment())
                .addToBackStack("Details")
                .commit()
        }

    }

    override fun onClick() {
        TODO("Not yet implemented")
    }

    override fun onElementSelected(name: String, about: String, imageView: Int, imageView2: Int) {
        TODO("Not yet implemented")
    }
}