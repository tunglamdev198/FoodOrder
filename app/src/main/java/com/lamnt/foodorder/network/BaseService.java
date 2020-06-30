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

public interface BaseService<E extends ResponseDTO>{
    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @POST("{endpoint}")
    <T extends BaseRequestBody>
    Observable<E> postMapping(@Path("endpoint") String endpoint,
                              @Body T baseRequestBody);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("{endpoint}")
    Observable<E> getMapping(@Path("endpoint") String endpoint);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @PUT("{endpoint}")
    <T extends BaseRequestBody>
    Observable<E> putMapping(@Path("endpoint") String endpoint,
                             @Body T baseRequestBody);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @DELETE("{endpoint}")
    Observable<E> deleteMapping(@Path("endpoint") String endpoint);
}
