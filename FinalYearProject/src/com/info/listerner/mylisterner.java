package com.info.listerner;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;



@WebListener
public class mylisterner implements ServletContextListener {
	int count=1;
   
    public void contextDestroyed(ServletContextEvent sce)
    { 
         System.out.println(" your container has bein destroyed ");
         ServletContext application = sce.getServletContext();
    	 count=(int)application.getAttribute("counter");
         
         try {
			FileWriter fout = new FileWriter("NumberofCount.txt");
			fout.write(count);
			fout.close();
		} catch (IOException e) {System.out.println(e);}
       
    }

    public void contextInitialized(ServletContextEvent sce)  
    { 
    	 System.out.println(" your container has bein created  ");
    	 ServletContext application = sce.getServletContext();
    	 application.setAttribute("counter", count);
    	 
    	 try {
    		File file =new File("NumberofCount.txt");
    		if(file.createNewFile())
    		{
    			System.out.println("file has been created");	
    		}
 			FileReader fin = new FileReader(file);
 			count= fin.read();
 			application.setAttribute("counter", count);
 			fin.close();
 			
 		    } catch (IOException e) {System.out.println(e);}
    	
    	 
    }
	
}
