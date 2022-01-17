package com.InternetworkingProject.AttackerLab.service;

import com.InternetworkingProject.AttackerLab.entity.Login;
import com.InternetworkingProject.AttackerLab.entity.User;

public interface LoginService {
    Login login(String uname, String password);
}
