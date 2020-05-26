package com.lamnt.foodorder.utils;

import android.content.Context;

public class PreferenceUtil {
    private static PreferenceUtil instance;
    private Context mContext;

    private PreferenceUtil(Context context) {
        this.mContext = context;
    }

    public static synchronized PreferenceUtil getInstance(Context context) {
        if (instance == null) {
            instance = new PreferenceUtil(context);
        }
        return instance;
    }
}
