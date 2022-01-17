package com.InternetworkingProject.AttackerLab.serviceImpl;

import com.InternetworkingProject.AttackerLab.entity.Register;
import com.InternetworkingProject.AttackerLab.mapper.RegisterMapper;
import com.InternetworkingProject.AttackerLab.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.rmi.registry.Registry;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    RegisterMapper registerMapper;

    @Override
    public boolean register(String uid, String uname, String password, String uphoto, LocalDate localDate) throws DataAccessException, SQLException {
        int row = registerMapper.register(uid, uname, password, uphoto, localDate);
        return row > 0;
    }
}
