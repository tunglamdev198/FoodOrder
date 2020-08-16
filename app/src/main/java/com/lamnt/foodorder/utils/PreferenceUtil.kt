package com.lamnt.foodorder.utils

import android.content.Context

class PreferenceUtil private constructor(private val mContext: Context) {

    companion object {
        private var instance: PreferenceUtil? = null

        @Synchronized
        @JvmStatic
        fun getInstance(context: Context): PreferenceUtil? {
            if (instance == null) {
                instance = PreferenceUtil(context)
            }
            return instance
        }
    }

}