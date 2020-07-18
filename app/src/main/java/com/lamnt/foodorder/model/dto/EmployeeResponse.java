package com.lamnt.foodorder.model.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class EmployeeResponse extends ResponseDTO{
    @Expose
    @SerializedName("data")
    private List<DemoEmployee> employee;

    public List<DemoEmployee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<DemoEmployee> employee) {
        this.employee = employee;
    }
}
