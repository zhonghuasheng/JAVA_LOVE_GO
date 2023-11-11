package com.zhonghuasheng.springboot.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter @WebListener @WebServlet需要启用@ServletComponentScan来注入bean
@WebFilter(filterName = "customFilter", urlPatterns = "/*")
public class CustomFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomFilter int method");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("CustomFilter doFilter method");
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        System.out.println("CustomFilter destroy method");
    }
}
