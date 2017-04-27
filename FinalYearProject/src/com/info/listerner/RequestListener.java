package com.info.listerner;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class RequestListener implements ServletRequestListener
{

  
    public void requestInitialized(ServletRequestEvent arg0)
    { 
        
    }
    
    public void requestDestroyed(ServletRequestEvent arg0) 
    { 
        
    }
}
