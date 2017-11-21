/**
 * @Title: PersonBuildingNewController.java
 * @Package com.flf.controller
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-12 上午11:15:07
 * @version V1.0
 */

package com.flf.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.flf.entity.PersonBuildingNew;

import com.flf.service.PersonBuildingNewService;

/**
 * @ClassName: PersonBuildingNewController
 * @Description: TODO
 * @author wangyong
 * @date 2015-6-12 上午11:15:07
 *
 */
@Controller
@RequestMapping(value="/PersonBuildingNew")
public class PersonBuildingNewController {
	/*
	@Autowired
	private PersonBuildingNewService personBuildingNewService;
	
	@RequestMapping(value={"/PersonNewupload"},method=RequestMethod.POST)
    public String upload(@RequestParam("file") MultipartFile file,PersonBuildingNew personBuildingNew ,HttpServletRequest request, ModelMap model) {  
  
        System.out.println("开始");  
        String path = request.getSession().getServletContext().getRealPath("upload");  
        String fileName = file.getOriginalFilename();  
//        String fileName = new Date().getTime()+".jpg";  
        System.out.println(path);  
        File targetFile = new File(path, fileName);  
        if(!targetFile.exists()){  
            targetFile.mkdirs();  
        }  
  
        //保存  
        try {  
            file.transferTo(targetFile);  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
        //model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
        personBuildingNew.setAccessory("/upload/"+fileName);  //上传文件相对路径
        personBuildingNewService.addPersonBuildingNewRestful(personBuildingNew);
        return null;  
    } 
*/
}
