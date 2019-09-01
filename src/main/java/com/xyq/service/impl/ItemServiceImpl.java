package com.xyq.service.impl;

import com.xyq.dao.IItemDao;
import com.xyq.service.IItemService;
import com.xyq.vo.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {
    @Autowired
    private IItemDao itemDao;

    public List<Item> list() throws Exception {
        return itemDao.findAll();
    }
}
