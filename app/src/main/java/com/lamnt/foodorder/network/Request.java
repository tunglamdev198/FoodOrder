package com.lamnt.foodorder.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lamnt.foodorder.common.Constants.BASE_URL;

public class Request {
    private static Request instance;
    private static BaseService service;

    public static synchronized BaseService getService() {
        if (instance == null) {
            instance = new Request();
        }
        return service;
    }

    private Request() {
        OkHttpClient client = new OkHttpClient.Builder()
                .connectTimeout(10, TimeUnit.SECONDS)
                .readTimeout(2, TimeUnit.SECONDS)
                .writeTimeout(2, TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
        service = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build()
                .create(BaseService.class);
    }
}
