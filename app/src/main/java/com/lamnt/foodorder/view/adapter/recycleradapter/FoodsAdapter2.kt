package com.lamnt.foodorder.view.adapter.recycleradapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lamnt.foodorder.R

class FoodsAdapter2(private val context: Context) : RecyclerView.Adapter<FoodsAdapter2.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_recent_restaurant, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(context).load(R.drawable.demo_royal_tea).placeholder(R.drawable.ic_food).into(holder.imgFood)
    }

    override fun getItemCount(): Int {
        return 6
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFood: ImageView

        init {
            imgFood = itemView.findViewById(R.id.img_restaurant)
        }
    }

}