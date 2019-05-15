package com.bm.service;

import com.bm.dao.TAdminMapper;
import com.bm.dao.TStudentMapper;
import com.bm.dao.TUserMapper;
import com.bm.model.TAdmin;
import com.bm.model.TStudent;
import com.bm.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LonginService {
    @Autowired
    TUserMapper userMapper;
    @Autowired
    TAdminMapper adminMapper;
    @Autowired
    TStudentMapper studentMapper;
    public TUser LoginCheck(String username, String password){
//        System.out.println(userMapper.findByUsername(username,password));
        return userMapper.findByUsername(username,password);
    }
    public TAdmin findAdminByJob(String job){
        return adminMapper.findAdminByJob(job);
    }
    public TStudent findByStuNumber(String stuNum){
        return studentMapper.findByStuNumber(stuNum);
    }
}
