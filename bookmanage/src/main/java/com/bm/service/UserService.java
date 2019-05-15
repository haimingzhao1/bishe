package com.bm.service;

import com.bm.dao.TUserMapper;
import com.bm.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    TUserMapper userMapper;

    public TUser findUserByStuNum(String num) {
        return userMapper.findUserByStuNum(num);
    }
}
