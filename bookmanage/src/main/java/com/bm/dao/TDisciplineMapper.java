package com.bm.dao;

import com.bm.model.TDiscipline;
import com.bm.model.TDisciplineExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDisciplineMapper {
    long countByExample(TDisciplineExample example);

    int deleteByExample(TDisciplineExample example);

    int insert(TDiscipline record);

    int insertSelective(TDiscipline record);

    List<TDiscipline> selectByExample(TDisciplineExample example);

    int updateByExampleSelective(@Param("record") TDiscipline record, @Param("example") TDisciplineExample example);

    int updateByExample(@Param("record") TDiscipline record, @Param("example") TDisciplineExample example);
}