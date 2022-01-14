package com.InternetworkingProject.AttackerLab.service;

import com.InternetworkingProject.AttackerLab.entity.User;

public interface LoginService {
    User login(String uname, String password);
}
