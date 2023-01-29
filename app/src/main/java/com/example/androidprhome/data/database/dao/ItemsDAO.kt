package com.example.androidprhome.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.androidprhome.data.database.FavoritesEntity
import com.example.androidprhome.data.database.ItemsEntity

@Dao
interface ItemsDAO {

    @Insert
    fun insertItemsEntity(itemsEntity: ItemsEntity)

    @Query("SELECT * From ItemsEntity")
    fun getItemsEntities(): List<ItemsEntity>

    @Query("SELECT (SELECT COUNT(*) FROM ItemsEntity) !=0")
    fun doesItemsEntityExist(): Boolean



    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertFavoritesEntity(favoritesEntity: FavoritesEntity)

    @Query("SELECT * FROM favoritesEntity")
    fun getFavoriteEntities(): List<FavoritesEntity>
}