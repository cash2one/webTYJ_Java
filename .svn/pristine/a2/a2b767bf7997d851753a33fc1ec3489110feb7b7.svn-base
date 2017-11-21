package com.flf.service.impl;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;







import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.Annex;
import com.flf.entity.Bill;
import com.flf.entity.FinancialGroupDetail;
import com.flf.entity.FinancialGroupTotal;
import com.flf.entity.PageRestful;
import com.flf.mapper.BillMapper;
import com.flf.mapper.FinancialGroupDetailMapper;
import com.flf.mapper.FinancialGroupTotalMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.FinancialGroupDetailService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

public class FinancialGroupDetailServiceImpl implements FinancialGroupDetailService{
	
	@Autowired
	private FinancialGroupTotalMapper financialGroupTotalMapper;
	@Autowired
	private BillMapper billMapper;
	
	private FinancialGroupDetailMapper financialGroupDetailMapper;
	
	public FinancialGroupDetailMapper getFinancialGroupDetailMapper() {
		return financialGroupDetailMapper;
	}

	public void setFinancialGroupDetailMapper(
			FinancialGroupDetailMapper financialGroupDetailMapper) {
		this.financialGroupDetailMapper = financialGroupDetailMapper;
	}

	@Override
	public List<FinancialGroupDetail> getDatasByIdRes(String id) {
		// TODO Auto-generated method stub
		return financialGroupDetailMapper.getDatas(id);
	}
	@Override
	public PageRestful listPageFinancialGroupDetail(FinancialGroupDetail financialGroupDetail) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<FinancialGroupDetail>financialGroupDetails =financialGroupDetailMapper.listPageFinancialGroupDetail(financialGroupDetail);
		financialGroupDetails.add(0,null);
		pageRestful.setFinancialGroupDetails(financialGroupDetails);
		pageRestful.setPage(financialGroupDetail.getPage());
		return pageRestful;
	}

	@Override
	public List<FinancialGroupDetail> returnImportFileDatas(Annex annex) {
		// TODO Auto-generated method stub
		List<FinancialGroupDetail> financialGroupDetails = new ArrayList<FinancialGroupDetail>();
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String filePath = annex.getAnnexAddress();
		String financialGroupTotalId = annex.getRelationId();
		if(Tools.notEmpty(filePath)){
			try {
 				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if(dataList!=null && dataList.size()>0){
					for (Map<Short, String> t : dataList) {
						FinancialGroupDetail financialGroupDetail = new FinancialGroupDetail();
						String uuid = UUID.randomUUID().toString();
						financialGroupDetail.setFinancialGroupTotalId(financialGroupTotalId);//回盘总结文件记录id
						financialGroupDetail.setFinancialGroupDetailId(uuid);//回盘明细文件记录id
						//合同号	收付代码	交易文件号	总户数	总金额	已划款户数	已划款金额	送银行时间	应划款日期	划款日期
						//** 合同号 行别  开户行号 托收管理id 账单id 扣款标记 托收状态 生成日期 托收类型 项目id
						financialGroupDetail.setContractNumber(t.get((short)0));//合同号
						financialGroupDetail.setBankType(t.get((short)1));//行别
						financialGroupDetail.setBankNum(t.get((short)2));//开户行号 
						financialGroupDetail.setBankAccount(t.get((short)3));//银行账户
						financialGroupDetail.setSum(Double.parseDouble(t.get((short)4)));//金额
						financialGroupDetail.setDeductionsTag(t.get((short)5));//扣款标记
						financialGroupDetail.setCustName(t.get((short)6));//户主
						financialGroupDetail.setMessage(t.get((short)7));//生成日期
						/*if("托收".equals(t.get((short)8))){
							financialGroupDetail.setCollectionType(0);
						}else{
							financialGroupDetail.setCollectionType(1);
						}*/
						financialGroupDetails.add(financialGroupDetail);//加入到list集合
					}
				}
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return financialGroupDetails;
	}

	@Override
	public Info importDataFromExcelFile(
			FinancialGroupDetail financialGroupDetail) {
		// TODO Auto-generated method stub
		List<FinancialGroupDetail> financialGroupDetails = financialGroupDetail.getFinancialGroupDetails();
		if(financialGroupDetails!=null){
			for (FinancialGroupDetail f : financialGroupDetails) {
				financialGroupDetailMapper.insertFinancialGroupDetailById(f);
			}
			return Tools.msg("数据导入成功!",true);
		}
		return Tools.msg("数据导入失败!",true);
	}

	@Override
	public void exportToExcel(FinancialGroupDetail financialGroupDetail) {
//		// TODO Auto-generated method stub
//		String fileDate = new SimpleDateFormat("yyyyMMdd").format(new Date()).toString();//获取时间
//		// 第一步，创建一个webbook，对应一个Excel文件  
//        HSSFWorkbook wb = new HSSFWorkbook();  
//        // 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet  
//        HSSFSheet sheet = wb.createSheet("托收总文件");  
//        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制short  
//        HSSFRow row = sheet.createRow((int) 0);  
//        // 第四步，创建单元格，并设置值表头 设置表头居中  
//        HSSFCellStyle style = wb.createCellStyle();  
//        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建一个居中格式  
//        //合同号, 行别,开户行号,账户,金额,扣款标记,户主,留言
//        HSSFCell cell = row.createCell((short) 0); 
//        cell.setCellValue("合同号");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 1);
//        cell.setCellValue("行别");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 2);
//        cell.setCellValue("开户行号");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 3);
//        cell.setCellValue("账户");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 4);
//        cell.setCellValue("金额");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 5);
//        cell.setCellValue("扣款标记");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 6);
//        cell.setCellValue("户主");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 7);
//        cell.setCellValue("留言");  
//        cell.setCellStyle(style);
//        
//        List<FinancialGroupDetail> financialGroupDetails = financialGroupDetail.getFinancialGroupDetails();
//        if(financialGroupDetails!=null && financialGroupDetails.size()>0){
//        	for (int i = 0; i < financialGroupDetails.size(); i++)  
//            {  
//                row = sheet.createRow((int) i + 1);
//                FinancialGroupDetail f = financialGroupDetails.get(i);
//                row.createCell((short) 0).setCellValue(f.getContractNumber());
//                row.createCell((short) 1).setCellValue(f.getBankType());
//                row.createCell((short) 2).setCellValue(f.getBankNum());
//                row.createCell((short) 3).setCellValue(f.getBankAccount());
//                row.createCell((short) 4).setCellValue(f.getSum());
//                row.createCell((short) 5).setCellValue(f.getDeductionsTag());
//                row.createCell((short) 6).setCellValue(f.getCustName());
//                row.createCell((short) 7).setCellValue(f.getMessage());
//            }
//            // 第六步，将文件存到指定位置  
//            try  
//            {  
//            	FileSystemView fsv = FileSystemView.getFileSystemView();
//        		File file = fsv.getHomeDirectory();
//        		String filePath = file.toString().replace('\\', '/')+"/";
//                FileOutputStream fout = new FileOutputStream(filePath+"明细文件"+fileDate+".xls");  
//                wb.write(fout);  
//                fout.close();  
//            }  
//            catch (Exception e)  
//            {  
//                e.printStackTrace();  
//            } 
//        }
	}

	@Override
	public InputStream exportFDetailFile(String financialGroupTotalId) {
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
	    String[] headers = { "合同号", "行别", "开户行号", "账户", "金额","扣款标记","户主","留言"};
		String[] fields = {"contractNumber","bankType","bankNum","bankAccount","sum","deductionsTag","custName","message"};
        List<FinancialGroupDetail> dataset = financialGroupDetailMapper.getDetail(financialGroupTotalId);
      
        if(dataset.size() > 0){        	
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("银联托收明细文件");
			exl.setList(dataset);
			list.add(exl);
        }
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public InputStream exportMFUDetailFile() {
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
	  //合同号	收付代码	交易文件号	总户数	总金额	已划款户数	已划款金额	送银行时间	应划款日期	划款日期
		//** 合同号 行别  开户行号 托收管理id 账单id 扣款标记 托收状态 生成日期 托收类型 项目id
	    String[] headers = { "合同号", "行别", "开户行号 ","账户 ","金额","扣款标记 ","户主","留言"};
		String[] fields = {"contractNumber","bankType","bankNum","bankAccount","sum","deductionsTag","custName","message"};
        List<FinancialGroupDetail> dataset = new ArrayList<FinancialGroupDetail>();    	
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("银联托收明细文件模版");
			exl.setList(dataset);
			list.add(exl);
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 导出历史金融联托收明细文件
	 */
	@Override
	public InputStream exportFDetailFileTxt(String financialGroupTotalId) {
		List<FinancialGroupDetail> fgdList = financialGroupDetailMapper.getDetail(financialGroupTotalId);
		StringBuffer buff = new StringBuffer();
		for(FinancialGroupDetail fgd:fgdList){
			buff.append(fgd.getContractNumber());//合同号
			buff.append(fgd.getBankType());//行别
			buff.append(fgd.getBankNum());//开户行行号
			String bankAccount = StringUtils.rightPad(fgd.getBankAccount(), 32, " ");
			buff.append(bankAccount);//账号
			String sum = StringUtils.leftPad(String.valueOf(fgd.getSum()), 12, "0");
			buff.append(sum);
			buff.append(fgd.getDeductionsTag());
			String custName = StringUtils.rightPad(fgd.getCustName(), 60, " ");
			buff.append(custName);
			String mstr = fgd.getMessage();
			if(mstr == null){
				mstr = " ";
			}
			String message = StringUtils.rightPad(mstr, 60, " ");
			buff.append(message);
			buff.append("\r\n");
			fgd.setCollectionState(1);
			financialGroupDetailMapper.updateFinancialGroupDetail(fgd);
			Bill newBill = new Bill();
			newBill.setBuildingId(fgd.getBuildingId());
			newBill.setChargeTypeId(fgd.getChargeTypeId());
			newBill.setBillState(2);
			List<Bill> billList = billMapper.listAllBill(newBill);
			for(Bill bill:billList){
				bill.setBillState(0);//0-托收中
				billMapper.updateBill(bill);
			}
		}
		String str = buff.toString();
		InputStream ins = null;
		try {
			ins = new ByteArrayInputStream(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ins;
	}
	@Override
	public InputStream exportDetailFileTxt(String financialGroupTotalId) throws Exception {
		List<FinancialGroupDetail> fgdList = financialGroupDetailMapper.getDetail(financialGroupTotalId);
		StringBuffer buff = new StringBuffer();
		for(FinancialGroupDetail fgd:fgdList){
			buff.append(fgd.getContractNumber());//合同号
			buff.append(fgd.getBankType());//行别
			buff.append(fgd.getBankNum());//开户行行号
			String bankAccount = StringUtils.rightPad(fgd.getBankAccount(), 32, " ");
			buff.append(bankAccount);//账号
			String sum = StringUtils.leftPad(String.valueOf(fgd.getSum()), 12, "0");
			buff.append(sum);
			buff.append(fgd.getDeductionsTag());
			String custName = StringUtils.rightPad(fgd.getCustName(), 60, " ");
			buff.append(custName);
			String mstr = fgd.getMessage();
			if(mstr == null){
				mstr = " ";
			}
			String message = StringUtils.rightPad(mstr, 60, " ");
			buff.append(message);
			buff.append("\r\n");
			fgd.setCollectionState(1);
			financialGroupDetailMapper.updateFinancialGroupDetail(fgd);
			
			Bill newBill = new Bill();
			newBill.setBuildingId(fgd.getBuildingId());
			newBill.setChargeTypeId(fgd.getChargeTypeId());
			newBill.setBillState(2);
			List<Bill> billList = billMapper.listAllBill(newBill);
			for(Bill bill:billList){
				bill.setBillState(0);//0-托收中
				billMapper.updateBill(bill);
			}
		}
		List<FinancialGroupTotal> fcgtList = financialGroupTotalMapper.getDatasById(financialGroupTotalId);
		if(fcgtList.size()>0){
			FinancialGroupTotal fgt = fcgtList.get(0);
			if(fgt.getCollectionTotalName() == null){
				SimpleDateFormat sdformat = new SimpleDateFormat("MM");
				SimpleDateFormat b_sdf = new SimpleDateFormat("yyyyMM");
				String fileNameHeader = "H5100"+sdformat.format(new Date());
				//根据交易文件名头模糊查询已回盘的所有托收总结记录
				List<FinancialGroupTotal> fgtList =  financialGroupTotalMapper.listAllFGTLikeFileNameHeader(fileNameHeader,fgt.getProjectId());
				int size = fgtList.size();
				if(size > 9){
					throw new Exception("当月托收次数超过10次！");
				}
				String fileName = fileNameHeader+String.valueOf(size);
				String batchNumber = "H51"+b_sdf.format(new Date())+String.valueOf(size);
				fgt.setCollectionTotalName(fileName);
				fgt.setCollectionState(1);//1-托收中
				fgt.setBatchNumber(batchNumber);
				financialGroupTotalMapper.updateFinancialGroupTotal(fgt);
			}
		}
		String str = buff.toString();
		InputStream ins = null;
		try {
			ins = new ByteArrayInputStream(str.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ins;
	}
}
