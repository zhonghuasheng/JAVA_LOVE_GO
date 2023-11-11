package com.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionListener
 *
 */
@WebListener
public class MyHttpSessionListener implements HttpSessionListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionListener() {
        // TODO Auto-generated constructor stub
    }

	/**
     * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
     */
    public void sessionCreated(HttpSessionEvent httpSessionEvent)  { 
         System.out.println(httpSessionEvent.getSession().getId());
    }

	/**
     * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
     */
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent)  { 
         System.out.println("HttpSessionListener destoryed");
    }
}
