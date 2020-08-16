package com.lamnt.foodorder.view.adapter.recycleradapter

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.lamnt.foodorder.R
import com.lamnt.foodorder.view.common.ImageHelper

class FoodsAdapter3(private val context: Context) : RecyclerView.Adapter<FoodsAdapter3.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_food, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        ImageHelper.loadImage(context as Activity,
                holder.imgFood,
                R.drawable.demo_tra_sua)
    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgFood: ImageView

        init {
            imgFood = itemView.findViewById(R.id.img_food)
        }
    }

}