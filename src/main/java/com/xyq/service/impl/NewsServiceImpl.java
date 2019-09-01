package com.xyq.service.impl;

import com.xyq.dao.INewsDao;
import com.xyq.service.INewsService;
import com.xyq.vo.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class NewsServiceImpl implements INewsService {
    @Autowired
    private INewsDao newsDao;

    public boolean insert(News vo) throws Exception {
        if(newsDao.findByTitle(vo.getTitle())==null){//没有重复的标题
            return newsDao.doCreate(vo);
        }
        return false;
    }

    public boolean checkTitle(String title) throws Exception {
        return newsDao.findByTitle(title)==null;
    }

    public boolean checkTitleForUpdate(int nid, String title) throws Exception {
        return newsDao.findByTitleForUpdate(nid,title)==null;
    }

    public boolean update(News vo) throws Exception {
        if(newsDao.findByTitleForUpdate(vo.getNid(),vo.getTitle())==null){//没有重复的记录
            return newsDao.doUpdate(vo);
        }
        return false;
    }

    public boolean delete(List<Integer> ids) throws Exception {
        return newsDao.doRemoveBatch(ids);
    }

    public Map<String, Object> list(int currentPage, int lineSize) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("allNewses",newsDao.findAllBySplit(currentPage,lineSize));
        map.put("newsCount",newsDao.getAllCount());
        return map;
    }

    public News get(int nid) throws Exception {
        return newsDao.findById(nid);
    }
}
