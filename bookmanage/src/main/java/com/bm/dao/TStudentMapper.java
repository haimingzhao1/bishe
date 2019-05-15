package com.bm.dao;

import com.bm.model.TStudent;
import com.bm.model.TStudentDomain;
import com.bm.model.TStudentExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TStudentMapper {

    long countByExample(TStudentExample example);

    int deleteByExample(TStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TStudent record);

    int insertSelective(TStudent record);

    List<TStudent> selectByExample(TStudentExample example);

    TStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByExample(@Param("record") TStudent record, @Param("example") TStudentExample example);

    int updateByPrimaryKeySelective(TStudent record);

    int updateByPrimaryKey(TStudent record);

    TStudent findByStuNumber(String stuNum);

    List<TStudentDomain> findAllStus();

    TStudentDomain findStudentDomainById(Integer id);
}