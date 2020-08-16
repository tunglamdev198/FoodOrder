package com.lamnt.foodorder.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

open class ResponseNoDataDTO : Serializable {
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

}