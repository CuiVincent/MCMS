package com.mcms.sfw.common.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@Repository
public interface CommonDao {

	public boolean add(String key, Object object) throws Exception;
	
	public boolean delete(String key, String id) throws Exception;

	public boolean delete(String key, Object object) throws Exception;

    public boolean update(String key, String id) throws Exception;

    public boolean update(String key, Object object) throws Exception;

	public <T> T find(String key, Object params) throws Exception ;

	public <T> List<T> findList(String key) throws Exception;
	
	public <T> List<T> findList(String key, Object params) throws Exception;
}
