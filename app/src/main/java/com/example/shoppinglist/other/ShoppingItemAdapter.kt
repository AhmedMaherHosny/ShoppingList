package com.example.shoppinglist.other

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.data.db.entities.ShoppingItem
import com.example.shoppinglist.ui.shoppinglist.ShoppingViewModel
import kotlinx.android.synthetic.main.shopping_item_row.view.*

class ShoppingItemAdapter(var items : List<ShoppingItem>, private val viewModel: ShoppingViewModel) :
    RecyclerView.Adapter<ShoppingItemAdapter.ShoppingViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShoppingViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shopping_item_row, parent, false)
        return ShoppingViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShoppingViewHolder, position: Int) {
        val currItem = items[position]

        holder.itemView.name.text = currItem.name
        holder.itemView.amount.text = "${currItem.amount}"

        holder.itemView.delete.setOnClickListener{
            viewModel.delete(currItem)
        }

        holder.itemView.add.setOnClickListener{
            currItem.amount++
            viewModel.upSert(currItem)
        }

        holder.itemView.remove.setOnClickListener{
            if (currItem.amount > 0){
                currItem.amount--
                viewModel.upSert(currItem)
            }
        }
    }

    override fun getItemCount(): Int = items.size

    inner class ShoppingViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}