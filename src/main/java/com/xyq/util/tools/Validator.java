package com.xyq.util.tools;

import javax.servlet.http.HttpServletRequest;

public class Validator {
    public boolean validate(HttpServletRequest request,String rule){
        boolean flag = true;
        String[] result = rule.split("\\|");
        for (int i = 0; i < result.length; i++) {
            String[] temp = result[i].split(":");
            String value = request.getParameter(temp[0]);
            if (value!=null){
                if ("string".equals(temp[1])){
                    flag = validateString(value);
                }else if("number".equals(temp[1])){
                    flag = validateNumber(value);
                }else if("date".equals(temp[1])){
                    flag = validateDate(value);
                }
                if(flag == flag){
                    request.setAttribute(temp[0],"ruleError");
                }
            }else{
                flag = false;
                request.setAttribute(temp[0],"valueError");
            }
        }
        return flag;
    }

    /**
     * 验证string数据
     * @param str
     * @return
     */
    public boolean validateString(String str){
        if(str==null||"".equals(str))
            return false;
        return true;
    }

    /**
     * 验证number数据
     * @param str
     * @return
     */
    public boolean validateNumber(String str){
        if(validateString(str))
            return str.matches("\\d+(\\.\\d+)?");
        return false;
    }

    /**
     * 验证date数据
     * @param str
     * @return
     */
    public boolean validateDate(String str) {
        if (validateString(str))
            if (str.matches("\\d{4}-\\d{2}-\\d{2}"))
                return true;
            else
                return str.matches("\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}");
        return false;
    }
}
