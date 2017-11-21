package com.flf.servlet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * @see <code>文件上传工具类</code>
 * @author 尹磊
 * @date 2015-07-15 下午 4:20
 */
public class ExcelFileService extends HttpServlet{

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
        String backPath = configPath;
          
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
                List<List<Object>> data=readXls(item);
                out.print("aaaa");
                /*String fileName = item.getName();  
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
                }          */
            }   
              
        } catch (FileUploadException e) {  
            e.printStackTrace();  
        }  
        out.flush();  
        out.close(); 
		
	}
	private List<List<Object>> readXls(FileItem file) throws IOException {
        InputStream is =file.getInputStream();//excel模板
        Workbook wbs=null;
        List<List<Object>> list=new ArrayList<List<Object>>();//excel中所有工作表的数据
        try {
        	wbs = WorkbookFactory.create(is);//兼容excel2007
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        // 循环工作表Sheet
        for (int numSheet = 0; numSheet < wbs .getNumberOfSheets(); numSheet++) {
        	Sheet sheet = wbs.getSheetAt(numSheet);
        	//判断工作表为空
            if (sheet == null) {
                continue;
            }
            // 循环行Row从的二行开始
            for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {
                Row row = sheet.getRow(rowNum);
                if(row!=null)
                {
	                List<Object> objs=new ArrayList<Object>();
	                for (int cellNum = 0; cellNum <row.getLastCellNum(); cellNum++) {
	                	Cell cell=row.getCell(cellNum);
	                	if(cell!=null){
		                	switch (cell.getCellType()) {  
		                    case Cell.CELL_TYPE_NUMERIC: // 数字  
		                    	cell.setCellType(Cell.CELL_TYPE_STRING);//设置cell类型为String
		                    	objs.add(cell.getStringCellValue());
		                        break;  
		                    case Cell.CELL_TYPE_STRING: // 字符串  
		                    	objs.add(cell.getStringCellValue());
		                        break;  
		                    case Cell.CELL_TYPE_BOOLEAN: // Boolean  
		                    	objs.add(cell.getBooleanCellValue());
		                        break;  
		                    case Cell.CELL_TYPE_FORMULA: // 公式  
		                    	objs.add(cell.getCellFormula());
		                        break;  
		                    case Cell.CELL_TYPE_BLANK: // 空值  
		                    	objs.add(null);
		                        break;  
		                    case Cell.CELL_TYPE_ERROR: // 故障  
		                    	objs.add("错误信息！");  
		                        break;  
		                    default:  
		                    	objs.add(cell);
		                        break;  
		                    }  
	                	}else
	                	{
	                		objs.add(null);
	                	}
					}
	                list.add(objs);
                }
            }
        }
        return list;
    }

}