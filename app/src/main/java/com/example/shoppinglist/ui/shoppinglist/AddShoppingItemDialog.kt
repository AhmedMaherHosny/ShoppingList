package com.example.shoppinglist.ui.shoppinglist

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import kotlinx.android.synthetic.main.dialog_add_shopping_item.*

class AddShoppingItemDialog(context:Context, val addDialogListener: AddDialogListener) : AppCompatDialog(context) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        itemAdd.setOnClickListener{
            val name = itemInputName.text.toString()
            val amount = itemInputAmount.text.toString()

            if ( (name.isBlank() || name.isEmpty()) || (amount.isBlank() || amount.isEmpty())){
                Toast.makeText(context, "please inter all information in a correct way!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val item = ShoppingItem(name = name, amount = amount.toInt())
            addDialogListener.onAddButtonClicked(item)
            dismiss()
        }
        close.setOnClickListener{
            cancel()
        }
    }
}