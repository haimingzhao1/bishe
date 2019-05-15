package com.bm.dao;

import com.bm.model.TAdmin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAdminMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    TAdmin selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TAdmin record);

    int updateByPrimaryKey(TAdmin record);

    TAdmin findAdminByJob(String job);
}