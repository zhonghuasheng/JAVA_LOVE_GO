package com.servlet.listener;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

/**
 * Application Lifecycle Listener implementation class MyServletRequestListerner
 *
 */
@WebListener
public class MyServletRequestListerner implements ServletRequestListener {

    /**
     * Default constructor. 
     */
    public MyServletRequestListerner() {}

    /**
     * @see ServletRequestListener#requestDestroyed(ServletRequestEvent)
     */
    public void requestDestroyed(ServletRequestEvent servletRequestEvent)  { 
         System.out.println(servletRequestEvent.toString());
    }

    /**
     * @see ServletRequestListener#requestInitialized(ServletRequestEvent)
     */
    public void requestInitialized(ServletRequestEvent servletRequestEvent)  { 
         System.out.println("ServletRequestListener initialized");
    }
}
