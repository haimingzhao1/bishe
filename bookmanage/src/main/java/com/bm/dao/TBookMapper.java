package com.bm.dao;

import com.bm.model.TBook;
import com.bm.model.TBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBookMapper {
    long countByExample(TBookExample example);

    int deleteByExample(TBookExample example);

    int insert(TBook record);

    int insertSelective(TBook record);

    List<TBook> selectByExample(TBookExample example);

    int updateByExampleSelective(@Param("record") TBook record, @Param("example") TBookExample example);

    int updateByExample(@Param("record") TBook record, @Param("example") TBookExample example);
}