package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.db.ShoppingDataBase
import com.example.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(private val db : ShoppingDataBase) {
    suspend fun upSert(item:ShoppingItem)  = db.getShoppingDAO().upSert(item)
    suspend fun delete(item: ShoppingItem) = db.getShoppingDAO().delete(item)
    fun getAllShoppingItems()              = db.getShoppingDAO().getAllShoppingItems()

}