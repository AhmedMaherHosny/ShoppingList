package com.example.shoppinglist.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.shoppinglist.data.db.entities.ShoppingItem

@Dao
interface ShoppingDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upSert(item: ShoppingItem)

    @Delete
    suspend fun delete(item: ShoppingItem)

    @Query("SELECT * FROM ShoppingItem")
    fun getAllShoppingItems() : LiveData<List<ShoppingItem>>
}