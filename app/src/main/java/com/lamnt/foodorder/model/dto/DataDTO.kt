package com.lamnt.foodorder.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class DataDTO(@Expose
                      @SerializedName("data")
                      var employee:  List<Employee>? = null) : ResponseDTO() {

}