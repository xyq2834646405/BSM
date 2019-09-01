package com.xyq.util.tools;

import com.xyq.util.StringUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

/**
 * 负责vo对象转json对象之间的转换处理
 */
public class ObjectToJson {
    public static JSONObject convertListToJson(String name,List<?> all){
        JSONObject obj = new JSONObject();
        JSONArray array = new JSONArray();
        Iterator<?> iter = all.iterator();
        while (iter.hasNext()){
            array.add(convertObjectToJson(iter.next()));
        }
        obj.put(name,array);
        return obj;
    }

    public static JSONObject convertObjectToJson(Object vo){
        JSONObject obj = new JSONObject();
        Field[] fields = vo.getClass().getDeclaredFields();
        for (int i = 0; i < fields.length ; i++) {
            Field f = fields[i];
            String methodName = "get"+ StringUtils.initCap(f.getName());
            try {
                Method method = vo.getClass().getMethod(methodName);
                if("Date".equalsIgnoreCase(f.getType().getSimpleName())){
                    Date date = (Date)method.invoke(vo);
                    obj.put(f.getName(),new SimpleDateFormat("yyyy-MM-dd").format(date));
                } else {
                    obj.put(f.getName(),method.invoke(vo));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return obj;
    }

    public static JSONObject convertListSplitToJSON(String name,List<?> all,Integer allRecorders){
        JSONObject obj = convertListToJson(name, all);
        obj.put("allRecorders",allRecorders);
        return obj;
    }
}
