package com.lamnt.foodorder.network;

import com.lamnt.foodorder.model.dto.DemoEmployee;
import com.lamnt.foodorder.model.dto.ResponseDTO;

import java.util.List;

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
    <BODY extends BaseRequestBody, RESPONSE>
    Observable<RESPONSE> postMapping(@Path("endpoint") String endpoint,
                              @Body BODY baseRequestBody);

//    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @GET("{endpoint}")
    <E>
    Observable<E> getMapping(@Path("endpoint") String endpoint);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @PUT("{endpoint}")
    <BODY extends BaseRequestBody,  RESPONSE>
    Observable<RESPONSE> putMapping(@Path("endpoint") String endpoint,
                             @Body BODY baseRequestBody);

    @Headers({ "Content-Type: application/json;charset=UTF-8"})
    @DELETE("{endpoint}")
    <RESPONSE>
    Observable<RESPONSE> deleteMapping(@Path("endpoint") String endpoint);

    @GET("employees")
    Observable<List<DemoEmployee>> getEmployee();

}
