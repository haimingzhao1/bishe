package com.bm.service;

import com.bm.dao.TUserMapper;
import com.bm.model.TUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserLonginService {
    @Autowired
    private TUserMapper tUserMapper;

    public boolean LoginCheck(String user,String pass){
        TUser user1 = tUserMapper.selectByNamePass(user,pass);
        if (user1 !=null)return true;
        return false;
    }

}
