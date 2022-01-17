package com.InternetworkingProject.AttackerLab.handler;

import java.util.UUID;

public class UuidHandler {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }

    public static String getUuid(int len){
        if(len == 0){
            return null;
        }

        if(len > 18){
            System.out.println("uuid can not over than 18 bit");
            return null;
        }

        String uuid = getUuid();
        int uuidLen = uuid.length();
        StringBuilder str = new StringBuilder();
        for(int i = 0, j = 0; i < len && j < uuidLen; i++, j+=2){
            str.append(uuid.charAt(j));
        }
        return str.toString();
    }
}
