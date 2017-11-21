/**
 * @Title: AngularUploadController.java
 * @Package com.flf.controller
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-14 下午3:37:23
 * @version V1.0
 */

package com.flf.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import org.apache.poi.hssf.usermodel.*;  
import org.apache.poi.ss.usermodel.DataFormatter;  
import org.apache.poi.ss.usermodel.DateUtil;  
import org.apache.poi.xssf.usermodel.XSSFCell;  
import org.apache.poi.xssf.usermodel.XSSFRow;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook; 

import java.io.*;  
import java.text.DecimalFormat;  
import java.text.SimpleDateFormat;  
import java.util.ArrayList;  
import java.util.HashMap;  
import java.util.List;  
import java.util.Map;  


/**
 * @ClassName: AngularUploadController
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-14 下午3:37:23
 *
 */
@Controller
@RequestMapping(value="/AngularUpload")
public  class AngularUploadController {
	
	
	@RequestMapping(value={"/upload"},method=RequestMethod.POST)
	    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request, ModelMap model) {  
	  
	        System.out.println("开始");  
	        String path = request.getSession().getServletContext().getRealPath("upload");  
	        String fileName = file.getOriginalFilename();  
//	        String fileName = new Date().getTime()+".jpg";  
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
	        model.addAttribute("fileUrl", request.getContextPath()+"/upload/"+fileName);  
	  
	        return "rediredt:index";  
	    } 
	
	
	
	 @SuppressWarnings("rawtypes")  
	 @RequestMapping(value={"/Excelupload"},method=RequestMethod.POST)
	    public static List<Map> readExcel(@RequestParam("file")MultipartFile file) throws Exception{  
	        //准备返回值列表  
		 	String fileName=file.getOriginalFilename();
	        List<Map> valueList=new ArrayList<Map>();  
//	      String tempSavePath="tmp";//缓存文件目录的文件夹名称（struts用）  
	        String filepathtemp="/mnt/b2b/tmp";//缓存文件目录  
	        String tmpFileName= System.currentTimeMillis()+"."+getExtensionName(fileName);  
	        String ExtensionName=getExtensionName(fileName);  
//	      String filepathtemp= ServletActionContext.getServletContext().getRealPath(tempSavePath);//strut获取项目路径  
	        File filelist = new File(filepathtemp);  
	        if  (!filelist .exists()  && !filelist .isDirectory())        
	        {         
	            filelist .mkdir();      
	        }   
	        String filePath = filepathtemp+"/"+tmpFileName;  
	        File tmpfile = new File(filePath);  
	        //拷贝文件到服务器缓存目录（在项目下）  
//	        copy(file,tmpfile);//stuts用的方法  
	        copy(file, filepathtemp,tmpFileName);//spring mvc用的方法  
	  
	        //System.out.println("后缀名："+ExtensionName);  
	          
	        if(ExtensionName.equalsIgnoreCase("xls")){  
	            valueList=readExcel2003(filePath);  
	        }else if(ExtensionName.equalsIgnoreCase("xlsx")) {  
	            valueList=readExcel2007(filePath);  
	        }  
	        //删除缓存文件  
	        tmpfile.delete();  
	        
	        
	        for (Map map : valueList) {
				System.out.println(map);
			}
	        return valueList;  
	                  
	    }
	 
	 
     
    /** 
     * 读取97-2003格式 
     * @param filePath 文件路径 
     * @throws java.io.IOException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List<Map> readExcel2003(String filePath) throws IOException{  
        //返回结果集  
        List<Map> valueList=new ArrayList<Map>();  
        FileInputStream fis=null;  
        try {  
            fis=new FileInputStream(filePath);  
            HSSFWorkbook wookbook = new HSSFWorkbook(fis);  // 创建对Excel工作簿文件的引用  
            HSSFSheet sheet = wookbook.getSheetAt(0);   // 在Excel文档中，第一张工作表的缺省索引是0  
            int rows = sheet.getPhysicalNumberOfRows(); // 获取到Excel文件中的所有行数­  
            Map<Integer,String> keys=new HashMap<Integer, String>();  
            int cells=0;  
            // 遍历行­（第1行  表头） 准备Map里的key  
            HSSFRow firstRow = sheet.getRow(0);  
            if (firstRow != null) {  
                // 获取到Excel文件中的所有的列  
                cells = firstRow.getPhysicalNumberOfCells();  
                // 遍历列  
                for (int j = 0; j < cells; j++) {  
                    // 获取到列的值­  
                    try {  
                        HSSFCell cell = firstRow.getCell((short) j);  
                        String cellValue = getCellValue(cell);  
                        keys.put(j,cellValue);                        
                    } catch (Exception e) {  
                        e.printStackTrace();      
                    }  
                }  
            }  
            // 遍历行­（从第二行开始）  
            for (int i = 1; i < rows; i++) {  
                // 读取左上端单元格(从第二行开始)  
                HSSFRow row = sheet.getRow(i);  
                // 行不为空  
                if (row != null) {  
                    //准备当前行 所储存值的map  
                    Map<String, Object> val=new HashMap<String, Object>();  
                      
                    boolean isValidRow = false;  
                      
                    // 遍历列  
                    for (int j = 0; j < cells; j++) {  
                        // 获取到列的值­  
                        try {  
                            HSSFCell cell = row.getCell((short) j);  
                            String cellValue = getCellValue(cell);  
                            val.put(keys.get(j),cellValue);   
                            if(!isValidRow && cellValue!=null && cellValue.trim().length()>0){  
                                isValidRow = true;  
                            }  
                        } catch (Exception e) {  
                            e.printStackTrace();          
                        }  
                    }  
                    //第I行所有的列数据读取完毕，放入valuelist  
                    if(isValidRow){  
                        valueList.add(val);  
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally {  
            fis.close();  
        }  
        return valueList;  
    }  
    /** 
     * 读取2007-2013格式 
     * @param filePath 文件路径 
     * @return 
     * @throws java.io.IOException 
     */  
    @SuppressWarnings("rawtypes")  
    public static List<Map> readExcel2007(String filePath) throws IOException{  
        List<Map> valueList=new ArrayList<Map>();  
        FileInputStream fis =null;  
        try {  
            fis =new FileInputStream(filePath); 
            XSSFWorkbook xwb = new XSSFWorkbook(fis);   // 构造 XSSFWorkbook 对象，strPath 传入文件路径  
            XSSFSheet sheet = xwb.getSheetAt(0);            // 读取第一章表格内容  
            // 定义 row、cell  
            XSSFRow row;  
            // 循环输出表格中的第一行内容   表头  
            Map<Integer, String> keys=new HashMap<Integer, String>();  
            row = sheet.getRow(0);  
            if(row !=null){  
                //System.out.println("j = row.getFirstCellNum()::"+row.getFirstCellNum());  
                //System.out.println("row.getPhysicalNumberOfCells()::"+row.getPhysicalNumberOfCells());  
                for (int j = row.getFirstCellNum(); j <=row.getPhysicalNumberOfCells(); j++) {  
                    // 通过 row.getCell(j).toString() 获取单元格内容，  
                    if(row.getCell(j)!=null){  
                        if(!row.getCell(j).toString().isEmpty()){  
                            keys.put(j, row.getCell(j).toString());  
                        }  
                    }else{  
                        keys.put(j, "K-R1C"+j+"E");  
                    }  
                }  
            }  
            // 循环输出表格中的从第二行开始内容  
            for (int i = sheet.getFirstRowNum() + 1; i <= sheet.getPhysicalNumberOfRows(); i++) {  
                row = sheet.getRow(i);  
                if (row != null) {  
                    boolean isValidRow = false;  
                    Map<String, Object> val = new HashMap<String, Object>();  
                    for (int j = row.getFirstCellNum(); j <= row.getPhysicalNumberOfCells(); j++) {  
                        XSSFCell cell = row.getCell(j);  
                        if (cell != null) {  
                            String cellValue = null;  
                            if(cell.getCellType()==XSSFCell.CELL_TYPE_NUMERIC){  
                                if(DateUtil.isCellDateFormatted(cell)){  
                                    cellValue = new DataFormatter().formatRawCellContents(cell.getNumericCellValue(), 0, "yyyy-MM-dd HH:mm:ss");  
                                }  
                                else{  
                                    cellValue = String.valueOf(cell.getNumericCellValue());  
                                }  
                            }  
                            else{  
                                cellValue = cell.toString();  
                            }  
                            if(cellValue!=null&&cellValue.trim().length()<=0){  
                                cellValue=null;  
                            }  
                            val.put(keys.get(j), cellValue);  
                            if(!isValidRow && cellValue!= null && cellValue.trim().length()>0){  
                                isValidRow = true;  
                            }  
                        }  
                    }  
  
                    // 第I行所有的列数据读取完毕，放入valuelist  
                    if (isValidRow) {  
                        valueList.add(val);  
                    }  
                }  
            }  
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally {  
            fis.close();  
        }  
  
        return valueList;  
    }
    
    
    /** 
     * 文件操作 获取文件扩展名 
     *  
     * @Author: sunny 
     * @param filename 
     *            文件名称包含扩展名 
     * @return 
     */  
    public static String getExtensionName(String filename) {  
        if ((filename != null) && (filename.length() > 0)) {  
            int dot = filename.lastIndexOf('.');  
            if ((dot > -1) && (dot < (filename.length() - 1))) {  
                return filename.substring(dot + 1);  
            }  
        }  
        return filename;  
    }  
    
    
    
    /** 
     * 上传copy文件方法(for MultipartFile) 
     * @param savePath 在linux上要保存完整路径 
     * @param newname 新的文件名称， 采用系统时间做文件名防止中文报错的问题 
     * @throws Exception 
     */  
    public static void copy(MultipartFile file,String savePath,String newname) throws Exception {  
        try {  
            File targetFile = new File(savePath,newname);  
            if (!targetFile.exists()) {  
                //判断文件夹是否存在，不存在就创建  
                targetFile.mkdirs();  
            }  
  
            file.transferTo(targetFile);  
           
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
    }  
      
    private static String getCellValue(HSSFCell cell) {  
        DecimalFormat df = new DecimalFormat("#");  
        String cellValue=null;  
        if (cell == null)  
            return null;  
        switch (cell.getCellType()) {  
            case HSSFCell.CELL_TYPE_NUMERIC:  
                if(HSSFDateUtil.isCellDateFormatted(cell)){  
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");  
                    cellValue=sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));  
                    break;  
                }  
                cellValue=df.format(cell.getNumericCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_STRING:           
                cellValue=String.valueOf(cell.getStringCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_FORMULA:  
                cellValue=String.valueOf(cell.getCellFormula());  
                break;  
            case HSSFCell.CELL_TYPE_BLANK:  
                cellValue=null;  
                break;  
            case HSSFCell.CELL_TYPE_BOOLEAN:  
                cellValue=String.valueOf(cell.getBooleanCellValue());  
                break;  
            case HSSFCell.CELL_TYPE_ERROR:  
                cellValue=String.valueOf(cell.getErrorCellValue());  
                break;  
        }  
        if(cellValue!=null&&cellValue.trim().length()<=0){  
            cellValue=null;  
        }  
        return cellValue;  
    } 

}
