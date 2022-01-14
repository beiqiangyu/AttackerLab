package com.InternetworkingProject.AttackerLab.handler;

import com.InternetworkingProject.AttackerLab.entity.ApiResult;

public class ApiResultHandler {
    public static ApiResult success(Object object){
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(200);
        return apiResult;
    }

    public static <T> ApiResult buildApiResult(Integer code, T data, String error){
        ApiResult apiResult = new ApiResult();
        apiResult.setStatus(code);
        apiResult.setData(data);
        apiResult.setError(error);
        return apiResult;
    }
}
