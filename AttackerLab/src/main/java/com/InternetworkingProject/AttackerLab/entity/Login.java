package com.InternetworkingProject.AttackerLab.entity;

import lombok.Data;

@Data
public class Login extends User {
    private String token;
}
