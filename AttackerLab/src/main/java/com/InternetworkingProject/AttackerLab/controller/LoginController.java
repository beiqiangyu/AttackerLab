package com.InternetworkingProject.AttackerLab.controller;

import com.InternetworkingProject.AttackerLab.entity.ApiResult;
import com.InternetworkingProject.AttackerLab.entity.Login;
import com.InternetworkingProject.AttackerLab.handler.ApiResultHandler;
import com.InternetworkingProject.AttackerLab.handler.UuidHandler;
import com.InternetworkingProject.AttackerLab.serviceImpl.LoginServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @Autowired
    LoginServiceImpl loginService;


    @GetMapping("/api/v1/session")
    public ApiResult login(@RequestParam String uname, String password){

        Login user = loginService.login(uname, password);
        if(user != null){
//            String uuid = UuidHandler.getUuid(5);
//            user.setToken(uuid);
            return ApiResultHandler.buildApiResult(200, user, null);
        }
        return ApiResultHandler.buildApiResult(600, "bad", "wrong password or uname");
    }


}
