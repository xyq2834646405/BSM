package com.xyq.dao.impl;

import com.xyq.dao.INewsDao;
import com.xyq.vo.News;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class NewsDaoImpl extends SqlSessionDaoSupport implements INewsDao {
    @Autowired
    public NewsDaoImpl(SqlSessionFactory sqlSessionFactory){
        setSqlSessionFactory(sqlSessionFactory);
    }

    public News findByTitle(String title) throws Exception {
        return getSqlSession().selectOne("NewsNS.findByTitle",title);
    }

    public News findByTitleForUpdate(Integer nid, String title) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("title",title);
        map.put("nid",nid);
        return getSqlSession().selectOne("NewsNS.findByTitleForUpdate",map);
    }

    public boolean doCreate(News vo) throws Exception {
        return getSqlSession().insert("NewsNS.doCreate",vo)>0;
    }

    public boolean doUpdate(News vo) throws Exception {
        return getSqlSession().update("NewsNS.doUpdate",vo)>0;
    }

    public boolean doRemoveBatch(List<Integer> ids) throws Exception {
        return getSqlSession().delete("NewsNS.doRemove",ids)>0;
    }

    public List<News> findAll() throws Exception {
        return null;
    }

    public List<News> findAllBySplit(Integer currentPage, Integer lineSize) throws Exception {
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("start",(currentPage-1)*lineSize);
        map.put("lineSize",lineSize);
        return getSqlSession().selectList("NewsNS.findAllBySplit",map);
    }

    public News findById(Integer id) throws Exception {
        return getSqlSession().selectOne("NewsNS.findById",id);
    }

    public Integer getAllCount() throws Exception {
        return getSqlSession().selectOne("NewsNS.getAllCount");
    }
}
