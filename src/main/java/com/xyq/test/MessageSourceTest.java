package com.xyq.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Locale;

public class MessageSourceTest {
    private static ApplicationContext context;
    private static MessageSource messageSource;

    static{
        context = new ClassPathXmlApplicationContext("applicationContext.xml");
        messageSource = context.getBean("messageSource",MessageSource.class);
    }

    @Test
    public void Resource(){
        System.out.println(context);
        System.out.println(messageSource);
        System.out.println(messageSource.getMessage("news.insert.page",null, Locale.CHINA));
    }
}
