package com.bm.dao;

import com.bm.model.TAdmin;
import com.bm.model.TAdminExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TAdminMapper {
    long countByExample(TAdminExample example);

    int deleteByExample(TAdminExample example);

    int insert(TAdmin record);

    int insertSelective(TAdmin record);

    List<TAdmin> selectByExample(TAdminExample example);

    int updateByExampleSelective(@Param("record") TAdmin record, @Param("example") TAdminExample example);

    int updateByExample(@Param("record") TAdmin record, @Param("example") TAdminExample example);
}