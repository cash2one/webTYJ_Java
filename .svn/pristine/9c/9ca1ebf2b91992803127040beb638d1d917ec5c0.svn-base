package com.flf.servlet;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
/**
 * @see <code>文件上传工具类</code>
 * @author zhuwei
 * @date 2015-07-15 下午 4:20
 */
public class FileService extends HttpServlet{

	private static final long serialVersionUID = 6278961022470861589L;
	
	//上传文件的保存路径  
    protected String configPath = "upload";  
  
    //上传文件的临时保存路径 
    protected String dirTemp = "upload/temp";  
      
    protected String dirName = "file";  
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html; charset=UTF-8");  
        PrintWriter out = response.getWriter();  
          
        //文件保存目录路径  
        String savePath = this.getServletContext().getRealPath("/") + configPath;  
        
        //返回的路径
        String backPath = "/" + configPath;
          
        // 临时文件目录   
        String tempPath = this.getServletContext().getRealPath("/") + dirTemp;  
          
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");  
        String ymd = sdf.format(new Date());  
        savePath += File.separator + ymd;
        
        backPath += File.separator + ymd;
        //创建文件夹  
        File dirFile = new File(savePath);  
        if (!dirFile.exists()) {  
            dirFile.mkdirs();  
        }  
          
        tempPath += File.separator + ymd;
        //创建临时文件夹  
        File dirTempFile = new File(tempPath);  
        if (!dirTempFile.exists()) {  
            dirTempFile.mkdirs();  
        }  
          
        DiskFileItemFactory  factory = new DiskFileItemFactory();  
        factory.setSizeThreshold(20 * 1024 * 1024); //设定使用内存超过5M时，将产生临时文件并存储于临时目录中。     
        factory.setRepository(new File(tempPath)); //设定存储临时文件的目录。     
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setHeaderEncoding("UTF-8");  
        try {  
            List items = upload.parseRequest(request);  
            Iterator itr = items.iterator();  
              
            while (itr.hasNext())   
            {  
                FileItem item = (FileItem) itr.next();  
                String fileName = item.getName();  
                long fileSize = item.getSize();  
                if (!item.isFormField()) {  
                    String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();  
                    SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");  
                    String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;  
                    try{  
                        File uploadedFile = new File(savePath, newFileName);  
                        
                        OutputStream os = new FileOutputStream(uploadedFile);  
                        InputStream is = item.getInputStream();  
                        byte buf[] = new byte[10240];//可以修改 1024 以提高读取速度  
                        int length = 0;    
                        while( (length = is.read(buf)) > 0 ){    
                            os.write(buf, 0, length);    
                        }    
                        //关闭流    
                        os.flush();  
                        os.close();    
                        is.close();    
                        out.print(backPath+File.separator+newFileName);  
                    }catch(Exception e){  
                        e.printStackTrace();  
                    }  
                }          
            }   
              
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        }  
        out.flush();  
        out.close(); 
		
	}

}
