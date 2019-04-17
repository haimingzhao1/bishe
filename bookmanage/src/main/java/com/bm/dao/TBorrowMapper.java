package com.bm.dao;

import com.bm.model.TBorrow;
import com.bm.model.TBorrowExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBorrowMapper {
    long countByExample(TBorrowExample example);

    int deleteByExample(TBorrowExample example);

    int insert(TBorrow record);

    int insertSelective(TBorrow record);

    List<TBorrow> selectByExample(TBorrowExample example);

    int updateByExampleSelective(@Param("record") TBorrow record, @Param("example") TBorrowExample example);

    int updateByExample(@Param("record") TBorrow record, @Param("example") TBorrowExample example);
}