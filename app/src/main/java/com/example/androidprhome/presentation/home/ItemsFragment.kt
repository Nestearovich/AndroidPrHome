package com.example.androidprhome.presentation.home

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
import com.example.androidprhome.data.authitems.ItemsRepositoryImpl
import com.example.androidprhome.databinding.FragmentItemsBinding
import com.example.androidprhome.domain.items.ItemsInteractor
import com.example.androidprhome.model.ItemsModel
import com.example.androidprhome.presentation.adapter.User.ItemsUser
import com.example.androidprhome.presentation.adapter.ItemsAdapter
import com.example.androidprhome.utils.Navigation
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class ItemsFragment : Fragment(), ItemsUser, ItemsView {


    private var _viewBinding: FragmentItemsBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var itemsAdapter: ItemsAdapter

    @Inject
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


        itemsPresenter.setView(this)

        itemsAdapter = ItemsAdapter(this)

        itemsPresenter.getAbout()

        viewBinding.recyclerView.adapter = itemsAdapter


    }

    override fun onClick() {
        itemsPresenter.imageViewClicked()
        Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(name: String, about: String, imageView: Int, imageView2: Int) {
        itemsPresenter.elementSelected(name, about, imageView, imageView2)
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }

    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun itemClicked(navigateWithBundle: NavigateWithBundle) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(KEY_NAME, navigateWithBundle.name)
        bundle.putString(KEY_ABOUT, navigateWithBundle.date)
        bundle.putInt(KEY_IMAGE, navigateWithBundle.image)
        bundle.putInt(KEY_IMAGE2, navigateWithBundle.image2)
        detailsFragment.arguments = bundle

        Toast.makeText(context, "called", Toast.LENGTH_SHORT).show()

        Navigation.fmReplace(parentFragmentManager, detailsFragment, true)
    }

}


