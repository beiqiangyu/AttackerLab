package com.InternetworkingProject.AttackerLab.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })
public class User {
    private String uid;
    private String uname;
    private String password;
    private String uphoto;
    private String targetsDone;

//    public User(){}
//
//    public User(String uname, String password){
//        this.uname = uname;
//        this.password = password;
//    }
//
//    public User(String uid, String uname, String password, String uphoto, ArrayList<Integer> targetsDone) {
//        this.uid = uid;
//        this.uname = uname;
//        this.password = password;
//        this.uphoto = uphoto;
//        this.targetsDone = targetsDone;
//    }
}
