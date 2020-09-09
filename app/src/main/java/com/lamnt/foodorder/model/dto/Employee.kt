package com.lamnt.foodorder.model.dto

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import java.io.Serializable

class Employee : Serializable {
    @Expose
    @SerializedName("id")
    var id: String? = null

    @Expose
    @SerializedName("employee_name")
    var employeeName: String? = null

    @Expose
    @SerializedName("employee_salary")
    var employeeSalary: String? = null

    @Expose
    @SerializedName("employee_age")
    var employeeAge: String? = null

    @Expose
    @SerializedName("profile_image")
    var profileImage: String? = null


}