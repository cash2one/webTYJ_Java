/**
 * 
 */
package com.flf.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


/**
 * @author Administrator
 * 获取excel中所有工作表的数据
 */
public class ReadExcel {

    public List<List<Object>> readXls(String url) throws IOException, InvalidFormatException {
    	InputStream is = new FileInputStream(url);//excel模板
        Workbook wbs=null;
        List<List<Object>> list=new ArrayList<List<Object>>();//excel中所有工作表的数据
        try {
        	wbs = WorkbookFactory.create(is);//兼容excel2007
		} catch (EncryptedDocumentException e) {
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