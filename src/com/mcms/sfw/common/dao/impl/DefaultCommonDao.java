package com.mcms.sfw.common.dao.impl;

import com.mcms.sfw.common.dao.CommonDao;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DefaultCommonDao extends SqlSessionDaoSupport implements CommonDao{

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory){
          super.setSqlSessionFactory(sqlSessionFactory);
    }
    @Override
	public boolean add(String key, Object object) {
		return 0<getSqlSession().insert(key, object);
	}
    @Override
	public boolean delete(String key, String id)  {
        return 0< getSqlSession().delete(key, id);
	}
    @Override
	public boolean delete(String key, Object object) {
        return 0< getSqlSession().update(key, object);
	}
    @Override
    public boolean update(String key, String id)  {
        return 0< getSqlSession().delete(key, id);
    }
    @Override
    public boolean update(String key, Object object) {
        return 0< getSqlSession().update(key, object);
    }
    @Override
	public <T> T find(String key, Object params)  {
		return (T) getSqlSession().selectOne(key, params);
	}
    @Override
	public <T> List<T> findList(String key) {
		return getSqlSession().selectList(key);
	}
    @Override
	public <T> List<T> findList(String key, Object params) {
		return getSqlSession().selectList(key, params);
	}
}
