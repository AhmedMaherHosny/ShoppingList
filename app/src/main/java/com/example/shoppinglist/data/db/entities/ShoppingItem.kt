package com.example.shoppinglist.data.db.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ShoppingItem (
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    @ColumnInfo
    val name : String,
    @ColumnInfo
    var amount : Int,
        )