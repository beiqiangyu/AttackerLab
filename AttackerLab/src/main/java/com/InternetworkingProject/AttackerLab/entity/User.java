package com.InternetworkingProject.AttackerLab.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.ArrayList;
//@JsonIgnoreProperties(value = { "hibernateLazyInitializer", "handler" })

public abstract class User {
    public String uid;
    public String uname;
    public String uphoto;

}
