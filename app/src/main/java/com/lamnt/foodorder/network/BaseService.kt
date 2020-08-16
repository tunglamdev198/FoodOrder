package com.lamnt.foodorder.network

import com.lamnt.foodorder.model.dto.ResponseDTO
import com.lamnt.foodorder.model.dto.ResponseNoDataDTO
import io.reactivex.Observable
import retrofit2.http.*

interface BaseService {
    @Headers("Content-Type: application/json;charset=UTF-8")
    @POST("{endpoint}")
    fun <DATA,E : BaseRequestBody?> postMapping(@Path("endpoint") endpoint: String?,
                                           @Body baseRequestBody: E): Observable<ResponseDTO<DATA>>

    @Headers("Content-Type: application/json;charset=UTF-8")
    @GET("{endpoint}")
    fun<DATA> getMapping(@Path("endpoint") endpoint: String?): Observable<ResponseDTO<DATA>>

    @Headers("Content-Type: application/json;charset=UTF-8")
    @PUT("{endpoint}")
    fun <DATA,E : BaseRequestBody?> putMapping(@Path("endpoint") endpoint: String?,
                                          @Body baseRequestBody: E): Observable<ResponseDTO<DATA>>

    @Headers("Content-Type: application/json;charset=UTF-8")
    @DELETE("{endpoint}")
    fun deleteMapping(@Path("endpoint") endpoint: String?): Observable<ResponseNoDataDTO>
}