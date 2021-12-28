package com.example.shoppinglist.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.shoppinglist.data.db.entities.ShoppingItem

@Database(entities = [ShoppingItem::class], version = 1)
abstract class ShoppingDataBase : RoomDatabase(){
    abstract fun getShoppingDAO() : ShoppingDAO

    companion object{
        private const val DatabaseName = "ShoppingDB"
        private val LOCK = Any()
        @Volatile
        private var myDB : ShoppingDataBase? = null

        operator fun  invoke (context: Context) = myDB ?: synchronized(LOCK){
            myDB ?: createDB(context).also { myDB = it }
        }

        private fun createDB(context:Context) =
            Room.databaseBuilder(
                context.applicationContext,
                ShoppingDataBase::class.java,
                DatabaseName
            ).build()
    }
}