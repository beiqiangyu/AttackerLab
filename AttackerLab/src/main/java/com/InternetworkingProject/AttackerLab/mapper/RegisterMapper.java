package com.InternetworkingProject.AttackerLab.mapper;

import com.InternetworkingProject.AttackerLab.entity.Register;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.sql.SQLException;
import java.time.LocalDate;


@Mapper
public interface RegisterMapper {
    @Insert("insert into users(uid, uname, password, uphoto, registerDate) values (#{uid}, #{uname}, #{password}, #{uphoto}, #{localDate})")
    public int register(String uid, String uname, String password, String uphoto, LocalDate localDate) throws SQLException;
}
