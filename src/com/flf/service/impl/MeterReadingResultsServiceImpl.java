package com.flf.service.impl;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.flf.entity.Annex;
import com.flf.entity.MeterReadingProgram;
import com.flf.entity.MeterReadingResults;
import com.flf.entity.PageRestful;
import com.flf.entity.Property;
import com.flf.entity.SearchMeter;
import com.flf.entity.WaterMeter;
import com.flf.mapper.MeterReadingProgramMapper;
import com.flf.mapper.MeterReadingResultsMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.MeterReadingResultsService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

public class MeterReadingResultsServiceImpl implements
		MeterReadingResultsService {
    private MeterReadingResultsMapper meterReadingResultsMapper;
    
    private MeterReadingProgramMapper meterReadingProgramMapper;
    
    
	public MeterReadingProgramMapper getMeterReadingProgramMapper() {
		return meterReadingProgramMapper;
	}

	public void setMeterReadingProgramMapper(
			MeterReadingProgramMapper meterReadingProgramMapper) {
		this.meterReadingProgramMapper = meterReadingProgramMapper;
	}

	public MeterReadingResultsMapper getMeterReadingResultsMapper() {
		return meterReadingResultsMapper;
	}

	public void setMeterReadingResultsMapper(
			MeterReadingResultsMapper meterReadingResultsMapper) {
		this.meterReadingResultsMapper = meterReadingResultsMapper;
	}

	@Override
	public PageRestful listPageMeterReadingResults(SearchMeter searchMerter) {
		// TODO Auto-generated method stub
		PageRestful pageRestful =new PageRestful();
		List<MeterReadingResults> meterReadingResult=meterReadingResultsMapper.listPageMeterReadingResults(searchMerter);
		meterReadingResult.add(0,null);
		pageRestful.setMeterReadingResult(meterReadingResult);
		pageRestful.setPage(searchMerter.getPage());
		return pageRestful;
	}

	@Override
	public void insertMeterReadingResults(
			MeterReadingResults meterReadingResults) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMeterReadingResults(
			MeterReadingResults meterReadingResults) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMeterReadingResults(String meterReadingResultsId) {
		// TODO Auto-generated method stub

	}

	@Override
	public InputStream exportMeterReadingResults() {
		// TODO Auto-generated method stub
		//导出到excel
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = { "计划名称","总表数","是否上传成功", "未抄表数", "已审核表数", "正常表数","异常表数","错误表数","当前执行人","抄表时间"};
		String[] fields = {"projectName","meterReadingNum","whetherUploadSuccess","noMeterReadingNum","reviewMeterNum","meterReadingNormalNum",
				"meterReadingWarningNum","meterReadingErrorNum","currentExecutor","meterExecutiveTime"};
        List<MeterReadingResults> dataset = meterReadingResultsMapper.listAllMeterReadingResults();
      
        if(dataset.size() > 0){
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("抄表报表");
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
/**
  * 2015-12-22 陶勇超
  * 水表管理抄表结果导入模版
 */
	@Override
	public InputStream exportMeterReading()  {
		// TODO Auto-generated method stub
		//定义导入模版对象并加空对象
		  List<MeterReadingResults> listMeter=new ArrayList<MeterReadingResults>();
		  listMeter.add(null);
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
		String[] headers = { "计划名称","正常表数","未抄表数", "当前执行人","抄表时间"};
		String[] fields = {"projectName","meterReadingNormalNum","noMeterReadingNum","currentExecutor","meterExecutiveTime"};
        List<MeterReadingResults> dataset = new ArrayList<MeterReadingResults>();
     
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("抄表结果");
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
	  * 2015-12-22 陶勇超
	  * 水表管理抄表结果导入
	 */
	@Override
	public Info importExcelFileWaterMeter(Annex annex) {
		// TODO Auto-generated method stub
		//获取导入地址
		String filePath = annex.getAnnexAddress();
		String UUID1=java.util.UUID.randomUUID().toString();
		String UUID2=java.util.UUID.randomUUID().toString();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	     MeterReadingProgram mrp = null;
		MeterReadingResults mrr =null;
		if (Tools.notEmpty(filePath)) {
			try {
				//导入数据插入数据库
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				if (dataList != null && dataList.size() > 0) {
					for (Map<Short, String> t : dataList) {
						mrp=new MeterReadingProgram(); 
						mrp.setMeterReadingProgramId(UUID1);
						mrp.setProjectName(t.get((short) 0));
						mrp.setCurrentExecutor(t.get((short) 3));
						
					    mrr=new MeterReadingResults();
					    mrr.setMeterReadingProgramId(UUID1);
						mrr.setMeterExecutiveId(UUID2);
						mrr.setCurrentExecutor(t.get((short) 3));
						//String str = t.get((short) 1);
						int db =(int) Double.parseDouble(t.get((short)1));
						int db2=(int) Double.parseDouble(t.get((short)2));
						mrr.setMeterReadingNormalNum(db);
						mrr.setNoMeterReadingNum(db2);
						mrr.setMeterExecutiveTime(sdf.parse(t.get((short) 4)));
						meterReadingProgramMapper.insertMeterReadingProgram(mrp);
						meterReadingResultsMapper.insert(mrr);
					}
					
					return Tools.msg("数据导入成功!",true);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return Tools.msg("数据导入失败!", false);
	}

}
