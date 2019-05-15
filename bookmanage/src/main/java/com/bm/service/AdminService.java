package com.bm.service;

import com.bm.dao.TAdminMapper;
import com.bm.model.TAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    TAdminMapper adminMapper;
    public TAdmin findAdminById(int id) {
        return adminMapper.selectByPrimaryKey(id);
    }

//    public int updateAdmin(TAdmin tAdmin) {
//        return adminMapper.updateByPrimaryKeySelective(tAdmin);
//    }
}
