package com.lamnt.foodorder.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ResponseDTO <E> implements Serializable{
    private String code;

    @Expose
    @SerializedName("message")
    private String message;

    @Expose
    @SerializedName("success")
    private String success;

    @Expose
    @SerializedName("status")
    private String status;

    @Expose
    @SerializedName("data")
    private E data;

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public E getData() {
        return data;
    }

    public void setData(E data) {
        this.data = data;
    }
}
