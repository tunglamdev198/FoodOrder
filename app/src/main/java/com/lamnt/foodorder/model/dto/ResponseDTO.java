package com.lamnt.foodorder.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseDTO {
    @Expose
    @SerializedName("code")
    private String code;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("success")
    private String success;

    @Expose
    @SerializedName("data")
    private List<DemoEmployee> employee;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public List<DemoEmployee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<DemoEmployee> employee) {
        this.employee = employee;
    }
}
