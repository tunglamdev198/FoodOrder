package com.lamnt.foodorder.view.adapter.recycleradapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.core.view.ViewCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.listener.OnItemClickListener;
import com.lamnt.foodorder.view.common.ImageHelper;

public class FoodsAdapter extends RecyclerView.Adapter<FoodsAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Activity context;
    private OnItemClickListener<String> onItemClickListener;
    public FoodsAdapter(Activity context,OnItemClickListener<String> onItemClickListener) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_restaurant_home, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageHelper.loadImage(context, holder.imgFood, R.drawable.demo_royal_tea);
        holder.imgFood.setOnClickListener(v -> {
            onItemClickListener.onItemClick("",holder.getAdapterPosition(), holder.itemView);
        });
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_restaurant);
            container = itemView.findViewById(R.id.container);
        }
    }
}
