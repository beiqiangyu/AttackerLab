package com.InternetworkingProject.AttackerLab.serviceImpl;

import com.InternetworkingProject.AttackerLab.entity.Login;
import com.InternetworkingProject.AttackerLab.entity.User;
import com.InternetworkingProject.AttackerLab.mapper.LoginMapper;
import com.InternetworkingProject.AttackerLab.service.LoginService;
import org.slf4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginMapper loginMapper;

    @Override
    public Login login(String uname, String password){
        return loginMapper.login(uname, password);
    }
}
