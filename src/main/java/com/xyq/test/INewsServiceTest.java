package com.xyq.test;

import com.xyq.service.IItemService;
import com.xyq.service.INewsService;
import com.xyq.vo.Item;
import com.xyq.vo.News;
import junit.framework.TestCase;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class INewsServiceTest {
    private static ApplicationContext context;
    private static INewsService newsService;

    static{
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        newsService = context.getBean("newsServiceImpl",INewsService.class);
    }

    @Test
    public void insert() throws Exception{
        News vo = new News();
        vo.setTitle("新闻标题-"+System.currentTimeMillis());
        vo.setContent("新闻内容-"+System.currentTimeMillis());
        vo.setPubdate(new Date());
        Item item = new Item();
        item.setIid(1);
        vo.setItem(item);
        TestCase.assertTrue(newsService.insert(vo));
    }

    @Test
    public void checkTitle() throws Exception{
        TestCase.assertTrue(newsService.checkTitle("hello"));
    }

    @Test
    public void update() throws Exception{
        News vo = new News();
        vo.setNid(1);
        vo.setTitle("恭喜大家毕业");
        vo.setContent("祝你们工作越来越好,加油");
        Item item = new Item();
        item.setIid(2);
        vo.setItem(item);
        TestCase.assertTrue(newsService.update(vo));
    }

    @Test
    public void delete() throws Exception{
        List<Integer> ids = new ArrayList<Integer>();
        ids.add(1);
        TestCase.assertTrue(newsService.delete(ids));
    }

    @Test
    public void list() throws Exception{
        Map<String, Object> map = newsService.list(1, 2);
        System.out.println(map.get("allNewses"));
        System.out.println(map.get("newsCount"));
        TestCase.assertTrue(map.size()==2);
    }

    @Test
    public void get() throws Exception{
        TestCase.assertTrue(newsService.get(2)!=null);
    }
}