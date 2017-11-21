package com.flf.service.impl;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import com.flf.entity.PageRestful;
import com.flf.entity.UnionpayCollectionDetail;
import com.flf.mapper.UnionpayCollectionDetailMapper;
import com.flf.request.ExcelInfo;
import com.flf.service.UnionpayCollectionDetailService;
import com.flf.util.Excel;
import com.flf.util.ExportExcel;

@WebService
public class UnionpayCollectionDetailServiceImpl implements UnionpayCollectionDetailService {
  
	private UnionpayCollectionDetailMapper unionpayCollectionDetailMapper;

	
	
	public UnionpayCollectionDetailMapper getUnionpayCollectionDetailMapper() {
		return unionpayCollectionDetailMapper;
	}

	public void setUnionpayCollectionDetailMapper(
			UnionpayCollectionDetailMapper unionpayCollectionDetailMapper) {
		this.unionpayCollectionDetailMapper = unionpayCollectionDetailMapper;
	}

	@Override
	public List<UnionpayCollectionDetail> getUnionpayCollectionDetailById(
			String projectId) {
		// TODO Auto-generated method stub
		return unionpayCollectionDetailMapper.getUnionpayCollectionDetailById(projectId);
	}

	@Override
	public List<UnionpayCollectionDetail> getUnionpayCollectionDetailByIdRestful(
			String projectId) {
		// TODO Auto-generated method stub
		return unionpayCollectionDetailMapper.getUnionpayCollectionDetailById(projectId);
	}
		
	public PageRestful listPageUnionpayCollectionDetailById(UnionpayCollectionDetail unionpayCollectionDetail){
			PageRestful pageRestful=new PageRestful();
			List<UnionpayCollectionDetail> unionpayCollectionDetails =unionpayCollectionDetailMapper.listPageUnionpayCollectionDetailById(unionpayCollectionDetail);
			unionpayCollectionDetails.add(0,null);
			pageRestful.setUnionpayCollectionDetails(unionpayCollectionDetails);
			pageRestful.setPage(unionpayCollectionDetail.getPage());
			return pageRestful;
	}
	@Override
	public List<UnionpayCollectionDetail> exportExcelFile(
			UnionpayCollectionDetail unionpayCollectionDetail) {
		// TODO Auto-generated method stub
		 ExportExcel<UnionpayCollectionDetail> ex = new ExportExcel<UnionpayCollectionDetail>();
	     String[] headers = { "主键id", "总结文件ID","商户日期", "客户号", "银行账号", "账号类型","金额","私有域","项目id","银联回盘明细文件id"};
	     List<UnionpayCollectionDetail> dataset = new ArrayList<UnionpayCollectionDetail>();
	       dataset.add(unionpayCollectionDetail);
	    		// getUnionpayCollectionDetailByIdRestful(unionpayCollectionDetail.getProjectId());
	   //  String str="select * from tc_unionpay_collection_totall where unionpay_collection_totall_id=?";
				try {
					 OutputStream out = new FileOutputStream("E://银行托收明细文件.xls");
					 ex.exportExcel(headers, dataset, out);
					 out.close();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} 
	      
	         System.out.println("excel导出成功！");
	         return null;
	}

	@Override
	public InputStream exportUDetailFile(String unionpayCollectionTotallId) {
		Excel ex=new Excel();
	    List<ExcelInfo> list=new ArrayList<ExcelInfo>();
//	    String[] headers = { "主键id", "总结文件ID","商户日期", "客户号", "银行账号", "账号类型","金额","私有域","项目id","户主"};
	    String[] headers = { "商户日期", "客户号", "银行账号", "账号类型",
	    		"金额","私有域"};
//		String[] fields = {"unionpayCollectionDetaiId","unionpayCollectionTotallId",
//				"merchDateToString","custNum","bankAccount","accountType","sum","privateDomain","projectId","custName"};
		String[] fields = {"merchDateToString","custNum","bankAccount","accountType",
				"sum","privateDomain"};
        List<UnionpayCollectionDetail> dataset = unionpayCollectionDetailMapper.getUnionpayCollectionDetails(unionpayCollectionTotallId);
      
        if(dataset.size() > 0){        	
        	ExcelInfo exl=new ExcelInfo();
			exl.setFields(fields);
			exl.setTitles(headers);
			exl.setSheetName("银行托收明细文件");
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

	
}