package com.servlet.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * Servlet Filter implementation class EncryptionFilter
 */
public class EncryptionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public EncryptionFilter() {
    }

    /**
     * @see Filter#destroy()
     */
    public void destroy() {
        System.out.println("Encryption Filter Destroy");
    }

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Encryption Filter");
        chain.doFilter(request, response);
        System.out.println("Encryption Filter Done");
    }

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig fConfig) throws ServletException {
        System.out.println("Encryption Filter Init");
    }

}
