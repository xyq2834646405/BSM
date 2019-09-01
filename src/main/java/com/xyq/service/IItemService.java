package com.xyq.service;

import com.xyq.vo.Item;

import java.util.List;

public interface IItemService {
    /**
     * 列出全部的新闻类型
     * @return
     * @throws Exception
     */
    public List<Item> list() throws Exception;
}