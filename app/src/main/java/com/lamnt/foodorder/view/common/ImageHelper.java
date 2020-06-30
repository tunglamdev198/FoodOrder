package com.lamnt.foodorder.view.common;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;

import androidx.annotation.DrawableRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RawRes;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieDrawable;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.load.resource.gif.GifDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.DrawableImageViewTarget;
import com.bumptech.glide.request.target.Target;
import com.bumptech.glide.request.transition.Transition;
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

    public static void loadGifImage(Activity activity,
                                    ImageView imageView,
                                    @RawRes int imageRes) {
        Glide.with(activity)
                .asGif()
                .load(imageRes)
                .addListener(new RequestListener<GifDrawable>() {
                    @Override
                    public boolean onLoadFailed(@Nullable GlideException e,
                                                Object model, Target<GifDrawable> target,
                                                boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GifDrawable resource, Object model,
                                                   Target<GifDrawable> target, DataSource dataSource,
                                                   boolean isFirstResource) {
                        resource.setLoopCount(1); // Place your loop count here.
                        return false;
                    }
                })
                .into(imageView);
    }
}
