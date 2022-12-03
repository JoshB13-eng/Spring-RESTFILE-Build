
//Controller class interceptor
package JoshA.Interceptor;

import javax.servlet.http.HttpServletRequest; 
import javax.servlet.http.HttpServletResponse; 
 import org.springframework.stereotype.Component; 
import org.springframework.web.servlet.HandlerInterceptor; 
import org.springframework.web.servlet.ModelAndView; 
import java.util.Enumeration;
import java.util.Map;
import java.util.HashMap;
import java.util.Map.Entry;
import JoshA.Control.FileController;

@Component 
public class FileInterceptor implements HandlerInterceptor {   
    
    @Override  public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception {   
        //Get some information about request sent to server
        System.out.println("\nReturn part of this request's URL that calls the servlet.-->["+request.getServletPath()+"]");
        
        System.out.println("\nThe kind of request sent is-->["+request.getMethod()+"]");
        return true;
    }   
    
    //Dont need the postHandle method
    
    @Override public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception{   
        //Exit application
        
        if(request.getServletPath().equals("/JoshFile/Exit")){
            //if the request URL sent is "/JoshFile/Exit"
            System.out.println("\nShutting down Server.....");
            
            System.exit(0);
            //Exit app
        }
        
    }
    
 }
 
