package com.lamnt.foodorder.network

import com.lamnt.foodorder.model.dto.ResponseDTO
import io.reactivex.Observable
import retrofit2.http.*

interface BaseService {
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("{endpoint}")
    fun <E : BaseRequestBody?> postMapping(@Path("endpoint") endpoint: String?,
                                           @Body baseRequestBody: E): Observable<ResponseDTO<*>?>?

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("{endpoint}")
    fun getMapping(@Path("endpoint") endpoint: String?): Observable<ResponseDTO<*>?>?

    @Headers("Content-Type: application/json;charset=UTF-8")
    @PUT("{endpoint}")
    fun <E : BaseRequestBody?> putMapping(@Path("endpoint") endpoint: String?,
                                          @Body baseRequestBody: E): Observable<ResponseDTO<*>?>?

    @Headers("Content-Type: application/json;charset=UTF-8")
    @DELETE("{endpoint}")
    fun deleteMapping(@Path("endpoint") endpoint: String?): Observable<ResponseDTO<*>?>?
}