package com.bm.dao;

import com.bm.model.TUser;
import com.bm.model.TUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TUserMapper {
    long countByExample(TUserExample example);

    int deleteByExample(TUserExample example);

    int insert(TUser record);

    int insertSelective(TUser record);

    List<TUser> selectByExample(TUserExample example);

    int updateByExampleSelective(@Param("record") TUser record, @Param("example") TUserExample example);

    int updateByExample(@Param("record") TUser record, @Param("example") TUserExample example);
}