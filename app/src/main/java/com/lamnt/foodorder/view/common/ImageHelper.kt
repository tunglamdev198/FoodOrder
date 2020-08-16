package com.lamnt.foodorder.view.common

import android.app.Activity
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.annotation.RawRes
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.gif.GifDrawable
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.RequestOptions
import com.bumptech.glide.request.target.Target
import com.lamnt.foodorder.R

object ImageHelper {
    @JvmStatic
    fun loadImage(activity: Activity?,
                  imageView: ImageView?,
                  @DrawableRes imageRes: Int) {
        Glide.with(activity!!)
                .load(imageRes)
                .apply(RequestOptions().placeholder(R.drawable.ic_food).fitCenter())
                .centerInside()
                .into(imageView!!)
    }

    @JvmStatic
    fun loadImage(activity: Activity?,
                  imageView: ImageView?,
                  url: String?) {
        Glide.with(activity!!)
                .load(url)
                .into(imageView!!)
    }

    @JvmStatic
    fun loadImage(activity: Activity?,
                  imageView: ImageView?,
                  @DrawableRes imageRes: Int,
                  @DrawableRes placeHolderRes: Int) {
        Glide.with(activity!!)
                .load(imageRes)
                .apply(RequestOptions().placeholder(placeHolderRes).fitCenter())
                .into(imageView!!)
    }

    @JvmStatic
    fun loadGifImage(activity: Activity?,
                     imageView: ImageView?,
                     @RawRes imageRes: Int) {
        Glide.with(activity!!)
                .asGif()
                .load(imageRes)
                .addListener(object : RequestListener<GifDrawable> {
                    override fun onLoadFailed(e: GlideException?,
                                              model: Any, target: Target<GifDrawable>,
                                              isFirstResource: Boolean): Boolean {
                        return false
                    }

                    override fun onResourceReady(resource: GifDrawable, model: Any,
                                                 target: Target<GifDrawable>, dataSource: DataSource,
                                                 isFirstResource: Boolean): Boolean {
                        resource.setLoopCount(1) // Place your loop count here.
                        return false
                    }
                })
                .into(imageView!!)
    }
}