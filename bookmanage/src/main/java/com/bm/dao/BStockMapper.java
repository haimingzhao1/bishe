package com.bm.dao;

import com.bm.model.BStock;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BStockMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(BStock record);

    int insertSelective(BStock record);

    BStock selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BStock record);

    int updateByPrimaryKey(BStock record);

    BStock selectByBookId(Integer bookid);

    BStock findStockByBookId(Integer bookid);
}