package com.lamnt.foodorder.view.common;

import android.app.Activity;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.lamnt.foodorder.R;

public class ImageHelper {
    public static void loadImage(Activity activity,
                                 ImageView imageView,
                                 @DrawableRes int imageRes) {
        Glide.with(activity)
                .load(imageRes)
                .apply(new RequestOptions().placeholder(R.drawable.ic_food).fitCenter())
                .centerInside()
                .into(imageView);
    }

    public static void loadImage(Activity activity,
                                 ImageView imageView,
                                 String url) {
        Glide.with(activity)
                .load(url)
                .into(imageView);
    }

    public static void loadImage(Activity activity,
                                 ImageView imageView,
                                 @DrawableRes int imageRes,
                                 @DrawableRes int placeHolderRes) {
        Glide.with(activity)
                .load(imageRes)
                .apply(new RequestOptions().placeholder(placeHolderRes).fitCenter())
                .into(imageView);
    }
}
