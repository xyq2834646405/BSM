package com.xyq.service;

import com.xyq.vo.News;

import java.util.List;
import java.util.Map;

public interface INewsService {
    /**
     * 增加新闻数据,本次操作执行一下功能:
     * <li>1、执行INewsDao.findByTitle()方法判断标题是否存在</li>
     * <li>2、执行INewsDao.doCreate()方法实现数据增加</li>
     * @param vo
     * @return 增加成功返回true,否则返回false
     * @throws Exception
     */
    public boolean insert(News vo) throws Exception;

    /**
     * 检查标题信息是否存在,这个的操作是基于News对象的为null的判断
     * @param title 新闻标题
     * @return 如果存在则返回false,否则返回true
     * @throws Exception
     */
    public boolean checkTitle(String title) throws Exception;

    /**
     * 修改检查标题信息是否存在,这个操作是基于News对象的为null的判断
     * @param nid 新闻编号
     * @param title 新闻标题
     * @return 如果存在则返回false,否则返回true
     * @throws Exception
     */
    public boolean checkTitleForUpdate(int nid,String title) throws Exception;

    /**
     * 新闻数据的批量删除操作
     * @param vo
     * @return
     * @throws Exception
     */
    public boolean update(News vo) throws Exception;

    /**
     * 新闻数据的批量删除操作
     * @param ids
     * @return
     * @throws Exception
     */
    public boolean delete(List<Integer> ids) throws Exception;

    /**
     * 实现新闻数据的列表显示
     * @param currentPage 当前所在页
     * @param lineSize 每页显示的数据行
     * @return 返回Map集合,包含有以下内容:
     * <li>1、key=allNewses,value=INewsDao.findAll(currentPage,lineSize)</li>
     * <li>2、key=newsCount,value=INewsDao.getAllCount()</li>
     * @throws Exception
     */
    public Map<String,Object> list(int currentPage,int lineSize) throws Exception;

    /**
     * 查询单个新闻数据
     * @param nid 新闻编号
     * @return 如果有内容则返回vo对象,否则返回null
     * @throws Exception
     */
    public News get(int nid) throws Exception;
}