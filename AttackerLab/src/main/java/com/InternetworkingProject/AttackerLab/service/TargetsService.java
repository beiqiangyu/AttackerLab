package com.InternetworkingProject.AttackerLab.service;

import com.InternetworkingProject.AttackerLab.entity.targets.Target;
import com.InternetworkingProject.AttackerLab.entity.targets.TargetList;

import java.util.List;
public interface TargetsService {
    List<TargetList> findAll();
    Target findTarget(Integer tid);
}
