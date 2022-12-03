
package JoshA.Control;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.InputStreamResource;

import java.io.File; 
import java.io.FileOutputStream; 
import java.io.FileInputStream; 
import java.io.IOException;



@RestController
@RequestMapping(path = "/JoshFile")
public class FileController{
    
    public byte[] bytes;
    
    @GetMapping(path="/Download", produces=MediaType.MULTIPART_FORM_DATA_VALUE)  
    
    public ResponseEntity<Object> downloadFile()throws IOException{ 
        //To get/download file from server 
        //String filename = "/storage/internal/Codings/Java/GitHub/Spring-RESTFILE-Build/FileBoxB/2DPicx.jpg"; 
        String filename = "./FileBoxB/2DPicx.jpg"; 
        File file = new File(filename); 
        
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file)); 
        
        HttpHeaders headers = new HttpHeaders();
        
        headers.add("Content-Disposition","attachment; filename="+file.getName()); 
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate"); 
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0"); 
        
        ResponseEntity<Object> responseEntity = ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/txt")).body(resource); 
        
        return responseEntity; 
    }
    
    
    @PostMapping(value="/Upload", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String fileUpload(@RequestParam("file") MultipartFile file) throws IOException{
        //To post/upload file
        bytes = file.getBytes();
        
        return "File is upload successfully"; 
    } 
 
    @RequestMapping(path = "/Exit")
    public ResponseEntity<Object> Exit(){
        //Application will be shutdown in afterCompletion() of my Interceptor class which is after request and response operation has been completed
        return new ResponseEntity<>("Shutting down server...\n", HttpStatus.OK);
    }
}


//To download file
//Shell: curl http://localhost:9090/JoshFile/Download > /path/to/file
//OR
//Browser: http://localhost:9090/JoshFile/Download
//THE ABOVE IS FOR .downloadFile()


//To Upload file:
//Shell: curl  -X POST  -i  -F "file=@/path/to/file" -F "additional_parm=param2" http://localhost:9090/JoshFile/Upload
//THE ABOVE IS FOR .fileUpload()


//In order to exit this program:
//Shell: For the sake of this FruitController example-->curl http://localhost:9090/JoshFile/Exit
//THE ABOVE IS FOR .Exit()