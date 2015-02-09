package com.model.base;

import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by ivan on 14-10-12.
 */
public interface Mapper<T,E> {

    int countByExample(E example);

    int deleteByExample(E example);

    int deleteByPrimaryKey(Long recId);

    int insert(T record);

    int insertSelective(T record);

    List<T> selectByExampleWithBLOBs(E example);

    List<T> selectByExample(E example);

    T selectByPrimaryKey(Long recId);

    int updateByExampleSelective(@Param("record") T record, @Param("example") E example);

    int updateByExampleWithBLOBs(@Param("record") T record, @Param("example") E example);

    int updateByExample(@Param("record") T record, @Param("example") E example);

    int updateByPrimaryKeySelective(T record);

    int updateByPrimaryKeyWithBLOBs(T record);

    int updateByPrimaryKey(T record);
}
