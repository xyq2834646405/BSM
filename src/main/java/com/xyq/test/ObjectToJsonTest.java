package com.xyq.test;

import com.xyq.util.tools.ObjectToJson;
import com.xyq.vo.News;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class ObjectToJsonTest {

    @Test
    public void convertListToJson() {
        List<News> all = new ArrayList<News>();
        for (int i = 0; i < 10; i++) {
            News vo = new News();
            vo.setNid(i);
            vo.setTitle("测试-"+i);
            vo.setContent("内容-"+i);
            vo.setPubdate(new Date());
            all.add(vo);
        }
        System.out.println(ObjectToJson.convertListToJson("allNewses",all));
    }

    @Test
    public void convertObjectToJson() {
        News vo = new News();
        vo.setNid(10);
        vo.setTitle("测试");
        vo.setContent("内容");
        vo.setPubdate(new Date());
        System.out.println(ObjectToJson.convertObjectToJson(vo));
    }
}