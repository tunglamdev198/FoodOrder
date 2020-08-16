package com.lamnt.foodorder.view.adapter.recycleradapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lamnt.foodorder.R
import com.lamnt.foodorder.listener.OnItemClickListener
import com.lamnt.foodorder.view.common.ImageHelper
import kotlinx.android.synthetic.main.item_restaurant_home.view.*

class FoodsAdapter(
    private var activity: Activity,
    private val onItemClickListener: OnItemClickListener<String>) : RecyclerView.Adapter<FoodsAdapter.ViewHolder>() {
    private val inflater: LayoutInflater = LayoutInflater.from(activity)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_restaurant_home, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return 12
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(position: Int) {
            itemView.apply {
                ImageHelper.loadImage(activity, imgRestaurant, R.drawable.demo_royal_tea)
                container.setOnClickListener {
                    onItemClickListener.onItemClick("", position, imgRestaurant)
                }
            }
        }
    }

}