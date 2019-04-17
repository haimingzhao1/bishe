package com.bm.dao;

import com.bm.model.AdminBook;
import com.bm.model.AdminBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AdminBookMapper {
    long countByExample(AdminBookExample example);

    int deleteByExample(AdminBookExample example);

    int insert(AdminBook record);

    int insertSelective(AdminBook record);

    List<AdminBook> selectByExample(AdminBookExample example);

    int updateByExampleSelective(@Param("record") AdminBook record, @Param("example") AdminBookExample example);

    int updateByExample(@Param("record") AdminBook record, @Param("example") AdminBookExample example);
}