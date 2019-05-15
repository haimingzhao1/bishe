package com.bm.dao;

import com.bm.model.BookDomain;
import com.bm.model.TBook;
import com.bm.model.TBookExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TBookMapper {

    long countByExample(TBookExample example);

    int deleteByExample(TBookExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TBook record);

    int insertSelective(TBook record);

    List<TBook> selectByExample(TBookExample example);

    TBook selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TBook record, @Param("example") TBookExample example);

    int updateByExample(@Param("record") TBook record, @Param("example") TBookExample example);

    int updateByPrimaryKeySelective(TBook record);

    int updateByPrimaryKey(TBook record);

    List<BookDomain> queryBook(@Param(value = "booknum") String booknum, @Param(value = "bookname") String bookname);

    BookDomain findBookById(Integer bookid);
}