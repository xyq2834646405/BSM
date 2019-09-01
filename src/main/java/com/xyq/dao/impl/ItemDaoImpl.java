package com.xyq.dao.impl;

import com.xyq.dao.IItemDao;
import com.xyq.vo.Item;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ItemDaoImpl extends SqlSessionDaoSupport implements IItemDao {
    @Autowired
    public ItemDaoImpl(SqlSessionFactory sqlSessionFactory){
        setSqlSessionFactory(sqlSessionFactory);
    }

    public boolean doCreate(Item vo) throws Exception {
        return false;
    }

    public boolean doUpdate(Item vo) throws Exception {
        return false;
    }

    public boolean doRemoveBatch(List<Integer> ids) throws Exception {
        return false;
    }

    public List<Item> findAll() throws Exception {
        return getSqlSession().selectList("ItemNS.findAll");
    }

    public List<Item> findAllBySplit(Integer currentPage, Integer lineSize) throws Exception {
        return null;
    }

    public Item findById(Integer id) throws Exception {
        return null;
    }

    public Integer getAllCount() throws Exception {
        return null;
    }
}
