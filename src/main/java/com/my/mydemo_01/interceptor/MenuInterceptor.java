package com.my.mydemo_01.interceptor;

import com.my.mydemo_01.annotations.MenuMapping;
import com.my.mydemo_01.controller.MenuController;
import com.my.mydemo_01.res.Result;
import com.my.mydemo_01.service.MenuSerivice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
@Component
public class MenuInterceptor implements HandlerInterceptor {


    @Autowired
    private MenuSerivice menuSerivice;
    @PostConstruct
    public void init() {
        System.out.println("MenuSerivice in @PostConstruct: " + menuSerivice);
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle is calling");
        String token =null;
        if(handler instanceof HandlerMethod){
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            token = request.getParameter("userToken");
        }
        Class<MenuController> menuControllerClass = MenuController.class;
        Method menu1 = menuControllerClass.getDeclaredMethod("menu1", String.class);
        MenuMapping annotation = menu1.getAnnotation(MenuMapping.class);
        String menuKey = annotation.value();
        System.out.println("menuKey: "+menuKey);
        System.out.println("menuSerivice: "+menuSerivice);
        Result<String> result = menuSerivice.isValidMenu(token, menuKey);
        if (result.getCode()==1){
            return true;
        }else{
            return false;
        }


    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle is calling");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion is calling");
    }
}
