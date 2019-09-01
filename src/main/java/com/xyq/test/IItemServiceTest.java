package com.xyq.test;


import com.xyq.service.IItemService;
import com.xyq.vo.Item;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class IItemServiceTest {
    private static ApplicationContext context;
    private static IItemService itemService;

    static{
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        itemService = context.getBean("itemServiceImpl",IItemService.class);
    }

    @Test
    public void list() throws Exception{
        List<Item> all = itemService.list();
        System.out.println(all);
        TestCase.assertTrue(all.size()>0);
    }
}