
//My Interceptpr class register
package JoshA.Interceptor;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Component; 
import org.springframework.web.servlet.config.annotation.InterceptorRegistry; 
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Component 
public class FileInterceptorConfig implements WebMvcConfigurer{   
    
    @Autowired  
    FileInterceptor Cwi; 
    
     @Override  public void addInterceptors(InterceptorRegistry registry) {   
         
         registry.addInterceptor(Cwi);
     } 
    
}