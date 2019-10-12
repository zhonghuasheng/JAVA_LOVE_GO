package com.servlet.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

/**
 * Application Lifecycle Listener implementation class MyHttpSessionAttibuteListener
 *
 */
@WebListener
public class MyHttpSessionAttibuteListener implements HttpSessionAttributeListener {

    /**
     * Default constructor. 
     */
    public MyHttpSessionAttibuteListener() {
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpSessionAttributeListener#attributeRemoved(HttpSessionBindingEvent)
     */
    public void attributeRemoved(HttpSessionBindingEvent arg0)  { 
         // TODO Auto-generated method stub
    }

    /**
     * @see HttpSessionAttributeListener#attributeAdded(HttpSessionBindingEvent)
     */
    public void attributeAdded(HttpSessionBindingEvent arg0)  { 
         System.out.println("Added a session attribute");
    }

    /**
     * @see HttpSessionAttributeListener#attributeReplaced(HttpSessionBindingEvent)
     */
    public void attributeReplaced(HttpSessionBindingEvent arg0)  { 
         System.out.println("Replaced a session attribute");
    }
}
