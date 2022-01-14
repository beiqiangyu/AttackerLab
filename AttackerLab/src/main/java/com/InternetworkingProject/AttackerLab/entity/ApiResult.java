package com.InternetworkingProject.AttackerLab.entity;


import lombok.Data;

@Data
public class ApiResult<T> {
    private int status;
    private T data;
    private String error;

    public ApiResult(){}

    public ApiResult(int status, T data, String error){
        this.status = status;
        this.data = data;
        this.error = error;
    }

//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }
//
//    public T getData() {
//        return data;
//    }
//
//    public void setData(T data) {
//        this.data = data;
//    }
//
//    public String getError() {
//        return error;
//    }
//
//    public void setError(String error) {
//        this.error = error;
//    }
}
