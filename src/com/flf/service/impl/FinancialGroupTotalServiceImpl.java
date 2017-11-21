package com.flf.service.impl;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.AdvancePaymentsDetails;
import com.flf.entity.Annex;
import com.flf.entity.AssetAccount;
import com.flf.entity.Bill;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.CollectionManage;
import com.flf.entity.FinancialBankNum;
import com.flf.entity.FinancialCounterofferDetail;
import com.flf.entity.FinancialCounterofferTotal;
import com.flf.entity.FinancialGroupDetail;
import com.flf.entity.FinancialGroupTotal;
import com.flf.entity.PageRestful;
import com.flf.entity.Project;
import com.flf.entity.TempDemo;
import com.flf.mapper.AdvancePaymentsDetailsMapper;
import com.flf.mapper.AssetAccountMapper;
import com.flf.mapper.BillMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.CollectionManageMapper;
import com.flf.mapper.FinancialBankNumMapper;
import com.flf.mapper.FinancialCounterofferDetailMapper;
import com.flf.mapper.FinancialCounterofferTotalMapper;
import com.flf.mapper.FinancialGroupDetailMapper;
import com.flf.mapper.FinancialGroupTotalMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.FinancialGroupTotalService;
import com.flf.service.UserServiceNew;
import com.flf.util.ArithUtils;
import com.flf.util.DateUtil;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

public class FinancialGroupTotalServiceImpl implements FinancialGroupTotalService{
	@Autowired
	private UserServiceNew userServiceNew;
	@Autowired
	private ProjectMapper projectMapper;//项目
	@Autowired
	private BillMapper billMapper;//账单
	@Autowired
	private FinancialGroupDetailMapper financialGroupDetailMapper;//金融联托收明细
	@Autowired
	private FinancialGroupTotalMapper financialGroupTotalMapper;//金融联托收总结
	@Autowired
	private CollectionManageMapper collectionManageMapper;//托收管理
	@Autowired
	private HouseNewMapper houseNewMapper;//住宅
	@Autowired
	private FinancialCounterofferTotalMapper financialCounterofferTotalMapper;//回盘总结文件
	@Autowired
	private FinancialCounterofferDetailMapper financialCounterofferDetailMapper;//回盘明细文件
	@Autowired
	private BuildingStructureNewMapper buildingStructureNewMapper;//建筑结构
	@Autowired
	private FinancialBankNumMapper financialBankNumMapper;//行别
	@Autowired
	private AdvancePaymentsDetailsMapper advancePaymentsDetailsMapper;
	@Autowired
	private AssetAccountMapper assetAccountMapper;
	
	public ProjectMapper getProjectMapper() {
		return projectMapper;
	}

	public void setProjectMapper(ProjectMapper projectMapper) {
		this.projectMapper = projectMapper;
	}

	public FinancialGroupTotalMapper getFinancialGroupTotalMapper() {
		return financialGroupTotalMapper;
	}

	public void setFinancialGroupTotalMapper(
			FinancialGroupTotalMapper financialGroupTotalMapper) {
		this.financialGroupTotalMapper = financialGroupTotalMapper;
	}

	/**
	 * 通过Id查询
	 * @param orderId
	 * @return
	 */
	@Override
	public List<FinancialGroupTotal> getDatasByIdRes(String id) {
		// TODO Auto-generated method stub
		return financialGroupTotalMapper.getDatasById(id);
	}


