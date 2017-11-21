package com.flf.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.flf.request.PropertyResult;
import com.flf.service.CassetRepositoryService;
import com.flf.service.ContractService;
import com.flf.service.RoleService;
import com.flf.service.UnionpayCollectionTotallService;

@Controller
@RequestMapping(value="/Controller/Contract")
public class ContractController  {
	
	@Autowired
	private ContractService contractService;
	
	@Autowired
	private UnionpayCollectionTotallService unionpayCollectionTotallService;
	
	@RequestMapping(value={"/uploadContract"},method=RequestMethod.POST)//,method=RequestMethod.POST)
    public void upload(@RequestParam("file") MultipartFile file[], HttpServletRequest request, ModelMap model) {  
		
		
		System.out.println("开始");
		JSONObject json=JSONObject.fromObject(request.getParameter("PropertyResult"));
		
		PropertyResult propertyResult=(PropertyResult) JSONObject.toBean(json,PropertyResult.class);
		 System.out.println(propertyResult.getBuildingStructureNews());
         String path = request.getSession().getServletContext().getRealPath("upload"); 
         List<PropertyResult> propertyResults=new ArrayList<PropertyResult>();
         String fileName="";
         for (int i = 0; i < file.length; i++) {
        	   fileName = file[i].getOriginalFilename();  
        	   System.out.println(path);  
               File targetFile = new File(path, fileName);  
               if(!targetFile.exists()){  
                   targetFile.mkdirs();  
               }  
         
               //保存  
               try {  
                   file[i].transferTo(targetFile);  
               } catch (Exception e) {  
                   e.printStackTrace();  
               }
               PropertyResult P=new PropertyResult();
            /*   P.setBase64Str(request.getContextPath()+"/upload/"+fileName); //文件路径
               P.setFilename(fileName); //文件名称
*/               propertyResults.add(P);  //添加到集合
		}
        
       
     
       /* propertyResult.setFileType(file[0].getContentType());// 获取文件类型
*/        //model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);
         try {
//        	 contractService.initializeProperty(propertyResult,propertyResults); //添加
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
       
      
      
    } 

}
