package com.lamnt.foodorder.view.adapter.pageradapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.lamnt.foodorder.R;
import com.lamnt.foodorder.view.common.ImageHelper;
import com.makeramen.roundedimageview.RoundedImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PromotionPagerAdapter extends RecyclerView.Adapter<PromotionPagerAdapter.ViewHolder> {
    private Activity activity;

    public PromotionPagerAdapter(Activity activity) {
        this.activity = activity;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(activity)
                .inflate(R.layout.item_promotion_image, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (position==0)
        ImageHelper.loadImage(activity, holder.imgPromotion, R.drawable.demo_discount_1);
        if (position==1)
        ImageHelper.loadImage(activity, holder.imgPromotion, R.drawable.demo_discound_2);
        if (position==2)
        ImageHelper.loadImage(activity, holder.imgPromotion, R.drawable.demo_discound_3);
        if (position==3)
            ImageHelper.loadImage(activity, holder.imgPromotion, R.drawable.demo_discount_4);
        if (position==4)
            ImageHelper.loadImage(activity, holder.imgPromotion, R.drawable.demo_discount_5);
    }

    @Override
    public int getItemCount() {
        return 5;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.img_promotion)
        RoundedImageView imgPromotion;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
