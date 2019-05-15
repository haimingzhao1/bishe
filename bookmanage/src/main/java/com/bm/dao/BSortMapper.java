package com.bm.dao;

import com.bm.model.BSort;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BSortMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BSort record);

    int insertSelective(BSort record);

    BSort selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BSort record);

    int updateByPrimaryKey(BSort record);

    List<BSort> findAllSorts();
}