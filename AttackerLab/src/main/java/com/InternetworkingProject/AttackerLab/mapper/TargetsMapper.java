package com.InternetworkingProject.AttackerLab.mapper;

import com.InternetworkingProject.AttackerLab.entity.targets.Target;
import com.InternetworkingProject.AttackerLab.entity.targets.TargetList;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TargetsMapper {
    @Select("select tid, tname, tphoto, briefDesc as `desc`, count from attackerlab.targets")
    List<TargetList> findAll();

    @Select("select tid, tname, tphoto, fullDesc from attackerlab.targets where tid=#{tid}")
    Target findTarget(Integer tid);

}
