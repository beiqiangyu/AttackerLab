package com.InternetworkingProject.AttackerLab.controller;

import com.InternetworkingProject.AttackerLab.entity.ApiResult;
import com.InternetworkingProject.AttackerLab.entity.Register;
import com.InternetworkingProject.AttackerLab.entity.URL;
import com.InternetworkingProject.AttackerLab.handler.ApiResultHandler;
import com.InternetworkingProject.AttackerLab.handler.UuidHandler;
import com.InternetworkingProject.AttackerLab.serviceImpl.RegisterServiceImpl;
import com.mysql.cj.jdbc.exceptions.MySQLQueryInterruptedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.time.LocalDate;

@RestController
public class UsersController {
    @Autowired
    private RegisterServiceImpl registerService;


    @PostMapping("/api/v1/users")
    public ApiResult regist(@RequestParam String uname, String password){

        String index = String.valueOf(Math.round(Math.random()*23)) + ".png";
        String uphoto= URL.getUrl() + index;

        String uid = UuidHandler.getUuid(8);
        LocalDate localDate = LocalDate.now();
        boolean res = false;
        try {
            res = registerService.register(uid, uname, password, uphoto, localDate);
        }catch(DataAccessException | SQLException e) {
            final Throwable cause = e.getCause();
            if(cause instanceof DuplicateKeyException){
                System.out.println("MySQLQueryInterruptedException");
            }else{
                System.out.println(cause.toString());
            }
        }
        Register register = new Register();
        register.setSuccess(res);
        return ApiResultHandler.buildApiResult(200, register, null);

    }
}
