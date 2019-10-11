package com.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class DataCompressionFilter
 */
public class DataCompressionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public DataCompressionFilter() {}

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        System.out.println("Data Comporession Filter Destory");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Data Comporession Filter");
        chain.doFilter(request, response);
        System.out.println("Data Comporession Filter Done");
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("Data Comporession Filter Init");
    }

}
