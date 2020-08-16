package com.lamnt.foodorder.view.adapter.recycleradapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lamnt.foodorder.R
import kotlinx.android.synthetic.main.item_food_payment.view.*

class OrdersAdapter(
    private val context: Context,
    private var list: MutableList<String>
) : RecyclerView.Adapter<OrdersAdapter.ViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(inflater.inflate(R.layout.item_food_payment, parent, false))
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            itemView.apply {
                Glide.with(context)
                    .load(R.drawable.demo_tra_sua)
                    .placeholder(R.drawable.ic_food)
                    .into(imgFood!!)
                val data = list[position]
                txtAmount!!.text = data
                val amount = data.toInt()
                if (amount > 0) {
                    btnAdd!!.setOnClickListener {
                        txtAmount!!.text = (amount + 1).toString() + ""
                        list[position] = (amount + 1).toString() + ""
                        notifyItemChanged(position)
                    }
                    btnSub!!.setOnClickListener {
                        txtAmount!!.text = (amount - 1).toString() + ""
                        list[position] = (amount - 1).toString() + ""
                        notifyItemChanged(position)
                    }
                } else if (amount == 0) {
                    list.removeAt(position)
                    notifyDataSetChanged()
                }
            }
        }
    }

}