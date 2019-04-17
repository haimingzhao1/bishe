package com.bm.dao;

import com.bm.model.BSort;
import com.bm.model.BSortExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BSortMapper {
    long countByExample(BSortExample example);

    int deleteByExample(BSortExample example);

    int insert(BSort record);

    int insertSelective(BSort record);

    List<BSort> selectByExample(BSortExample example);

    int updateByExampleSelective(@Param("record") BSort record, @Param("example") BSortExample example);

    int updateByExample(@Param("record") BSort record, @Param("example") BSortExample example);
}