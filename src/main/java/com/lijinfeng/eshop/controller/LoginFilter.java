package com.lijinfeng.eshop.controller;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by ljf-梁燕双栖 on 2016/4/19.
 */

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        Integer userId = (Integer) request.getSession().getAttribute("userId");

        //获取请求的URI
        String uri = request.getRequestURI();

        //对URI进行判断，如果是静态资源，就不进行过滤
        if (uri.startsWith("/assets")) {
            filterChain.doFilter (servletRequest, servletResponse);
            return;
        }
        //对未登录的请求进行过滤
        if (userId == null) {
            System.out.println("null:"+ request.getContextPath()+"/");
            request.getRequestDispatcher(request.getContextPath()+"/").forward(servletRequest,servletResponse);
        }
        filterChain.doFilter (servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
