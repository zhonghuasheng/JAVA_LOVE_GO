package com.servlet.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

@WebFilter(filterName="LogFilter", urlPatterns="/*")
public class LogFilter implements Filter {

    public void destroy() {
        // TODO Auto-generated method stub

    }

    public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
        System.out.println("Log Filter");
        chain.doFilter(arg0, arg1);
        System.out.println("Log Filter End");
    }

    public void init(FilterConfig arg0) throws ServletException {}

}
