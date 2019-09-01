package com.xyq.dao;

import com.xyq.vo.News;

public interface INewsDao extends IDao<Integer, News> {
    /**
     * 根据标题查询是否存在有信息
     * @param title 要查询的标题
     * @return 如果有对应的标题内容返回vo对象,否则返回null
     * @throws Exception
     */
    public News findByTitle(String title) throws Exception;

    /**
     * 修改时,根据标题和编号查询是否存在有信息
     * @param nid 新闻编号
     * @param title 新闻标题
     * @return 如果有对应的标题内容返回vo对象,否则返回null
     * @throws Exception
     */
    public News findByTitleForUpdate(Integer nid,String title) throws Exception;
}
