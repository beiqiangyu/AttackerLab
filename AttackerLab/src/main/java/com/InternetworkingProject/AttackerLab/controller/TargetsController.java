package com.InternetworkingProject.AttackerLab.controller;

import com.InternetworkingProject.AttackerLab.entity.ApiResult;
import com.InternetworkingProject.AttackerLab.entity.targets.Target;
import com.InternetworkingProject.AttackerLab.entity.targets.TargetList;
import com.InternetworkingProject.AttackerLab.handler.ApiResultHandler;
import com.InternetworkingProject.AttackerLab.serviceImpl.TargetsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TargetsController {

    @Autowired
    private TargetsServiceImpl targetsServiceImpl;

    @GetMapping("/api/v1/{uid}/targets")
    public ApiResult findAll(@PathVariable("uid") Integer uid){
        ApiResult apiResult;
        List<TargetList> targetList = targetsServiceImpl.findAll();
        apiResult = ApiResultHandler.buildApiResult(200, targetList, null);
        return apiResult;
    }

    @GetMapping("/api/v1/targets/{tid}")
    public ApiResult findTarget(@PathVariable("tid") Integer tid){
        ApiResult apiResult;
        Target res = targetsServiceImpl.findTarget(tid);
        apiResult = ApiResultHandler.buildApiResult(200,res, null);
        return apiResult;
    }


}
