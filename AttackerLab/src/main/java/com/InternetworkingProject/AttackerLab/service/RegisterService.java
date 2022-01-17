package com.InternetworkingProject.AttackerLab.service;

import com.InternetworkingProject.AttackerLab.entity.Register;
import org.springframework.dao.DataAccessException;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public interface RegisterService {
    public boolean register(String uid, String uname, String password, String uphoto, LocalDate localDate) throws DataAccessException, SQLException;
}
