package com.xyq.util.action;

import com.xyq.util.tools.ObjectToJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public abstract class DefaultAction {
    @Autowired
    private MessageSource messageSource;
    private int currentPage = 1;
    private int lineSize = 10;

    /**
     * 处理分页操作数据
     * @param request
     */
    public void handSplit(HttpServletRequest request) {
        try {
            currentPage = Integer.parseInt(request.getParameter("cp"));
        } catch (Exception e) {}
        try {
            lineSize = Integer.parseInt(request.getParameter("ls"));
        } catch (Exception e) {}
    }

    /**
     * 根据key取得资源的信息
     * @param key 资源文件的key
     * @param param 所需要设置的参数
     * @return
     */
    public String getResource(String key,String... param) {
        return messageSource.getMessage(key, param, Locale.getDefault());
    }

    /**
     * 设置跳转的信息以及路径
     * @param mav
     * @param msg
     * @param path
     */
    public void setMsgAndPath(ModelAndView mav,String msg,String path){
        if (mav!=null){
            if(getText()!=null){
                String[] result = getText().split("\\|");
                mav.addObject("msg",messageSource.getMessage(msg,result,Locale.getDefault()));
            }else {
                mav.addObject("msg",messageSource.getMessage(msg,null,Locale.getDefault()));
            }
            mav.addObject("path",messageSource.getMessage(path,null,Locale.getDefault()));
        }
    }

    /**
     * 将对象变为Json输出
     * @param response
     * @param vo
     */
    public void printObjectJson(HttpServletResponse response,Object vo){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJson.convertObjectToJson(vo));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将List集合变为Json输出
     * @param response
     * @param name Json的名字
     * @param all 集合
     */
    public void printListJson(HttpServletResponse response, String name, List<?> all){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJson.convertListToJson(name,all));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将分页参数变为Json输出
     * @param response 响应对象
     * @param name 分页数据名字
     * @param all 分页数据
     * @param allRecorders 数据量
     */
    public void printListSplitJson(HttpServletResponse response, String name, List<?> all, Integer allRecorders){
        response.setCharacterEncoding("UTF-8");
        try {
            response.getWriter().print(ObjectToJson.convertListSplitToJSON(name, all, allRecorders));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 打印信息到页面上
     * @param response
     * @param msg
     */
    public void print(HttpServletResponse response,Object msg){
        try {
            response.getWriter().print(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,false));
    }

    public abstract String getText();

    public int getCurrentPage() {
        return currentPage;
    }

    public int getLineSize() {
        return lineSize;
    }
}