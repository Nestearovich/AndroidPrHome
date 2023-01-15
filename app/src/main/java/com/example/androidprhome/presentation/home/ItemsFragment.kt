package com.example.androidprhome.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import com.example.androidprhome.utils.BundleConstant.KEY_ABOUT
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE2
import com.example.androidprhome.utils.BundleConstant.KEY_NAME
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentItemsBinding
import com.example.androidprhome.model.ItemsModel
import com.example.androidprhome.presentation.adapter.User.ItemsUser
import com.example.androidprhome.presentation.adapter.ItemsAdapter
import com.example.androidprhome.utils.NavHelper.navigateWithBundle
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsUser {


    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    private val viewModel: ItemsViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemsAdapter = ItemsAdapter(this)

        viewBinding.recyclerView.adapter = itemsAdapter

        viewModel.getData()

        viewModel.items.observe(viewLifecycleOwner) { listItems ->
            itemsAdapter.submitList(listItems)
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
        }

        viewModel.bundle.observe(viewLifecycleOwner) { navBundle ->
            if (navBundle != null) {
                val detailFragment = DetailsFragment()
                val bundle = Bundle()
                bundle.putString(KEY_NAME, navBundle.name)
                bundle.putString(KEY_ABOUT, navBundle.about)
                bundle.putInt(KEY_IMAGE, navBundle.image)
                bundle.putInt(KEY_IMAGE2, navBundle.image2)
                detailFragment.arguments = bundle


                navigateWithBundle(
                    R.id.action_itemsFragment_to_detailsFragment,
                    bundle
                )

                viewModel.userNavigated()
            }
        }

    }

    override fun onClick() {
        viewModel.imageViewClicked()
        Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, about: String, imageView: Int, imageView2: Int) {
        viewModel.elementClicked(name, about, imageView, imageView2)
    }
}


