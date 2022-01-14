package com.InternetworkingProject.AttackerLab.entity.targets;

import lombok.Data;

@Data
public class TargetList {
    private Integer tid;
    private String tname;
    private boolean flag;
    private String tphoto;
    private String desc;
    private Integer count;

}
