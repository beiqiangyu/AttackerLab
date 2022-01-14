package com.InternetworkingProject.AttackerLab.serviceImpl;

import com.InternetworkingProject.AttackerLab.entity.targets.Target;
import com.InternetworkingProject.AttackerLab.entity.targets.TargetList;
import com.InternetworkingProject.AttackerLab.mapper.TargetsMapper;
import com.InternetworkingProject.AttackerLab.service.TargetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class TargetsServiceImpl implements TargetsService {

    @Autowired
    private TargetsMapper targetsMapper;

    @Override
    public List<TargetList> findAll(){
        return targetsMapper.findAll();
    }

    @Override
    public Target findTarget(Integer tid) { return targetsMapper.findTarget(tid); }
}
