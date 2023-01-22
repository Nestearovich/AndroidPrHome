package com.example.androidprhome.data.authitems

import com.example.androidprhome.R
import com.example.androidprhome.data.service.ApiService
import com.example.androidprhome.domain.items.ItemsRepository
import com.example.androidprhome.model.ItemsModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ItemsRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : ItemsRepository {
    override suspend fun getData(): List<ItemsModel> {
        return withContext(Dispatchers.IO) {
            val response = apiService.getData()
            response.body()?.let {
                it.map {
                    ItemsModel(
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
                        it. website,
                        it.company.companyName,
                        it.company.catchPhrase,
                        it.company.bs,
                    )
                }
            }?: kotlin.run {
                emptyList()
            }
        }
    }
}
