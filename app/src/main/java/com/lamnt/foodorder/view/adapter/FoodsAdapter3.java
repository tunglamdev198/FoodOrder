package com.lamnt.foodorder.view.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.common.ImageHelper;

public class FoodsAdapter3 extends RecyclerView.Adapter<FoodsAdapter3.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;

    public FoodsAdapter3(Context context) {
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_food, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ImageHelper.loadImage((Activity) context,
                holder.imgFood,
               R.drawable.demo_tra_sua);
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgFood = itemView.findViewById(R.id.img_food);
        }
    }
}
