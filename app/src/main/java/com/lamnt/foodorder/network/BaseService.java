package com.lamnt.foodorder.network;

import com.lamnt.foodorder.model.dto.ResponseDTO;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface BaseService{
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("{endpoint}")
    <E extends  BaseRequestBody> Observable<ResponseDTO> postMapping(@Path("endpoint") String endpoint,
                                        @Body E baseRequestBody);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("{endpoint}")
    Observable<ResponseDTO> getMapping(@Path("endpoint") String endpoint);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @PUT("{endpoint}")
    <E extends  BaseRequestBody> Observable<ResponseDTO> putMapping(@Path("endpoint") String endpoint,
                             @Body E baseRequestBody);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @DELETE("{endpoint}")
    Observable<ResponseDTO> deleteMapping(@Path("endpoint") String endpoint);
}
