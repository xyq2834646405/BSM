package com.xyq.dao;

import java.util.List;

public interface IDao<K,V> {
    /**
     * 实现数据的增加操作
     * @param vo 要增加的数据对象
     * @return 如果添加成功返回true,否则返回false
     * @throws Exception
     */
    public boolean doCreate(V vo) throws Exception;

    /**
     * 实现数据的修改操作
     * @param vo 要修改的数据对象
     * @return 如果修改成功返回true,否则返回false
     * @throws Exception
     */
    public boolean doUpdate(V vo) throws Exception;

    /**
     * 实现数据的批量删除操作
     * @param ids 包含要删除的数据的ID信息
     * @return 如果删除成功返回true,否则返回false
     * @throws Exception
     */
    public boolean doRemoveBatch(List<K> ids) throws Exception;

    /**
     * 查询全部数据
     * @return 如果没有数据返回的数据集长度为0
     * @throws Exception
     */
    public List<V> findAll() throws Exception;

    /**
     * 分页查询全部数据,要求计算出开始页
     * @param currentPage 当前页
     * @param lineSize 每页显示的数据量
     * @return 如果没有数据返回的数据集长度为0
     * @throws Exception
     */
    public List<V> findAllBySplit(Integer currentPage,Integer lineSize) throws Exception;

    /**
     * 根据ID查询一个数据信息
     * @param id 主键编号
     * @return 如果现在查询到内容则以VO对象返回,否则返回null
     * @throws Exception
     */
    public V findById(K id) throws Exception;

    /**
     * 查询全部数据量,使用count()函数
     * @return 如果没有内容返回0,有内容返回一个统计结果
     * @throws Exception
     */
    public Integer getAllCount() throws Exception;
}
