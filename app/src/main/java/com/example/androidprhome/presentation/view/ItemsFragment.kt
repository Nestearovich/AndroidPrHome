package com.example.androidprhome.presentation.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidprhome.utils.BundleConstant.KEY_ABOUT
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE
import com.example.androidprhome.utils.BundleConstant.KEY_IMAGE2
import com.example.androidprhome.utils.BundleConstant.KEY_NAME
import com.example.androidprhome.R
import com.example.androidprhome.data.ItemsRepositoryImpl
import com.example.androidprhome.databinding.FragmentItemsBinding
import com.example.androidprhome.domain.ItemsInteractor
import com.example.androidprhome.model.ItemsModel
import com.example.androidprhome.presentation.adapter.User.ItemsUser
import com.example.androidprhome.presentation.adapter.ItemsAdapter
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsUser,ItemsView {


    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    lateinit var itemsPresenter: ItemsPresenter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _viewBinding = FragmentItemsBinding.inflate(inflater)
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        itemsPresenter = ItemsPresenter(this, ItemsInteractor(ItemsRepositoryImpl()))

        itemsAdapter = ItemsAdapter(this)

        itemsPresenter.getAbout()

        viewBinding.recyclerView.adapter = itemsAdapter


    }

    override fun onClick() {
       itemsPresenter.imageViewClicked()
        Toast.makeText(context,"Image clicked",Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, about: String, imageView: Int, imageView2: Int) {
        itemsPresenter.elementSelected(name,about,imageView,imageView2)
    }

    override fun dataReceived(list: List<ItemsModel>) {
       itemsAdapter.submitList(list)
    }

    override fun imageViewClicked() {

    }


    override fun goToDetails(name: String, about: String, imageView: Int, imageView2: Int) {
            val detailFragment = DetailsFragment()
            val bundle = Bundle()
            bundle.putString(KEY_NAME,name)
            bundle.putString(KEY_ABOUT,about)
            bundle.putInt(KEY_IMAGE,imageView)
            bundle.putInt(KEY_IMAGE2,imageView2)
            detailFragment.arguments =bundle

            parentFragmentManager
                .beginTransaction()
                .add(R.id.activity_container,DetailsFragment())
                .addToBackStack("Details")
                .commit()
        }
    }


