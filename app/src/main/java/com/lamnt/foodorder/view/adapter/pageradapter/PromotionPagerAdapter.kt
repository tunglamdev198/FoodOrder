package com.lamnt.foodorder.view.adapter.pageradapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.lamnt.foodorder.R
import com.lamnt.foodorder.view.common.ImageHelper
import kotlinx.android.synthetic.main.item_promotion_image.view.*

class PromotionPagerAdapter(private val activity: Activity) : RecyclerView.Adapter<PromotionPagerAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(activity)
                .inflate(R.layout.item_promotion_image, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return 5
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindData(position: Int){
            if (position == 0) ImageHelper.loadImage(activity, itemView.imgPromotion, R.drawable.demo_discount_1)
            if (position == 1) ImageHelper.loadImage(activity, itemView.imgPromotion, R.drawable.demo_discound_2)
            if (position == 2) ImageHelper.loadImage(activity, itemView.imgPromotion, R.drawable.demo_discound_3)
            if (position == 3) ImageHelper.loadImage(activity, itemView.imgPromotion, R.drawable.demo_discount_4)
            if (position == 4) ImageHelper.loadImage(activity, itemView.imgPromotion, R.drawable.demo_discount_5)
        }
    }

}