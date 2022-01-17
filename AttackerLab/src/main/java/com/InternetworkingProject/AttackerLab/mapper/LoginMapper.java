package com.InternetworkingProject.AttackerLab.mapper;

import com.InternetworkingProject.AttackerLab.entity.Login;
import com.InternetworkingProject.AttackerLab.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface LoginMapper {
    @Select("select uid, uname, uphoto, targetsDone from attackerlab.users where uname = #{uname} and password = #{password}")
    public Login login(String uname, String password);
}
