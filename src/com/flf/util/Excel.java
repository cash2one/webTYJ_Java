package com.flf.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;

import com.flf.request.ExcelInfo;
import com.flf.request.Reflections;

public class Excel {

	public  InputStream createExcelInputStream(List<ExcelInfo> l)throws IOException{
		HSSFWorkbook workbook = new HSSFWorkbook(); //产生工作簿对象
		for(int i=0;i<l.size();i++){
			HSSFSheet sheet = workbook.createSheet(); //产生工作表对象
			sheet.setDefaultColumnWidth((short)20);
			workbook.setSheetName(i,l.get(i).getSheetName());//创建一个工作簿
			HSSFRow row = sheet.createRow(0);
			HSSFCell cell;
		     
		    HSSFCellStyle cellStyle2 = workbook.createCellStyle();  //用于将一个单元格变为文本格式
            HSSFDataFormat format = workbook.createDataFormat();  
            cellStyle2.setDataFormat(format.getFormat("@"));  
			for(int j=0;j<l.get(i).getTitles().length;j++){
				    cell = row.createCell((short) j);	         
		            //if(l.get(i).getTitles()[j].equals("证件号码")){
		                cell.setCellStyle(cellStyle2); 
		                cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
		                
		           // }	        
				    cell.setCellValue(l.get(i).getTitles()[j]);
			} 
			if(l.get(i).getList()!=null && l.get(i).getList().size()>0){
				if(l.get(i).getList().get(0) instanceof HashMap){
					List<HashMap> mapList = l.get(i).getList();
					for(int m=0;m<mapList.size();m++){
						row = sheet.createRow(m+1);
						for (int j=0;j<l.get(i).getFields().length;j++) {
							cell = row.createCell((short) j);
							//if(mapList.get(m).get(l.get(i).getFields()[j])=="cardNum"||mapList.get(m).get(l.get(i).getFields()[j]).equals("cardNum")){			
				            cell.setCellStyle(cellStyle2); 
				            cell.setCellType(HSSFCell.CELL_TYPE_STRING);  
							//}
							cell.setCellValue(String.valueOf(mapList.get(m).get(l.get(i).getFields()[j])));
						}
					}
				}else{
					List list = l.get(i).getList();
					for(int m=0;m<list.size();m++){
						row = sheet.createRow(m+1);
						for (int j=0;j<l.get(i).getFields().length;j++) {
						
							cell = row.createCell((short) j);					
							//if(l.get(i).getFields()[j]=="cardNum"||l.get(i).getFields()[j].equals("cardNum")){
						            cell.setCellStyle(cellStyle2);  					          
						            cell.setCellType(HSSFCell.CELL_TYPE_STRING);  						
							//}
							Object temp = Reflections.invokeGetter(list.get(m),l.get(i).getFields()[j]);
							if(temp!=null){
									if(Reflections.invokeGetter(list.get(m),l.get(i).getFields()[j])instanceof Integer){
									cell.setCellValue(Reflections.invokeGetter(list.get(m),l.get(i).getFields()[j]).hashCode());
							}else{
								cell.setCellValue(Reflections.invokeGetter(list.get(m),l.get(i).getFields()[j]).toString());
							}
						}else{
							cell.setCellValue("");
						  }
						}
					}
				}
			}
		}
		ByteArrayOutputStream os = new ByteArrayOutputStream();
		workbook.write(os);
		InputStream is = new ByteArrayInputStream(os.toByteArray());
		os.close();
		return is;
	}
}
