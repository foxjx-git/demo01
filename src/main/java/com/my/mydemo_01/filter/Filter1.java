package com.my.mydemo_01.filter;

import com.my.mydemo_01.entity.UserTokenEntity;
import com.my.mydemo_01.service.UserTokenService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Filter1 implements Filter {
    private List<String> excludePatterns;
    private UserTokenService userTokenService;

    public void setUserTokenService(UserTokenService userTokenService) {
        this.userTokenService = userTokenService;
    }


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        String excludePatternsString = filterConfig.getInitParameter("excludePatterns");
        if (excludePatternsString != null) {
            excludePatterns = Arrays.asList(excludePatternsString.split(","));
            System.out.println("excludePatterns are: " + excludePatterns);
        }
        System.out.println("Filter1 init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        final HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        String requestURI = httpRequest.getRequestURI();
        if (excludePatterns.contains(requestURI)) {
            System.out.println("the url is in the excludePatterns");
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            String token = httpRequest.getHeader("Authorization");
            final UserTokenEntity userTokenEntity = userTokenService.isValidToken(token);
            if (token == null || userTokenEntity == null) {
                httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                httpResponse.getWriter().write("Unauthorized access");
                System.out.println("Unauthorized access -my");
                return;
            }else {
                System.out.println("token is valid");
                System.out.println("userTokenEntity : "+userTokenEntity);
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }

    }

    @Override
    public void destroy() {
        System.out.println("Filter1 destroy");
    }


}
