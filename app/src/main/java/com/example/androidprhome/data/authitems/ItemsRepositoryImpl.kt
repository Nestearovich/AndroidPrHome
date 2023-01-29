package com.example.androidprhome.data.authitems

import com.example.androidprhome.data.database.FavoritesEntity
import com.example.androidprhome.data.database.ItemsEntity
import com.example.androidprhome.data.database.dao.ItemsDAO
import com.example.androidprhome.data.service.ApiService
import com.example.androidprhome.domain.items.ItemsRepository
import com.example.androidprhome.model.FavoritesModel
import com.example.androidprhome.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.*
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val itemsDAO: ItemsDAO,
) : ItemsRepository {
    override suspend fun getData() {

        return withContext(Dispatchers.IO) {

            if (!itemsDAO.doesItemsEntityExist()) {
                val response = apiService.getData()
                response.body()?.let {
                    it.map {
                        val itemsEntity = ItemsEntity(
                            Random().nextInt(),
                            it.id,
                            it.name,
                            it.userName,
                            it.email,
                            it.address.street,
                            it.address.suite,
                            it.address.city,
                            it.address.zipcode,
                            it.address.geo.lat,
                            it.address.geo.lng,
                            it.phone,
                            it.website,
                            it.company.companyName,
                            it.company.catchPhrase,
                        )
                        itemsDAO.insertItemsEntity(itemsEntity)
                    }
                }
            }
        }
    }

    override suspend fun showData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val itemsEntity = itemsDAO.getItemsEntities()
            itemsEntity.map {
                ItemsModel(
                    Random().nextInt(),
                    it.userName,
                    it.email,
                    it.phone,
                    it.phone,
                    it.website,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.lng,
                    it.companyName,
                    it.catchPhrase,
                    it.bs,
                    )
            }
        }
    }



    override suspend fun findItemByDescription(searchText: String): ItemsModel {
        TODO("Not yet implemented")
    }


    override suspend fun favClicked(itemsModel: ItemsModel) {
        return withContext(Dispatchers.IO){
            itemsDAO.insertFavoritesEntity(
                FavoritesEntity(Random().nextInt(),
                    itemsModel.name,
                    itemsModel.userName,
                    itemsModel.email,
                    itemsModel.street,
                    itemsModel.suite,
                    itemsModel.lat,
                    itemsModel.lng,
                    itemsModel.companyName,
                    itemsModel.city,
                    itemsModel.zipcode,
                    itemsModel.phone,
                    itemsModel.website,
                    itemsModel.city,
                    itemsModel.phone
                )
            )
        }
    }


    override suspend fun getFavorites(): List<FavoritesModel> {
        return withContext(Dispatchers.IO){
            val favoritesEntity = itemsDAO.getFavoriteEntities()
            favoritesEntity.map {
                FavoritesModel(
                    it.id,
                    it.name,
                    it.userName,
                    it.email,
                    it.phone,
                    it.website,
                    it.street,
                    it.suite,
                    it.city,
                    it.zipcode,
                    it.lat,
                    it.lng,
                    it.companyName,
                    )
            }
        }
    }
}