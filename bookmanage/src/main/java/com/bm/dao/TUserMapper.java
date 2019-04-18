package com.bm.dao;

import com.bm.model.TUser;

public interface TUserMapper {

    int insert(TUser record);

    TUser selectByNamePass(String username, String password);

}