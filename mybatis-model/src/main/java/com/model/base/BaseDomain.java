package com.model.base;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 领域对象基类
 * 主要处理数据库操作
 * Created by ivan on 14-10-12.
 */
public class BaseDomain<T,E, M extends Mapper> {

    @Autowired
    private M mapper;

    @Autowired
    private SqlSession sqlSession;

    public SqlSession getSqlSession() {
        return sqlSession;
    }

    public int insert() {
        return mapper.insert(this);
    }

    public int insertSelective() {
        return mapper.insertSelective(this);
    }

    public T selectByPrimaryKey(Long recId) {
        Object o = mapper.selectByPrimaryKey(recId);
        BeanUtils.copyProperties(o, this);
        return (T) this;
    }

    public List<T> selectByExample(E example) {
        List list = mapper.selectByExample(example);
        List<T> result = new ArrayList<T>();
        if (list != null) {
            for (Object o : list) {
                try {
                    T t = (T) this.getClass().newInstance();
                    BeanUtils.copyProperties(o, t);
                    result.add(t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public int updateByPrimaryKey(T record) {
        return mapper.updateByPrimaryKey(record);
    }

    public int countByExample(E example) {
        return mapper.countByExample(example);
    }

    public int deleteByExample(E example) {
        return mapper.deleteByExample(example);
    }

    public int deleteByPrimaryKey(Long recId) {
        return mapper.deleteByPrimaryKey(recId);
    }

    public int updateByExampleSelective(E example) {
        return mapper.updateByExampleSelective(this, example);
    }

    public int updateByExample(E example) {
        return mapper.updateByExample(this, example);
    }

    public int updateByPrimaryKeySelective() {
        return mapper.updateByPrimaryKeySelective(this);
    }

    public int updateByExampleWithBLOBs(E example) {
        return mapper.updateByExampleWithBLOBs(this, example);
    }

    public List<T> selectByExampleWithBLOBs(E example) {
        List list = mapper.selectByExampleWithBLOBs(example);
        List<T> result = new ArrayList<T>();
        if (list != null) {
            for (Object o : list) {
                try {
                    T t = (T) this.getClass().newInstance();
                    BeanUtils.copyProperties(o, t);
                    result.add(t);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    public int updateByPrimaryKeyWithBLOBs(T record) {
        return mapper.updateByPrimaryKeyWithBLOBs(record);
    }
}
