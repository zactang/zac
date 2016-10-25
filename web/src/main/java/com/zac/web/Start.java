package com.zac.web;

import java.io.File;  
import java.net.InetAddress;  
import java.net.UnknownHostException;  
//  
//import org.apache.catalina.Context;  
//import org.apache.catalina.Engine;  
//import org.apache.catalina.Host;  
//import org.apache.catalina.startup.Embedded;  

public class Start {

	/*private static Embedded tomcat;  
	  
    public static void main(String[] args) {   
        // set the path for tomcat embed  
        String path = "F:/myDaRepository/apache-tomcat-embed";  
        Embedded tc = createTomcat(path);  
        try {  
            tc.start();  
            System.out.println("Tomcat Server start over");  
//          tc.stop();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    private static Embedded createTomcat(String path) {  
        // create Tomcat Server Instance  
        tomcat = new Embedded();  
        // set the tomcat home  
        tomcat.setCatalinaHome(path);  
        // create the Tomcat engine  
        Engine engine = tomcat.createEngine();  
        engine.setName("MyTestServer");  
        // create the host  
        Host host = tomcat.createHost("localhost", tomcat.getCatalinaHome()  
                + "/webapps");  
        // put the host into engine  
        engine.addChild(host);  
        engine.setDefaultHost(host.getName());  
  
        String javayouPath = host.getAppBase() + "/CloudscapeDemo";  
        if (!new File(javayouPath).exists()) {  
            System.err.println("Please test if the javayou exists");  
            return null;  
        }  
        System.out.println("javayouPath"+javayouPath);  
        // create the context, and add it to the host  
        Context ctxtJavayou = tomcat  
                .createContext("/CloudscapeDemo", javayouPath);  
        host.addChild(ctxtJavayou);  
  
        tomcat.addEngine(engine);  
        try {  
            // put the Connector to Tomcat,listen the local visit from 127.0.0.1  
            tomcat.addConnector(tomcat.createConnector(InetAddress  
                    .getByName("127.0.0.1"), 8080, false));  
        } catch (UnknownHostException e) {  
            System.err  
                    .println("can not bind tomcat Server to the localhost 127.0.0.1:8080;test the host is free");  
            e.printStackTrace();  
            tomcat = null;  
        }  
        return tomcat;  
    }  
  
    public void shutdown() throws Exception {  
        tomcat.stop();  
    }  
*/
}



  
    
