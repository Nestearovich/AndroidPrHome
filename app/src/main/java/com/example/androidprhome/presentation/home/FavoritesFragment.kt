package com.example.androidprhome.presentation.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidprhome.R
import com.example.androidprhome.databinding.FragmentFavoritesBinding
import com.example.androidprhome.databinding.FragmentHomeBinding
import com.example.androidprhome.model.FavoritesModel
import com.example.androidprhome.presentation.home.adapter.FavoritesAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class FavoritesFragment : Fragment(),FavoritesView {

    private var _viewBinding: FragmentFavoritesBinding? = null
    private val viewBinding get() = _viewBinding!!

    private lateinit var favAdapter: FavoritesAdapter

    @Inject
    lateinit var favoritesPresenter: FavoritesPresenter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _viewBinding =FragmentFavoritesBinding.inflate(inflater, container, false)
        return viewBinding.root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        favAdapter = FavoritesAdapter()
        viewBinding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        viewBinding.recyclerView.adapter = favAdapter


    }

    override suspend fun getFavorites(favoritesItems: List<FavoritesModel>) {
        favoritesPresenter.getFavorites()
    }
}