	/* (non-Javadoc)
	 * @see com.flf.service.FinancialGroupTotalService#listPageFinancialRes(com.flf.entity.FinancialGroupTotal)
	 */
	@Override
	public PageRestful listPageFinancialRes(
			FinancialGroupTotal financialGroupTotal) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<FinancialGroupTotal> financialGroupTotals=financialGroupTotalMapper.listPageFinancial(financialGroupTotal);
		financialGroupTotals.add(0,null);
		pageRestful.setFinancialGroupTotals(financialGroupTotals);
		pageRestful.setPage(financialGroupTotal.getPage());
		return pageRestful;
	}

	@Override
	public List<FinancialGroupTotal> returnImportFileDatas(Annex annex) {
		// TODO Auto-generated method stub
		List<FinancialGroupTotal> financialGroupTotals = new ArrayList<FinancialGroupTotal>();//存放导入的数据
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String filePath = annex.getAnnexAddress();
		if(Tools.notEmpty(filePath)){
			try {
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				/*List<Project> projects = projectMapper.listAllProject();//获取所有项目id与项目名称
				Map<String, String> map = new HashMap<String, String>();//用于存放结果
				for (Project project : projects) {//将所有项目id与项目名称存入map集合
					map.put(project.getProjectName(), project.getProjectId());
				}*/
				
				if(dataList!=null && dataList.size()>0){
					for (Map<Short, String> t : dataList) {
						FinancialGroupTotal financialGroupTotal = new FinancialGroupTotal();
						String uuid = UUID.randomUUID().toString();
						financialGroupTotal.setFinancialGroupTotalId(uuid);//设置id
						//项目,代办银行,收付单位代码,币种	,收付标志,收付代码，交易文件,总户数,总金额,已划款户数,已划款金额,送银行日期,应划款日期,划款日期
						/*String projectName = t.get((short)0);//项目
						if(projectName!=null && map.get(projectName)!=null && map.get(projectName)!=""){
							financialGroupTotal.setProjectId(map.get(projectName));//将项目id存入对象
							financialGroupTotal.setProjectName(projectName);//将项目名存入
						}*/
						/*
						 * 去掉项目 cl 
						 */
						financialGroupTotal.setAgencyBankNum(t.get((short)0));//代办银行号
						financialGroupTotal.setPaymentUnitCode(t.get((short)1));//收付单位代码
						if("人民币".equals(t.get((short)2))){//币种
							financialGroupTotal.setCoinType(0);
						}else{
							financialGroupTotal.setCoinType(1);
						}
						if("已收".equals(t.get((short)3))){//收付标志
							financialGroupTotal.setPaymentState(0);
						}else{
							financialGroupTotal.setPaymentState(1);
						}
						financialGroupTotal.setCollectionTotalNum(t.get((short)4));//收付代码
						financialGroupTotal.setCollectionTotalName(t.get((short)5));//交易文件名
						financialGroupTotal.setHouseNumber((int)(Double.parseDouble(t.get((short)6))));//总户数
						financialGroupTotal.setSum(Double.parseDouble(t.get((short)7)));//总金额
						financialGroupTotal.setDeductionsHouseNumber((int)(Double.parseDouble(t.get((short)8))));//已划款户数
						financialGroupTotal.setDeductionsSum(Double.parseDouble(t.get((short)9)));//已划款金额
						financialGroupTotal.setTobankDate(sdf.parse(t.get((short)10)));//送银行日期
						financialGroupTotal.setPrepareDeductionsDate(sdf.parse(t.get((short)11)));//应划款日期
						financialGroupTotal.setDeductionsDate(sdf.parse(t.get((short)12)));//划款日期
						//financialGroupTotalMapper.insertFinancialGroupTotal(financialGroupTotal);
						financialGroupTotals.add(financialGroupTotal);//将数据存入集合
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return financialGroupTotals;
	}

	@Override
	public Info importDataFromExcelFile(FinancialGroupTotal financialGroupTotal) {
		// TODO Auto-generated method stub
		List<FinancialGroupTotal> financialGroupTotals = financialGroupTotal.getFinancialGroupTotals();
		if(financialGroupTotals!=null){
			for (FinancialGroupTotal f : financialGroupTotals) {
				financialGroupTotalMapper.insertFinancialGroupTotal(f);
			}
			return Tools.msg("数据导入成功!",true);
		}
		return Tools.msg("数据导入失败!",true);
	}

	@Override
	public Info exportToExcel(FinancialGroupTotal financialGroupTotal) {
		return null;
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
//        //项目,代办银行,收付单位代码,币种,收付标志,收付代码,交易文件,总户数,总金额,已划款户数,已划款金额,送银行日期,应划款日期,划款日期
//        HSSFCell cell = row.createCell((short) 0);  
//        cell.setCellValue("项目");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 1);  
//        cell.setCellValue("代办银行");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 2);  
//        cell.setCellValue("收付单位代码");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 3);  
//        cell.setCellValue("币种");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 4);
//        cell.setCellValue("收付标志");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 5);  
//        cell.setCellValue("收付代码");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 6);  
//        cell.setCellValue("交易文件");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 7);  
//        cell.setCellValue("总户数");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 8);
//        cell.setCellValue("总金额");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 9);  
//        cell.setCellValue("已划款户数");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 10);  
//        cell.setCellValue("已划款金额");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 11);  
//        cell.setCellValue("送银行日期");  
//        cell.setCellStyle(style);
//        cell = row.createCell((short) 12); 
//        cell.setCellValue("应划款日期");  
//        cell.setCellStyle(style);  
//        cell = row.createCell((short) 13);  
//        cell.setCellValue("划款日期");  
//        cell.setCellStyle(style);
//  
//        /* 查询项目与项目id的对应 */
//        Map<String, String> map = new HashMap<String, String>();
//        List<Project> projects = projectMapper.listAllProject();
//        if(projects!=null){
//        	for (Project project : projects) {
//        		if(project!=null){
//        			String projectId = project.getProjectId();
//        			String projectName = project.getProjectName();
//        			map.put(projectId, projectName);
//        		}
//    		}
//        }
//        
//        // 第五步，写入实体数据 实际应用中这些数据从数据库得到，  
//        List<FinancialGroupTotal> financialGroupTotals = financialGroupTotal.getFinancialGroupTotals();  
//        if(financialGroupTotals!=null && financialGroupTotals.size()>0){
//        	for (int i = 0; i < financialGroupTotals.size(); i++)  
//            {  
//                row = sheet.createRow((int) i + 1);
//                FinancialGroupTotal f = financialGroupTotals.get(i);
//                // 第四步，创建单元格，并设置值  
//              //项目,代办银行,收付单位代码,币种,收付标志,收付代码,交易文件,总户数,总金额,已划款户数,已划款金额,送银行日期,应划款日期,划款日期
//                row.createCell((short) 0).setCellValue(map.get(f.getProjectId()));  
//                row.createCell((short) 1).setCellValue(f.getAgencyBankNum());  
//                row.createCell((short) 2).setCellValue(f.getPaymentUnitCode());
//                row.createCell((short) 3).setCellValue(f.getCoinType()==0?"人民币":"港元");  
//                row.createCell((short) 4).setCellValue(f.getPaymentState()==0?"已收":"未收");  
//                row.createCell((short) 5).setCellValue(f.getCollectionTotalNum());
//                row.createCell((short) 6).setCellValue(f.getCollectionTotalName());  
//                row.createCell((short) 7).setCellValue(f.getHouseNumber());  
//                row.createCell((short) 8).setCellValue(f.getSum());
//                row.createCell((short) 9).setCellValue(f.getDeductionsHouseNumber());  
//                row.createCell((short) 10).setCellValue(f.getDeductionsSum());  
//                row.createCell((short) 11).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(f.getTobankDate()));
//                row.createCell((short) 12).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(f.getPrepareDeductionsDate()));
//                row.createCell((short) 13).setCellValue(new SimpleDateFormat("yyyy-MM-dd").format(f.getDeductionsDate())); 
//            }  
//            // 第六步，将文件存到指定位置  
//            try  
//            {  
//            	FileSystemView fsv = FileSystemView.getFileSystemView();
//        		File file = fsv.getHomeDirectory();
//        		String filePath = file.toString().replace('\\', '/')+"/";
//                FileOutputStream fout = new FileOutputStream(filePath+"总结文件"+fileDate+".xls");  
//                wb.write(fout);  
//                fout.close();  
//            }  
//            catch (Exception e)  
//            {  
//                e.printStackTrace();  
//            }
//            return Tools.msg("文件导入到桌面成功！", true);
//        }else{
//        	return Tools.msg("明细文件数据为空！", false);
//        }
	}
	
	@Override
	public InputStream exportFTotalFileTxt(String financialGroupTotalId) throws Exception {
		List<FinancialGroupTotal> dataset = financialGroupTotalMapper.getDatasById(financialGroupTotalId);
		
		StringBuffer buff = new StringBuffer();
		InputStream ins = null;
		if(dataset.size()>0){
			FinancialGroupTotal fct = dataset.get(0);
			buff.append(fct.getAgencyBankNum());//代办银行号
			buff.append(fct.getPaymentUnitCode());//收付单位代码
			buff.append(fct.getCoinType());//币种
			buff.append(fct.getPaymentState());//收付标志
			buff.append(fct.getCollectionTotalNum());//收付代码
			buff.append(fct.getCollectionTotalName());//交易文件名
			String HouseNumber = StringUtils.leftPad(String.valueOf(fct.getHouseNumber()), 8, "0");
			buff.append(HouseNumber);//总户数
			String sum = StringUtils.leftPad(String.valueOf(fct.getSum()), 14, "0");
			buff.append(sum);
			buff.append("        ");
			buff.append("              ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			buff.append(sdf.format(new Date()));//送银行日期
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, 1);
			buff.append(sdf.format(cal.getTime()));//应划款日期
			buff.append("        ");
			String str = buff.toString();
			try {
				ins = new ByteArrayInputStream(str.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ins;
	}

	@Override
	public InputStream exportTotalFileTxt(String financialGroupTotalId) throws Exception {
		List<FinancialGroupTotal> dataset = financialGroupTotalMapper.getDatasById(financialGroupTotalId);
		
		SimpleDateFormat sdformat = new SimpleDateFormat("MM");
		SimpleDateFormat b_sdf = new SimpleDateFormat("yyyyMM");
		String fileNameHeader = "H5100"+sdformat.format(new Date());
		
		StringBuffer buff = new StringBuffer();
		InputStream ins = null;
		if(dataset.size()>0){
			FinancialGroupTotal fct = dataset.get(0);
			
			//根据交易文件名头模糊查询已回盘的所有托收总结记录
			List<FinancialGroupTotal> fgtList =  financialGroupTotalMapper.listAllFGTLikeFileNameHeader(fileNameHeader+"%",fct.getProjectId());
			int size = fgtList.size();
			if(size > 9){
				throw new Exception("当月托收次数超过10次！");
			}
			String fileName = fileNameHeader+String.valueOf(size);
			String batchNumber = "H51"+b_sdf.format(new Date())+String.valueOf(size); 
			
			buff.append(fct.getAgencyBankNum());//代办银行号
			buff.append(fct.getPaymentUnitCode());//收付单位代码
			buff.append(fct.getCoinType());//币种
			buff.append(fct.getPaymentState());//收付标志
			buff.append(fct.getCollectionTotalNum());//收付代码
			buff.append(fileName);//交易文件名
			String HouseNumber = StringUtils.leftPad(String.valueOf(fct.getHouseNumber()), 8, "0");
			buff.append(HouseNumber);//总户数
			String sum = StringUtils.leftPad(String.valueOf(fct.getSum()), 14, "0");
			buff.append(sum);
			buff.append("        ");
			buff.append("              ");
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			buff.append(sdf.format(new Date()));//送银行日期
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DAY_OF_YEAR, 1);
			buff.append(sdf.format(cal.getTime()));//应划款日期
			buff.append("        ");
			String str = buff.toString();
			try {
				ins = new ByteArrayInputStream(str.getBytes("UTF-8"));
				fct.setCollectionTotalName(fileName);
				fct.setCollectionState(1);
				fct.setBatchNumber(batchNumber);
				financialGroupTotalMapper.updateFinancialGroupTotal(fct);
				FinancialGroupDetail financialGroupDetail = new FinancialGroupDetail();
				financialGroupDetail.setFinancialGroupTotalId(financialGroupTotalId);
				List<FinancialGroupDetail> fgdList = financialGroupDetailMapper.listAllFinancialGroupDetail(financialGroupDetail);
				for(FinancialGroupDetail fgd:fgdList){
					fgd.setBatchNumber(fileName);
					financialGroupDetailMapper.updateFinancialGroupDetail(fgd);
				}
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return ins;
	}
	@Override
	public InputStream exportFTotalFile(String financialGroupTotalId) {
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
	    String[] headers = { "项目", "代办银行", "收付单位代码", "币种", "收付标志","收付代码","交易文件","总户数","总金额","已划款户数","已划款金额","送银行日期","应划款日期","划款日期"};
		String[] fields = {"projectName","bankType","bankNum","coinType","paymentState","collectionTotalNum","collectionTotalName","houseNumber","sum","deductionsHouseNumber","deductionsSum","bankDateString","preDateString","deduDateString"};
        List<FinancialGroupTotal> dataset = financialGroupTotalMapper.getDatasById(financialGroupTotalId);
        ExcelInfo exl=new ExcelInfo();
        if(dataset.size() > 0){        	
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("银联托收文件头");
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
	public InputStream exportFTotalMBFile() {
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
	    String[] headers = {"代办银行", "收付单位代码", "币种", "收付标志","收付代码","交易文件","总户数","总金额","已划款户数","已划款金额","送银行日期","应划款日期","划款日期"};
		String[] fields = {"projectName","bankType","bankNum","coinType","paymentState","collectionTotalNum","collectionTotalName","houseNumber","sum","deductionsHouseNumber","deductionsSum","tobankDate","prepareDeductionsDate","deductionsDate"};
        List<FinancialGroupTotal> dataset = new ArrayList<FinancialGroupTotal>();    	
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("银联托收文件头");
			exl.setList(dataset);
			list.add(exl);
		try {
		    return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public FinancialGroupTotal createCollection(String projectId) {
		
		FinancialGroupTotal fgt = new FinancialGroupTotal();
		fgt.setCollectionState(1);//1-已托收
		fgt.setProjectId(projectId);
		List<FinancialGroupTotal> ftList = financialGroupTotalMapper.listAllFinancialGroupTotal(fgt);//查询当前项目下已托收的总结文件
		if(ftList.size()>0){
			fgt.setFileNames("正在托收中，请完成回盘再新建托收！");
			return fgt;
		}
		List<Bill> billList = billMapper.listMergeBillByProjectId(projectId);//根据项目ID查找所有状态为未核销的账单并合并金额
		
		FinancialGroupTotal financialGroupTotal = new FinancialGroupTotal();
		String financialGroupTotalId = UUID.randomUUID().toString();
		financialGroupTotal.setFinancialGroupTotalId(financialGroupTotalId);//设置id
		
		double countNum = 0;
		int i = 0;
		List<FinancialGroupDetail> financialGroupDetailList = new ArrayList<>();
		for(Bill bill:billList){
			String buildingId = bill.getBuildingId();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");//设置日期格式
			String dateStr = df.format(new Date());// new Date()为获取当前系统时间
			//根据建筑结构id、托收类型和当前日期查询启用状态的银行托收办理信息,1-金融联,0-银联
			List<CollectionManage> cmList = collectionManageMapper.listCollectionManagebybuildingId(buildingId,"1",dateStr);
			if(cmList.size()>0){
				CollectionManage cm = cmList.get(0);
				//根据建筑结构ID查询建筑结构
				BuildingStructureNew bsn = buildingStructureNewMapper.getBuildingStructureById(buildingId);
				FinancialGroupDetail financialGroupDetail = new FinancialGroupDetail();
				String uuid = UUID.randomUUID().toString();
				financialGroupDetail.setFinancialGroupDetailId(uuid);
				financialGroupDetail.setFinancialGroupTotalId(financialGroupTotalId);
				if(bsn != null){
					financialGroupDetail.setHouseNum(bsn.getBuildingCertificate());
					financialGroupDetail.setHouseAddress(bsn.getFullName());
				}
				financialGroupDetail.setContractNumber(cm.getContractNumber());
				financialGroupDetail.setBankType(cm.getBankName());//行别 
				financialGroupDetail.setBankNum("000000000000");//开户行号
				financialGroupDetail.setBankAccount(cm.getBankAccount());
				financialGroupDetail.setSum(bill.getNoCollectSum());
				financialGroupDetail.setDeductionsTag("X");//扣款标记
				financialGroupDetail.setCustName(cm.getCustName());
				financialGroupDetail.setMessage(cm.getMessage());
//				financialGroupDetail.setBillId(bill.getBillId());
				financialGroupDetail.setBuildingId(buildingId);
				financialGroupDetail.setChargeTypeId(bill.getChargeTypeId());
				financialGroupDetail.setCollectionManegeId(cm.getCollectionManageId());
				financialGroupDetail.setCollectionState(0);//0未托收
				financialGroupDetail.setProjectId(projectId);
				financialGroupDetail.setBirthDate(new Date());
				financialGroupDetail.setCollectionType(0);//0-托收
//				financialGroupDetail.setBatchNumber(batchNumber);
				countNum = ArithUtils.add(countNum, bill.getNoCollectSum());
				financialGroupDetailList.add(financialGroupDetail);
				i++;
				financialGroupDetailMapper.insertFinancialGroupDetail(financialGroupDetail);
			}
		}
		if(i>0){
			Project project = projectMapper.getProject(projectId);
			financialGroupTotal.setProjectId(projectId);
			financialGroupTotal.setProjectName(project.getProjectName());
			financialGroupTotal.setAgencyBankNum("06000");//TODO代办银行号
			financialGroupTotal.setPaymentUnitCode("C00000000H51");//TODO收付单位代码
			financialGroupTotal.setCoinType(0);//0-人民币
			financialGroupTotal.setPaymentState(1);//1-收
			financialGroupTotal.setCollectionTotalNum("731");//TODO收付代码
//			financialGroupTotal.setCollectionTotalName("H5100081");//TODO
			financialGroupTotal.setHouseNumber(i);
			financialGroupTotal.setSum(countNum);
			financialGroupTotal.setTobankDate(new Date());
			financialGroupTotal.setPrepareDeductionsDate(new Date());
			financialGroupTotal.setFinancialGroupDetails(financialGroupDetailList);
			financialGroupTotal.setCollectionType(0);//0-未托收
			financialGroupTotal.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
			financialGroupTotalMapper.insertFinancialGroupTotal(financialGroupTotal);
		}else{
			financialGroupTotal.setFinancialGroupTotalId(null);
			financialGroupTotal.setFileNames("未生成托收记录！");
		}
		return financialGroupTotal;
	}

	@Override
	public Info importFinancialFile(FinancialGroupTotal financialGroupTotal) {
		com.flf.request.Info info=new com.flf.request.Info();
		String msg="";
		String financialFiles = financialGroupTotal.getFileNames();
		String projectId = financialGroupTotal.getProjectId();
		if(financialFiles == null || "".equals(financialFiles)){
			msg = "请选择文件上传";
			info.setInfo(msg);
			info.setState("201");
			return info;
		}
		String[] buff = financialFiles.split(",");
		int size = buff.length;
		Map<String,String> fileNameMap = new HashMap<String,String>();
		List<String> oldFileNameList = new ArrayList<String>(); 
		List<String> newFileNameList = new ArrayList<String>(); 
		//查询已托收的托收记录
		List<FinancialGroupTotal> fctList =  financialGroupTotalMapper.listFinancialIng(projectId);
		if(fctList.size() != 1){
			msg = "已托收的记录为空或者超过一条！";
			info.setInfo(msg);
			info.setState("201");
			return info;
		}
		
		FinancialGroupTotal fct = fctList.get(0);
		String batchNumber = fct.getBatchNumber();
		String fctNumStr = fct.getCollectionTotalName().substring(fct.getCollectionTotalName().length()-3);
		String fctFrontStr = fct.getCollectionTotalName().substring(0,3);
		
		//删除未回盘状态的回盘总结文件和回盘明细文件
		FinancialCounterofferTotal financialCounterofferTotal = new FinancialCounterofferTotal();
		financialCounterofferTotal.setBatchNumber(batchNumber);
		financialCounterofferTotal.setOfferState("0");
		financialCounterofferTotal.setProjectId(projectId);
		List<FinancialCounterofferTotal> fcotList = financialCounterofferTotalMapper.listAllFinancialCounterofferTotal(financialCounterofferTotal);
		for(FinancialCounterofferTotal fcot:fcotList){
			FinancialCounterofferDetail financialCounterofferDetail = new FinancialCounterofferDetail();
			financialCounterofferDetail.setFinancialCounterofferTotalId(fcot.getFinancialCounterofferTotalId());
			List<FinancialCounterofferDetail> fcdList = financialCounterofferDetailMapper.listAllFinancialCounterofferDetail(financialCounterofferDetail);
			for(FinancialCounterofferDetail fcd:fcdList){
				financialCounterofferDetailMapper.deleteByPrimaryKey(fcd.getFinancialCounterofferDetailId());
			}
			financialCounterofferTotalMapper.deleteByPrimaryKey(fcot.getFinancialCounterofferTotalId());
		}
		
		if(size%2==0){
			for(int i = 0;i<buff.length;i++){
				String fileName = buff[i];
				String oldFileName = fileName.split("_")[2];
				oldFileNameList.add(oldFileName);
				newFileNameList.add(fileName);
				fileNameMap.put(oldFileName, fileName);
			}
			
			for(int i = 0;i<oldFileNameList.size();i++){
				String oldFileName = oldFileNameList.get(i);
				String fileNameHeader=oldFileName.substring(0,oldFileName.lastIndexOf("."));
				String fileNameExt = oldFileName.substring(oldFileName.lastIndexOf("."));
				if(".T10".equals(fileNameExt)){
					String totalFileName = fileNameHeader+".T20";
					if(!oldFileNameList.contains(totalFileName)){
						msg = "没有与明细文件"+oldFileName+"对应的总结文件";
						info.setInfo(msg);
						info.setState("201");
						return info;
					}
				}else if(".T20".equals(fileNameExt)){
					String detailFileName = fileNameHeader+".T10";
					if(!oldFileNameList.contains(detailFileName)){
						msg = "没有与总结文件"+oldFileName+"对应的明细文件";
						info.setInfo(msg);
						info.setState("201");
						return info;
					}
					String numStr = fileNameHeader.substring(fileNameHeader.length()-3);
					String frontStr = fileNameHeader.substring(0, 3);
					if(!fctNumStr.equals(numStr)){
						msg = "文件"+detailFileName+"名称中批次号与托收批次号不一致！";
						info.setInfo(msg);
						info.setState("201");
						return info;
					}
					if(!frontStr.equals(fctFrontStr)){
						msg = "文件"+detailFileName+"名称中前三位单位号与托收交易文件名称中单位号不一致！";
						info.setInfo(msg);
						info.setState("201");
						return info;
					}
					String bankStr = fileNameHeader.substring(3, 5);
					FinancialBankNum fbn = financialBankNumMapper.getFinancialBankNumByBankNum(bankStr);
					if(fbn == null){
						msg = "文件"+detailFileName+"名称中第四五位行别在系统中不存在！";
						info.setInfo(msg);
						info.setState("201");
						return info;
					}
				}else{
					msg = "文件"+oldFileName+"格式不正确";
					info.setInfo(msg);
					info.setState("201");
					return info;
				}
			}
		}else{
			msg = "导入文件数必须为偶数";
			info.setInfo(msg);
			info.setState("201");
			return info;
		}
		StringBuffer sBuff = new StringBuffer();
		sBuff.append("文件");
		Boolean bl = false;
		int failNum = 0;
		for(int i = 0;i<oldFileNameList.size();i++){
			String oldFileName = oldFileNameList.get(i);
			String fileNameHeader=oldFileName.substring(0,oldFileName.lastIndexOf("."));
			String fileNameExt = oldFileName.substring(oldFileName.lastIndexOf("."));
			if(".T10".equals(fileNameExt)){
				String totalFileName = fileNameHeader+".T20";
				try {
					TempDemo temp = readAndInsert(batchNumber,fileNameMap.get(totalFileName),fileNameMap.get(oldFileName),totalFileName,projectId);
					if(!temp.getBool()){
						failNum++;
						bl = true;
						sBuff.append(temp.getBuff()+",");
					}
				} catch (Exception e) {
					failNum++;
					// TODO Auto-generated catch block
					e.printStackTrace();
					bl = true;
					sBuff.append("文件"+totalFileName+"和"+oldFileName+"导入失败,");
				}
			}
		}
		if(bl){
			msg = sBuff.substring(0, sBuff.length()-1);
		}else{
			msg = "导入成功！";
		}
		info.setCode(batchNumber);
		
		if(size == failNum * 2){
			info.setState("201");
			info.setInfo("全部导入失败！,"+msg);
		}else{
			if(bl){
				info.setInfo("部分导入成功！,"+msg);
			}else{
				info.setInfo(msg);
			}
			info.setState("200");
		}
		return info;
	}
	
	private TempDemo readAndInsert(String batchNumber,String totalFileName, String fileName,
			String oldTotalFilename,String projectId) throws URISyntaxException {
		TempDemo temp = new TempDemo();
		String str = getClass().getClassLoader().getResource("").toURI().getPath();
    	String totalFileNamePath ="/" + str.substring(str.indexOf("/", 0)+1, str.lastIndexOf("WEB-INF/")) + totalFileName;
    	String fileNamePath ="/" + str.substring(str.indexOf("/", 0)+1, str.lastIndexOf("WEB-INF/")) + fileName;
    	
    	String oldTFHeadStr =oldTotalFilename.substring(0,oldTotalFilename.lastIndexOf("."));
    	FinancialCounterofferTotal financialCounterofferTotal = new FinancialCounterofferTotal();
		financialCounterofferTotal.setBatchNumber(batchNumber);
//		financialCounterofferTotal.setOfferState("0");
		financialCounterofferTotal.setCollectionTotalName(oldTFHeadStr);//交易文件名
		List<FinancialCounterofferTotal> fctList = financialCounterofferTotalMapper.listAllFinancialCounterofferTotal(financialCounterofferTotal);
		if(fctList.size()>0){
			temp.setBool(false);
			temp.setBuff("文件"+oldTotalFilename+"已经导入过！");
			return temp;
		}
		try{
			String encoding = "GBK";
			File totalFile = new File(totalFileNamePath);
			File detailFile = new File(fileNamePath);
			if(totalFile.isFile() && totalFile.exists() && detailFile.isFile() && detailFile.exists()){
				 InputStreamReader totalRead = new InputStreamReader(
	                    new FileInputStream(totalFile),encoding);//考虑到编码格式
				 BufferedReader totalBufferedReader = new BufferedReader(totalRead);
                 String totalLineTxt = null;
                 int i = 0;
                 FinancialCounterofferTotal fct = new FinancialCounterofferTotal();
                 List<FinancialCounterofferDetail> fcdList = new ArrayList<FinancialCounterofferDetail>();
                 String uuid = UUID.randomUUID().toString();
                 fct.setFinancialCounterofferTotalId(uuid);
                 while((totalLineTxt = totalBufferedReader.readLine()) != null){
                	 if(totalLineTxt.length() != 98){
                		 totalBufferedReader.close();
                		 totalRead.close();
                		 temp.setBool(false);
            			 temp.setBuff("总结文件"+oldTotalFilename+"内容中字符串长度不对！");
            			 return temp;
                	 }
                	 if(i >1){
                		totalBufferedReader.close();
                   		totalRead.close();
                   		temp.setBool(false);
            			temp.setBuff("总结文件"+oldTotalFilename+"中内容不应超过1行！");
            			return temp;
                   	 }
                	 String agencyBankNum = totalLineTxt.substring(0, 5);
                	 String paymentUnitCode = totalLineTxt.substring(5,17);
                	 String coinType = totalLineTxt.substring(17,18);
                	 String paymentState = totalLineTxt.substring(18,19);
                	 String collectionTotalNum = totalLineTxt.substring(19,22);
                	 String collectionTotalName = totalLineTxt.substring(22,30);
                	 
                	 if(!oldTFHeadStr.equals(collectionTotalName)){
                		 totalBufferedReader.close();
                		 totalRead.close();
                		 temp.setBool(false);
            			 temp.setBuff("总结文件"+oldTotalFilename+"内容中交易文件名称字段与文件名称不一致！");
            			 return temp;
                	 }
                	 
                	 String houseNumber = totalLineTxt.substring(30,38);
                	 String sum = totalLineTxt.substring(38,52);
                	 String deductionsHouseNumber = totalLineTxt.substring(52,60);
                	 String deductionsSum = totalLineTxt.substring(60,74);
                	 String tobankDate = totalLineTxt.substring(74,82);
                	 String prepareDeductionsDate = totalLineTxt.substring(82,90);
                	 String deductionsDate = totalLineTxt.substring(90,97);
                	 fct.setAgencyBankNum(agencyBankNum);
                	 fct.setPaymentUnitCode(paymentUnitCode);
                	 fct.setCoinType(Integer.parseInt(coinType));
                	 fct.setPaymentState(Integer.parseInt(paymentState));
                	 fct.setCollectionTotalNum(collectionTotalNum);
                	 fct.setCollectionTotalName(collectionTotalName);
                	 fct.setHouseNumber(Integer.parseInt(houseNumber));
                	 fct.setSum(Double.parseDouble(sum));
                	 fct.setDeductionsHouseNumber(Integer.parseInt(deductionsHouseNumber));
                	 fct.setDeductionsSum(Double.parseDouble(deductionsSum));
                	 SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                	 fct.setTobankDate(sdf.parse(tobankDate));
                	 fct.setPrepareDeductionsDate(sdf.parse(prepareDeductionsDate));
                	 fct.setDeductionsDate(sdf.parse(deductionsDate));
                	 fct.setBatchNumber(batchNumber);
                	 fct.setOfferState("0");//0-未回盘
                	 fct.setProjectId(projectId);
                	 i++;
                    
                 }
                 totalBufferedReader.close();
                 totalRead.close();
                 
                 InputStreamReader detailRead = new InputStreamReader(
 	                    new FileInputStream(detailFile),encoding);//考虑到编码格式
				 BufferedReader detailBufferedReader = new BufferedReader(detailRead);
                  String detailLineTxt = null;
                  int count = 0;
                  while((detailLineTxt = detailBufferedReader.readLine()) != null){
                      FinancialCounterofferDetail fcd = new FinancialCounterofferDetail();
                      String fcduuid = UUID.randomUUID().toString();
                      fcd.setFinancialCounterofferDetailId(fcduuid);
                      String contractNumber = detailLineTxt.substring(0,10);
                      String bankType = detailLineTxt.substring(10,12);
                      String bankNum = detailLineTxt.substring(12,24);
                      String bankAccount = detailLineTxt.substring(24,56);
                      String sum = detailLineTxt.substring(56,68);
                      String deductionsTag = detailLineTxt.substring(68,69);
                      String strEnd = detailLineTxt.substring(69);
                      int n = strEnd.indexOf(' ');
                      String custName =strEnd.substring(0,n); 
                      String message = strEnd.substring(n).trim();
                      fcd.setContractNumber(contractNumber);
                      fcd.setBankType(bankType);
                      fcd.setBankNum(bankNum);
                      fcd.setBankAccount(bankAccount);
                      fcd.setSum(Double.parseDouble(sum));
                      fcd.setDeductionsTag(deductionsTag);
                      fcd.setFinancialCounterofferTotalId(uuid);
                      fcd.setCustName(custName);
                      fcd.setMessage(message);
                      fcd.setBatchNumber(batchNumber);
                      fcd.setOfferState("0");//0-未回盘
                      fcdList.add(fcd);
                      count++;
                  }
                  if(count != fct.getHouseNumber()){
                	  detailBufferedReader.close();
                      detailRead.close();
                      temp.setBuff("总结文件”"+oldTotalFilename+"中总户数与明细记录数不对！");
                      temp.setBool(false);
                      return temp;  
                  }
                  fct.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
                  financialCounterofferTotalMapper.insertFinancialCounterofferTotal(fct);
                  for(FinancialCounterofferDetail fDetail:fcdList){
                	  financialCounterofferDetailMapper.insertFinancialCounterofferDetail(fDetail);
                  }
                  detailBufferedReader.close();
                  detailRead.close();
                  temp.setBool(true);
                  return temp;
			}else{
				temp.setBool(false);
				temp.setBuff("找不到文件"+oldTFHeadStr+"！");
				return temp;
			}
		}catch(Exception e){
            e.printStackTrace();
            temp.setBool(false);
			temp.setBuff("读取文件"+oldTFHeadStr+"内容出错！");
			return temp;
		}
	}

	@Override
	public Info confirmImport(FinancialGroupTotal financialGroupTotal) {
		Info info = new Info();
		String msg = "确认导入成功！";
		String batchNumber = financialGroupTotal.getBatchNumber();
		if(batchNumber == null || "".equals(batchNumber)){
			msg = "请重新导入！";
			info.setInfo(msg);
			return info;
		}
		financialGroupTotal.setCollectionState(1);
		List<FinancialGroupTotal> fgtList = financialGroupTotalMapper.listPageFinancial(financialGroupTotal);
		if(fgtList.size() != 1){
			msg = "根据批次号查询托收总结记录不为1条！";
		}else{
			FinancialGroupTotal fgt = fgtList.get(0);
			int houseNumber = fgt.getHouseNumber();//总户数
			Double sum = fgt.getSum();//总金额
			BigDecimal b_sum = BigDecimal.valueOf(sum);
			FinancialCounterofferTotal financialCounterofferTotal = new FinancialCounterofferTotal();
			financialCounterofferTotal.setBatchNumber(financialGroupTotal.getBatchNumber());
			financialCounterofferTotal.setProjectId(financialGroupTotal.getProjectId());
			List<FinancialCounterofferTotal> fctList = financialCounterofferTotalMapper.listAllFinancialCounterofferTotal(financialCounterofferTotal);
			if(fctList.size() == 0){
				msg = "文件导入失败！";
				info.setInfo(msg);
				return info;
			}
			int importHouseNumber = 0;
			BigDecimal b_importSum = BigDecimal.valueOf(0);
			for(FinancialCounterofferTotal fct:fctList){
				importHouseNumber = importHouseNumber+fct.getHouseNumber();
				b_importSum = b_importSum.add(BigDecimal.valueOf(fct.getSum()));
			}
			
			financialCounterofferTotal.setOfferState("0");
			List<FinancialCounterofferTotal> fOffertList = financialCounterofferTotalMapper.listAllFinancialCounterofferTotal(financialCounterofferTotal);
			for(FinancialCounterofferTotal fcototal:fOffertList){
				FinancialCounterofferDetail financialCounterofferDetail = new FinancialCounterofferDetail();
				financialCounterofferDetail.setFinancialCounterofferTotalId(fcototal.getFinancialCounterofferTotalId());
				List<FinancialCounterofferDetail> fcdList = financialCounterofferDetailMapper.listAllFinancialCounterofferDetail(financialCounterofferDetail);
				for(FinancialCounterofferDetail fcd:fcdList){
					String contractNumber = fcd.getContractNumber();
					FinancialGroupDetail financialGroupDetail = new FinancialGroupDetail();
					financialGroupDetail.setContractNumber(contractNumber);
					List<FinancialGroupDetail> fgdList = financialGroupDetailMapper.listAllFinancialGroupDetail(financialGroupDetail);
					if(fgdList.size()>0){
						FinancialGroupDetail fgd = fgdList.get(0);
						BigDecimal b_fgd = BigDecimal.valueOf(fgd.getSum());
						BigDecimal b_fcd = BigDecimal.valueOf(fcd.getSum());
						if(b_fgd.compareTo(b_fcd) !=0){
							msg = "姓名为"+fcd.getCustName()+"并且合同号为"+fcd.getContractNumber()+"的数据回盘金额和托收金额不一致！";
							info.setInfo(msg);
							return info;
						}
					}
				}
			}
			for(FinancialCounterofferTotal fcot:fOffertList){
				FinancialCounterofferDetail financialCounterofferDetail = new FinancialCounterofferDetail();
				financialCounterofferDetail.setFinancialCounterofferTotalId(fcot.getFinancialCounterofferTotalId());
				List<FinancialCounterofferDetail> fcdList = financialCounterofferDetailMapper.listAllFinancialCounterofferDetail(financialCounterofferDetail);
				for(FinancialCounterofferDetail fcd:fcdList){
					String contractNumber = fcd.getContractNumber();
					FinancialGroupDetail financialGroupDetail = new FinancialGroupDetail();
					financialGroupDetail.setContractNumber(contractNumber);
					List<FinancialGroupDetail> fgdList = financialGroupDetailMapper.listAllFinancialGroupDetail(financialGroupDetail);
					if(fgdList.size()>0){
						FinancialGroupDetail fgd = fgdList.get(0);
						fgd.setCollectionState(2);//2-已回盘
						financialGroupDetailMapper.updateFinancialGroupDetail(fgd);
						Bill newBill = new Bill();
						newBill.setBuildingId(fgd.getBuildingId());
						newBill.setBillState(0);
//						newBill.setChargeTypeId(fgd.getChargeTypeId());
						List<Bill> billList = billMapper.listAllBill(newBill);
						if("Y".equals(fcd.getDeductionsTag())){
							BigDecimal zero = BigDecimal.valueOf(0);
							BigDecimal total_noColl = BigDecimal.valueOf(0);
							String chargeTypeId = "";
							for(Bill deBill:billList){
								total_noColl = total_noColl.add(new BigDecimal(deBill.getNoCollectSum()));
								chargeTypeId = deBill.getChargeTypeId();
							}
							Double d_no = ArithUtils.sub(total_noColl.doubleValue(), fcd.getSum());
							BigDecimal bd = new BigDecimal(d_no);
							if(bd.compareTo(zero)<0){
								d_no = 0.0;
							}
							
							for(int i = 0;i<billList.size();i++){
								Bill bill = billList.get(i);
								bill.setCollectSum(bill.getNoCollectSum());//实收金额
								bill.setCurrentOweSum(0.0);//本期欠款余额
								bill.setLastOweSum(0.0);//上期欠款余额
								if(i == 0){
									bill.setNoCollectSum(d_no);//未收金额
									bill.setOverdue(d_no);//滞纳金
								}else{
									bill.setNoCollectSum(0.0);//未收金额
									bill.setOverdue(0.0);//滞纳金
								}
								BigDecimal b_no = new BigDecimal(d_no);
								if(zero.compareTo(b_no) == 0){
									bill.setBillState(1);//1-已核销
								}else{
									bill.setBillState(2);//2-未核销
								}
								billMapper.updateBill(bill);
							}
							//预收款明细表
							AdvancePaymentsDetails apd = new AdvancePaymentsDetails();
							AssetAccount ass = assetAccountMapper.getAssetAccountByBuildingStructureId(fgd.getBuildingId());
							apd.setAssetAccountNum(ass.getAssetAccountNum());
							apd.setChargeTypeId(chargeTypeId);
							apd.setAssetAccountId(ass.getAssetAccountId());
							apd.setAdvancePaymentsDetailsId(UUID.randomUUID().toString());
							apd.setTransactionAmount(fcd.getSum());
							apd.setIsOutIn(4);
							apd.setTransactionDate(new Date());
							advancePaymentsDetailsMapper.insertAdvancePaymentsDetails(apd);
						}else{
							for(Bill bill:billList){
								bill.setBillState(2);//2-未核销
								billMapper.updateBill(bill);
							}
						}
						
						fcd.setOfferState("1");//1-已回盘
						financialCounterofferDetailMapper.updateFinancialCounterofferDetail(fcd);
					}else{
						msg = "合同号不匹配！";
						info.setInfo(msg);
						return info;
					}
				}
				fcot.setOfferState("1");//1-已回盘
				financialCounterofferTotalMapper.updateFinancialCounterofferTotal(fcot);
			}
			
			if((houseNumber == importHouseNumber)&&(b_sum.compareTo(b_importSum) == 0)){//户数相同，金额相同
				fgt.setCollectionState(2);//2-已回盘
				financialGroupTotalMapper.updateFinancialGroupTotal(fgt);
			}
		}
		info.setInfo(msg);
		return info;
	}

	@Override
	public void deleteFinancialGroupTotal(String financialGroupTotalId) {
		FinancialGroupDetail financialGroupDetail = new FinancialGroupDetail();
		financialGroupDetail.setFinancialGroupTotalId(financialGroupTotalId);
		List<FinancialGroupDetail> list = financialGroupDetailMapper.listAllFinancialGroupDetail(financialGroupDetail);
		for(FinancialGroupDetail fgd:list){
			financialGroupDetailMapper.deleteByPrimaryKey(fgd.getFinancialGroupDetailId());
		}
		financialGroupTotalMapper.deleteByPrimaryKey(financialGroupTotalId);
	}
}
