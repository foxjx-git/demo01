package com.my.mydemo_01.config;

import com.my.mydemo_01.filter.Filter1;
import com.my.mydemo_01.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;

@Configuration
public class FilterConfig {
    @Autowired
    private UserTokenService userTokenService;
    @Bean
    public FilterRegistrationBean<Filter1> filter1(){
        FilterRegistrationBean<Filter1> filterRegistrationBean = new FilterRegistrationBean<>();
        Filter1 myFilter = new Filter1();
        filterRegistrationBean.setFilter(myFilter);
        myFilter.setUserTokenService(userTokenService);
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("excludePatterns","/login,/role,/menu,/menutest,/menu1");
        return filterRegistrationBean;
    }
}
