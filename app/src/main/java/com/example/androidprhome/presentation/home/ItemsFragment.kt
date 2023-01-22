package com.example.androidprhome.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.androidprhome.databinding.FragmentItemsBinding
import com.example.androidprhome.model.ItemsModel
import com.example.androidprhome.presentation.adapter.User.ItemsUser
import com.example.androidprhome.presentation.adapter.ItemsAdapter
import com.example.androidprhome.utils.BundleConstant.EMAIL
import com.example.androidprhome.utils.BundleConstant.NAME
import com.example.androidprhome.utils.BundleConstant.PHONE
import com.example.androidprhome.utils.BundleConstant.USER_NAME
import com.example.androidprhome.utils.NavHelper.navigateWithBundle
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
        viewBinding.recyclerView.adapter = itemsAdapter

        itemsPresenter.getItems()
    }
    override fun onClick() {
        itemsPresenter.imageViewClicked()
        Toast.makeText(context, "Image clicked", Toast.LENGTH_SHORT).show()
    }

    override fun onElementSelected(
        id: Int,
        name: String,
        userName: String,
        email: String,
        street: String,
        suite: String,
        city: String,
        zipcode: String,
        lat: String,
        lng: String,
        phone: String,
        website: String,
        companyName: String,
        catchPhrase: String,
        bs: String,
    ) {
        itemsPresenter.elementSelected(
            id,
            name,
            userName,
            email,
            street,
            suite,
            city,
            zipcode,
            lat,
            lng,
            phone,
            website,
            companyName,
            catchPhrase,
            bs,
        )
    }

    override fun dataReceived(list: List<ItemsModel>) {
        itemsAdapter.submitList(list)
    }
    override fun imageViewClicked(msg: Int) {
        Toast.makeText(context, getString(msg), Toast.LENGTH_SHORT).show()
    }

    override fun itemClicked(navigateWithBundle: NavigateWithBundle,destination: Int) {
        val detailsFragment = DetailsFragment()
        val bundle = Bundle()
        bundle.putString(NAME,navigateWithBundle.name)
        bundle.putString(USER_NAME,navigateWithBundle.userName)
        bundle.putString(EMAIL,navigateWithBundle.email)
        bundle.putString(PHONE, navigateWithBundle.phone)
        detailsFragment.arguments = bundle

        Toast.makeText(context, "called", Toast.LENGTH_SHORT).show()

        navigateWithBundle(destination, bundle)
    }
}


