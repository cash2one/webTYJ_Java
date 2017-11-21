package com.flf.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import com.flf.entity.Annex;
import com.flf.entity.PageRestful;
import com.flf.entity.UnionpayCounterofferDetai;
import com.flf.mapper.UnionpayCounterofferDetaiMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.UnionpayCounterofferDetaiService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

public class UnionpayCounterofferDetaiServiceImpl implements UnionpayCounterofferDetaiService {
	private UnionpayCounterofferDetaiMapper unionpayCounterofferDetaiMapper;

	public UnionpayCounterofferDetaiMapper getUnionpayCounterofferDetaiMapper() {
		return unionpayCounterofferDetaiMapper;
	}

	public void setUnionpayCounterofferDetaiMapper(UnionpayCounterofferDetaiMapper unionpayCounterofferDetaiMapper) {
		this.unionpayCounterofferDetaiMapper = unionpayCounterofferDetaiMapper;
	}

	@Override
	public int insertUnionpayCounterofferDetai(UnionpayCounterofferDetai unionpayCounterofferDetai) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UnionpayCounterofferDetai> getUnionpayCounterofferDetaiById(String unionpayCounterofferCotalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUnionpayCounterofferDetai1(UnionpayCounterofferDetai unionpayCounterofferDetai) {
		// TODO Auto-generated method stub
		unionpayCounterofferDetaiMapper.insertUnionpayCounterofferDetai(unionpayCounterofferDetai);
	}

	@Override
	public List<UnionpayCounterofferDetai> getUnionpayCounterofferDetaiByIdRestful(String unionpayCounterofferDetaiId) {
		// TODO Auto-generated method stub
		return unionpayCounterofferDetaiMapper.getUnionpayCounterofferDetaiByUTId(unionpayCounterofferDetaiId);
	}

	@Override
	public Info importExcel(UnionpayCounterofferDetai unionpayCounterofferDetai) {
		// TODO Auto-generated method stub
		List<UnionpayCounterofferDetai> unionpayCounterofferDetais = unionpayCounterofferDetai
				.getUnionpayCounterofferDetais();// 存放导入的数据
		if (unionpayCounterofferDetais != null) {
			for (UnionpayCounterofferDetai u : unionpayCounterofferDetais) {
				// u.setUnionpayCounterofferDetaiId(UUID.randomUUID().toString());
				unionpayCounterofferDetaiMapper.insertUnionpayCounterofferDetai(u);
			}
			return Tools.msg("数据导入成功!", true);
		}
		return Tools.msg("数据导入失败!", true);
	}

	@Override
	public List<UnionpayCounterofferDetai> returnImportCounterofferDetai(Annex annex) {
		// TODO Auto-generated method stub
		/*
		 * List<UnionpayCounterofferDetai> unionpayCounterofferDetais = new
		 * ArrayList<UnionpayCounterofferDetai>(); SimpleDateFormat sdf = new
		 * SimpleDateFormat("yyyy-MM-dd"); String filePath =
		 * annex.getAnnexAddress(); String unionpayCounterofferCotalId =
		 * annex.getRelationId(); if (Tools.notEmpty(filePath)) { try {
		 * List<Map<Short, String>> dataList = new ExcelUtils()
		 * .readExcel(filePath); if (dataList != null && dataList.size() > 0) {
		 * for (Map<Short, String> t : dataList) { UnionpayCounterofferDetai
		 * unionpayCounterofferDetai = new UnionpayCounterofferDetai();
		 * unionpayCounterofferDetai .setUnionpayCounterofferDetaiId(UUID
		 * .randomUUID().toString()); unionpayCounterofferDetai
		 * .setUnionpayCounterofferTotalId(unionpayCounterofferCotalId); Date dt
		 * = HSSFDateUtil.getJavaDate(Double.valueOf(t.get((short) 0)));
		 * unionpayCounterofferDetai.setCpDate(dt); unionpayCounterofferDetai
		 * .setCpRunning(t.get((short) 1));
		 * unionpayCounterofferDetai.setCustNum(t.get((short) 2));
		 * unionpayCounterofferDetai.setCustName(t.get((short) 3));
		 * unionpayCounterofferDetai.setCardHost(t.get((short) 4)); if
		 * ("身份证".equals(t.get((short) 5))) {
		 * unionpayCounterofferDetai.setCardType(0); } else if
		 * ("学生证".equals(t.get((short) 5))) {
		 * unionpayCounterofferDetai.setCardType(1); } else {
		 * unionpayCounterofferDetai.setCardType(2); }
		 * unionpayCounterofferDetai.setCardNum(t.get((short) 6)); if
		 * ("银行卡".equals(t.get((short) 7))) {
		 * unionpayCounterofferDetai.setAccountType(0); } else {
		 * unionpayCounterofferDetai.setAccountType(1); }
		 * unionpayCounterofferDetai.setAccountNum(t .get((short) 8));
		 * unionpayCounterofferDetai.setBankNum(t.get((short) 9)); Date dt1 =
		 * HSSFDateUtil.getJavaDate(Double.valueOf(t.get((short) 10)));
		 * unionpayCounterofferDetai.setTransactionDate(dt1); if
		 * ("完成".equals(t.get((short) 11))) {
		 * unionpayCounterofferDetai.setTransactionType("1"); } else {
		 * unionpayCounterofferDetai.setTransactionType("0"); }
		 * unionpayCounterofferDetai.setResponseCode(t .get((short) 12));
		 * unionpayCounterofferDetai.setSum(Double.parseDouble(t .get((short)
		 * 13))); unionpayCounterofferDetai.setPrivateDomain(t .get((short)
		 * 14)); unionpayCounterofferDetais .add(unionpayCounterofferDetai); }
		 * 
		 * } } catch (Exception e) { // TODO: handle exception } }
		 */

		return null;
	}

	/**
	 * 导出回盘明细文件模版
	 * 
	 * @author xiaocong
	 * @date 下午7:48:39
	 * @Description:TODO
	 * @return
	 * @updateby
	 */
	@Override
	public InputStream exportMBUDetailFile() {
		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "cp日期", "cp流水", "客户编号", "客户名称", "持卡人姓名", "证件类型", "证件号", "账户类型", "卡号/存折号", "开户行行号", "交易日期",
				"交易状态", "响应码", "金额", "私有域" };
		String[] fields = { "cpDate", "cpRunning", "custNum", "custName", "cardHost", "cardType", "cardNum",
				"accountType", "accountNum", "bankNum", "transactionDate", "transactionType", "responseCode", "sum",
				"privateDomain" };
		List<UnionpayCounterofferDetai> dataset = new ArrayList<UnionpayCounterofferDetai>();
		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("回盘明细文件模版 ");
		exl.setList(dataset);
		list.add(exl);
		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public PageRestful listPagegetUnionpayCounterofferDetai(UnionpayCounterofferDetai unionpayCounterofferDetai) {
		PageRestful pageRestful = new PageRestful();
		List<UnionpayCounterofferDetai> unionpayCounterofferDetais = unionpayCounterofferDetaiMapper
				.listPagegetUnionpayCounterofferDetai(unionpayCounterofferDetai);
		unionpayCounterofferDetais.add(0, null);
		pageRestful.setUnionpayCounterofferDetais(unionpayCounterofferDetais);
		pageRestful.setPage(unionpayCounterofferDetai.getPage());
		return pageRestful;
	}

}
