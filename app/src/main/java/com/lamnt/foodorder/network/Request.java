package com.lamnt.foodorder.network;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.lamnt.foodorder.model.dto.ResponseDTO;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.lamnt.foodorder.common.Constants.BASE_URL;

public class Request<E extends ResponseDTO> {
    private static Request instance;
    private static BaseService service;

    public static synchronized BaseService getService() {
        if (instance == null) {
            instance = new Request();
        }
        return service;
    }
    private Request() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
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
