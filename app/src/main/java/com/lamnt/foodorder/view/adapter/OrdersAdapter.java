package com.lamnt.foodorder.view.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.lamnt.foodorder.R;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class OrdersAdapter extends RecyclerView.Adapter<OrdersAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private Context context;
    private List<String> list;

    public OrdersAdapter(Context context, List<String> list) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(inflater.inflate(R.layout.item_food_payment, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Glide.with(context).load(R.drawable.demo_tra_sua).placeholder(R.drawable.ic_food).into(holder.imgFood);
        String data = list.get(position);
        holder.txtAmount.setText(data);
        final int amount = Integer.parseInt(data);
        if (amount > 0) {
            holder.btnAdd.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    holder.txtAmount.setText((amount + 1) + "");
                    list.set(position, (amount + 1) + "");
                    notifyItemChanged(position);
                }
            });

            holder.btnSub.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("SetTextI18n")
                @Override
                public void onClick(View v) {
                    holder.txtAmount.setText((amount - 1) + "");
                    list.set(position, (amount - 1) + "");
                    notifyItemChanged(position);
                }
            });
        } else if (amount == 0) {
            list.remove(position);
            notifyDataSetChanged();
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_restaurant_name)
        RoundedImageView txtRestaurantName;
        @BindView(R.id.cb_selected)
        CheckBox cbSelected;
        @BindView(R.id.img_food)
        RoundedImageView imgFood;
        @BindView(R.id.txt_price)
        TextView txtPrice;
        @BindView(R.id.ln_img)
        LinearLayout lnImg;
        @BindView(R.id.txt_name)
        TextView txtName;
        @BindView(R.id.rating_bar)
        RatingBar ratingBar;
        @BindView(R.id.txt_description)
        TextView txtDescription;
        @BindView(R.id.ln_text)
        LinearLayout lnText;
        @BindView(R.id.btn_add)
        ImageView btnAdd;
        @BindView(R.id.txt_amount)
        TextView txtAmount;
        @BindView(R.id.btn_sub)
        ImageView btnSub;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
