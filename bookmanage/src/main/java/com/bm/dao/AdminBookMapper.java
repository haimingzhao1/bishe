package com.bm.dao;

import com.bm.model.AdminBook;
import com.bm.model.AdminBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminBookMapper {

    long countByExample(AdminBookExample example);

    int deleteByExample(AdminBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AdminBook record);

    int insertSelective(AdminBook record);

    List<AdminBook> selectByExample(AdminBookExample example);

    AdminBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AdminBook record, @Param("example") AdminBookExample example);

    int updateByExample(@Param("record") AdminBook record, @Param("example") AdminBookExample example);

    int updateByPrimaryKeySelective(AdminBook record);

    int updateByPrimaryKey(AdminBook record);
}