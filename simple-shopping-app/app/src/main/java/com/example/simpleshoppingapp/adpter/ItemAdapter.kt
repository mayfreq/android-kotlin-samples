package com.example.simpleshoppingapp.adpter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.simpleshoppingapp.R
import com.example.simpleshoppingapp.model.Product

class ItemAdapter(private val context: Context,
                  private val dataset: List<Product>
                  ):RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    inner class ItemViewHolder(private val view: View): RecyclerView.ViewHolder(view){
        val imgProduct: ImageView = view.findViewById(R.id.imgProduct)
        val tvProductName: TextView = view.findViewById(R.id.tvProductName)
        val tvPrice:TextView = view.findViewById(R.id.tvPrice)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
                .inflate(R.layout.card_product,parent,false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.tvProductName.text = context.resources.getString(item.stringResourceId)
        holder.imgProduct.setImageResource(item.imageResourceId)
        holder.tvPrice.text = item.price.toString().plus(" $")
    }

    override fun getItemCount() = dataset.size

}