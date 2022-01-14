package com.InternetworkingProject.AttackerLab.handler;

import java.util.UUID;
import java.util.concurrent.Callable;

public class uuidHandler implements Callable {

    public String getUuid(){
        String uuid = UUID.randomUUID().toString();
        return uuid;
    }

    @Override
    public Object call() throws Exception{
        return getUuid();
    }
}
