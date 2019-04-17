package com.bm.dao;

import com.bm.model.BStock;
import com.bm.model.BStockExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BStockMapper {
    long countByExample(BStockExample example);

    int deleteByExample(BStockExample example);

    int insert(BStock record);

    int insertSelective(BStock record);

    List<BStock> selectByExample(BStockExample example);

    int updateByExampleSelective(@Param("record") BStock record, @Param("example") BStockExample example);

    int updateByExample(@Param("record") BStock record, @Param("example") BStockExample example);
}