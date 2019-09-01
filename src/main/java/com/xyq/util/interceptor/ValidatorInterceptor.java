package com.xyq.util.interceptor;

import com.xyq.util.tools.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class ValidatorInterceptor implements HandlerInterceptor {
    @Autowired
    private MessageSource messageSource;

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        HandlerMethod handlerMethod = (HandlerMethod) obj;
        try {
            String validator = handlerMethod.getBean().getClass().getSimpleName()+"."+handlerMethod.getMethod().getName();
            String path = handlerMethod.getBean().getClass().getSimpleName()+"."+handlerMethod.getMethod().getName()+".error";
            String validatorValue = messageSource.getMessage(validator,null, Locale.getDefault());
            String pathValue = messageSource.getMessage(path,null, Locale.getDefault());
            if(validatorValue!=null){
                if(new Validator().validate(request,validatorValue)){
                    return true;
                }else {
                    request.getRequestDispatcher(pathValue).forward(request,response);
                    return false;
                }
            }
        }catch (Exception e){}
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
