package com.atguigu.crud.dao;

import com.atguigu.crud.bean.RedList;
import com.atguigu.crud.bean.RedListExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RedListMapper {
    long countByExample(RedListExample example);

    int deleteByExample(RedListExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(RedList record);

    int insertSelective(RedList record);

    List<RedList> selectByExample(RedListExample example);

    RedList selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") RedList record, @Param("example") RedListExample example);

    int updateByExample(@Param("record") RedList record, @Param("example") RedListExample example);

    int updateByPrimaryKeySelective(RedList record);

    int updateByPrimaryKey(RedList record);
}