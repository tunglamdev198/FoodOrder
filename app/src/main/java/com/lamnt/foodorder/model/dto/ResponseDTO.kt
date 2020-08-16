package com.lamnt.foodorder.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class ResponseDTO<E> : Serializable {
    var code: String? = null

    @Expose
    @SerializedName("message")
    var message: String? = null

    @Expose
    @SerializedName("success")
    var success: String? = null

    @Expose
    @SerializedName("status")
    var status: String? = null

    @Expose
    @SerializedName("data")
    var data: E? = null
        private set

    fun setData(data: E) {
        this.data = data
    }
}