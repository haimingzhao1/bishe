package com.bm.dao;

import com.bm.model.TDiscipline;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TDisciplineMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(TDiscipline record);

    int insertSelective(TDiscipline record);

    TDiscipline selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TDiscipline record);

    int updateByPrimaryKey(TDiscipline record);

    List<TDiscipline> findDisciplines();
}