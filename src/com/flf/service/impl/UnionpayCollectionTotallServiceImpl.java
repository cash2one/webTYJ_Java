package com.flf.service.impl;

import java.io.ByteArrayInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import com.flf.entity.Bill;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.CollectionManage;
import com.flf.entity.HouseNew;
import com.flf.entity.PageRestful;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Project;
import com.flf.entity.UnionpayCollectionDetail;
import com.flf.entity.UnionpayCollectionTotall;
import com.flf.mapper.BillMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.CollectionManageMapper;
import com.flf.mapper.HouseNewMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.UnionpayCollectionDetailMapper;
import com.flf.mapper.UnionpayCollectionTotallMapper;
import com.flf.request.ExcelInfo;
import com.flf.service.UnionpayCollectionTotallService;
import com.flf.util.ArithUtils;
import com.flf.util.Excel;
import com.flf.util.ExportExcel;

public class UnionpayCollectionTotallServiceImpl implements UnionpayCollectionTotallService {
	@Autowired
	private PersonCustNewMapper personCustNewMapper;
	@Autowired
	private UnionpayCollectionTotallMapper unionpayCollectionTotallMapper;
	@Autowired
	private UnionpayCollectionDetailMapper unionpayCollectionDetailMapper;
	@Autowired
	private BillMapper billMapper;// 账单
	@Autowired
	private CollectionManageMapper collectionManageMapper;// 托收管理
	@Autowired
	private ProjectMapper projectMapper;// 项目
	@Autowired
	private BuildingStructureNewMapper buildingStructureNewMapper;// 建筑结构

	public UnionpayCollectionDetailMapper getUnionpayCollectionDetailMapper() {
		return unionpayCollectionDetailMapper;
	}

	public void setUnionpayCollectionDetailMapper(UnionpayCollectionDetailMapper unionpayCollectionDetailMapper) {
		this.unionpayCollectionDetailMapper = unionpayCollectionDetailMapper;
	}

	public UnionpayCollectionTotallMapper getUnionpayCollectionTotallMapper() {
		return unionpayCollectionTotallMapper;
	}

	public void setUnionpayCollectionTotallMapper(UnionpayCollectionTotallMapper unionpayCollectionTotallMapper) {
		this.unionpayCollectionTotallMapper = unionpayCollectionTotallMapper;
	}

	@Override
	public List<UnionpayCollectionTotall> getUnionpayCollectionTotallByIdRestful(String unionpayCollectionTotallId) {
		// TODO Auto-generated method stub
		return unionpayCollectionTotallMapper.getUnionpayCollectionTotallById(unionpayCollectionTotallId);
	}

	/**
	 * 导出
	 * 
	 * @throws IOException
	 */
	@Override
	public void exportExcelFile(UnionpayCollectionTotall unionpayCollectionTotall) {
		// TODO Auto-generated method stub
		/*
		 * Excel ex= new Excel();
		 * 
		 * List<ExcelInfo> l =new ArrayList<ExcelInfo>(); String[] titles = {
		 * "主键id", "创建时间", "项目id", "项目名称", "商户号","批次号","总金额"}; String[] filed
		 * ={"unionpayCollectionTotallId","createTime","projectId",
		 * "projectName", "merchantsNum","batchNum","totalSum"};
		 * List<UnionpayCollectionTotall> list =new
		 * ArrayList<UnionpayCollectionTotall>(); l.get(0).setTitles(titles);
		 * l.get(0).setFields(filed); l.get(0).setList(list);
		 * 
		 * 
		 * byte[] buffer = new byte[4096];// 缓冲区 BufferedOutputStream output =
		 * null; InputStream ips=null; try { output = new
		 * BufferedOutputStream(response.getOutputStream());
		 * ips=ex.createExcelInputStream(l); int n = -1; //遍历，开始下载 while ((n =
		 * ips.read(buffer, 0, 4096)) > -1) { output.write(buffer, 0, n); }
		 * output.flush(); //不可少 response.flushBuffer();//不可少 } catch (Exception
		 * e) { //异常自己捕捉 } finally { //关闭流，不可少
		 * 
		 * try { if (ips != null) ips.close();
		 * 
		 * if (output != null) output.close(); } catch (IOException e) { // TODO
		 * Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 */

		ExportExcel<UnionpayCollectionTotall> ex = new ExportExcel<UnionpayCollectionTotall>();
		ExportExcel<UnionpayCollectionDetail> exMx = new ExportExcel<UnionpayCollectionDetail>();
		String[] headers = { "主键id", "创建时间", "项目id", "项目名称", "商户号", "批次号", "总金额" };
		String[] headersMx = { "主键id", "总结文件ID", "商户日期", "客户号", "银行账号", "账号类型", "金额", "私有域", "项目id", "银联回盘明细文件id" };
		List<UnionpayCollectionTotall> dataset = getUnionpayCollectionTotallByIdRestful(
				unionpayCollectionTotall.getUnionpayCollectionTotallId());
		List<UnionpayCollectionDetail> datasetMx = unionpayCollectionDetailMapper
				.getUnionpayCollectionDetails(unionpayCollectionTotall.getUnionpayCollectionTotallId());
		for (int i = 0; i < dataset.size(); i++) {
			dataset.get(i).setPage(null);
		}
		for (int i = 0; i < datasetMx.size(); i++) {
			datasetMx.get(i).setPage(null);
		}
		// String str="select * from tc_unionpay_collection_totall where
		// unionpay_collection_totall_id=?";
		try {
			OutputStream out = new FileOutputStream("E://银行托收文件.xls");
			OutputStream outMx = new FileOutputStream("E://银行托收回盘明细文件.xls");
			ex.exportExcel(headers, dataset, out);
			exMx.exportExcel(headersMx, datasetMx, outMx);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// JOptionPane.showMessageDialog(null, "导出成功!");
		System.out.println("excel导出成功！");

	}

	@Override
	public PageRestful listPageUnionpayCollectionTotallRes(UnionpayCollectionTotall unionpayCollectionTotall) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<UnionpayCollectionTotall> unionpayCollectionTotalls = unionpayCollectionTotallMapper
				.listPageUnionpayCollectionTotall(unionpayCollectionTotall);
		unionpayCollectionTotalls.add(0, null);
		pageRestful.setUnionpayCollectionTotalls(unionpayCollectionTotalls);
		pageRestful.setPage(unionpayCollectionTotall.getPage());
		return pageRestful;
	}

	/**
	 * 导出银联托收文件
	 * 
	 * @param unionpayCollectionTotallId
	 * @return
	 */
	@Override
	public InputStream exportUcollectionFile(String unionpayCollectionTotallId) {
		List<UnionpayCollectionTotall> uct = unionpayCollectionTotallMapper
				.getUnionpayCollectionTotallById(unionpayCollectionTotallId);
		// 文件头
		StringBuilder sb = new StringBuilder();
		sb.append(uct.get(0).getMerchantsNum() + "|" + uct.get(0).getBatchNum() + "|" + uct.get(0).getTotalTradeNum()
				+ "|" + uct.get(0).getTotalSum() + "\r\n");
		// 文件体
		List<UnionpayCollectionDetail> ucd = unionpayCollectionDetailMapper
				.getUnionpayCollectionDetails(unionpayCollectionTotallId);
		if (ucd.size() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			for (int i = 0; i < ucd.size(); i++) {
				// UnionpayCollectionTotall uct = dataset.get(i);
				UnionpayCollectionDetail ucdl = ucd.get(i);
				sb.append(sdf.format(ucdl.getMerchantsDate()) + "|" + ucdl.getOrderNum() + "|" + ucdl.getBankNum() + "|"
						+ ucdl.getAccountType() + "|" + ucdl.getBankAccount() + "|" + ucdl.getCustName() + "|"
						+ ucdl.getCardIDType() + "|" + ucdl.getCardIDNum() + "|" + ucdl.getSum() + "|"
						+ ucdl.getPurpose() + "|" + ucdl.getPrivateDomain());
				if (i < (ucd.size() - 1)) // 如果不是最后一行，则加上换行符,如果是最后一行，则不加换行符
					sb.append("\r\n");
				// 将bill表中状态改为托收中
				// billMapper.updateBillState(ucdl.getBillId());

				Bill bill = new Bill();
				bill.setBuildingId(ucdl.getBuildingId());
				bill.setChargeTypeId(ucdl.getChargeTypeId());
				bill.setBillState(2);
				List<Bill> billList = billMapper.listAllBill(bill);
				for (Bill b : billList) {
					b.setBillState(0);// 0-托收中
					billMapper.updateBill(b);
				}

			}

			String str = sb.toString();

			InputStream in = null;
			try {
				in = new ByteArrayInputStream(str.getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return in;
		}
		return null;
	}
	

	/**
  	 * 银联修改托收状态
  	 * @author Zms
  	 * @param unionpayCollectionTotallId
  	 */
	public void updateCollectionState(String unionpayCollectionTotallId) {
		// 修改托收状态为已托收
		unionpayCollectionDetailMapper.updateCollectionState(unionpayCollectionTotallId);
		unionpayCollectionTotallMapper.updateCollectionState(unionpayCollectionTotallId);
	}

	@Override
	public InputStream exportUTotalFile(String unionpayCollectionTotallId) {
		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		// String[] headers = { "主键id", "创建时间", "项目id", "项目名称",
		// "商户号","批次号","总金额"};
		String[] headers = { "创建时间", "项目名称", "商户号", "批次号", "总金额" };
		// String[] fields =
		// {"unionpayCollectionTotallId","createDateString","projectId","projectName","merchantsNum","batchNum","totalSum"};
		String[] fields = { "createDateString", "projectName", "merchantsNum", "batchNum", "totalSum" };
		List<UnionpayCollectionTotall> dataset = unionpayCollectionTotallMapper
				.getUnionpayCollectionTotallById(unionpayCollectionTotallId);
		if (dataset.size() > 0) {
			ExcelInfo exl = new ExcelInfo();
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

	/**
	 * 银联新建托收
	 */
	@Override
	public UnionpayCollectionTotall newCollection(String projectId) {
		cancelCollection(projectId);
		UnionpayCollectionTotall uct = new UnionpayCollectionTotall();
		// int count = unionpayCollectionTotallMapper.queryCount(uct);
		uct.setCollectionType(1);
		uct.setProjectId(projectId);
		int uctotal = unionpayCollectionTotallMapper.queryCount(uct);
		if (uctotal > 0) {
			uct.setFileNames("正在托收中，请完成回盘再新建托收！");
			return uct;
		}
		// 托收状态为0的项目
		/*
		 * uct.setCollectionType(0); int typeCount =
		 * unionpayCollectionTotallMapper.queryCount(uct); if (typeCount > 0) {
		 * List<UnionpayCollectionTotall> list =
		 * unionpayCollectionTotallMapper.queryByIdAndType(uct); return
		 * list.get(0); }
		 */

		List<Bill> billList = billMapper.listUNMergeBillByProjectId(projectId);// 根据项目ID查找所有状态为空或者未抵消的账单
		UnionpayCollectionTotall unionpayCollectionTotall = new UnionpayCollectionTotall();
		String unionpayCollectionTotallId = UUID.randomUUID().toString();
		unionpayCollectionTotall.setUnionpayCollectionTotallId(unionpayCollectionTotallId);// 设置id
		// 查询托收状态为0的数据
		// List<UnionpayCollectionTotall> ftList =
		// unionpayCollectionTotallMapper.listAllUnionpay(0);

		// double countNum = 0.0;// 总金额
		long countNum = 0;

		int i = 0;
		String merchantNo = "808080201300399";// 商户号

		String batchNumber = StringUtils.leftPad(String.valueOf(unionpayCollectionTotallMapper.getBatchNum(projectId)),
				6, "0");// 批次号

		List<UnionpayCollectionDetail> UnionpayCollectionDetailList = new ArrayList<>();
		for (Bill bill : billList) {
			String buildingId = bill.getBuildingId();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");// 设置日期格式
			String createTime = df.format(new Date());// new Date()为获取当前系统时间
			// 根据建筑结构id、托收类型和当前日期查询银行托收办理信息,1-金融联,0-银联
			List<CollectionManage> cmList = collectionManageMapper.listCollectionManagebybuildingId(buildingId, "0",
					createTime);
			if (cmList.size() > 0) {
				CollectionManage cm = cmList.get(0);
				// 根据建筑结构ID查询房屋信息
				BuildingStructureNew bsn = buildingStructureNewMapper.getBuildingStructureById(buildingId);
				UnionpayCollectionDetail unionpayCollectionDetail = new UnionpayCollectionDetail();
				String uuid = UUID.randomUUID().toString();
				unionpayCollectionDetail.setUnionpayCollectionDetaiId(uuid);

				unionpayCollectionDetail.setMerchantsDate(new Date());// 商户日期

				unionpayCollectionDetail.setCustNum(cm.getCustId());// 客户号
				PersonCustNew pc = personCustNewMapper.selectCustInfoById(cm.getCustId());
				unionpayCollectionDetail.setCardIDType(pc.getCardType());// 证件类型
				unionpayCollectionDetail.setCardIDNum(pc.getCardNum());// 证件号码
				unionpayCollectionDetail.setBankAccount(cm.getBankAccount());// 银行账号
				unionpayCollectionDetail.setAccountType(cm.getAccountType());// 账号类型
				unionpayCollectionDetail.setSum((long) (bill.getNoCollectSum() * 100));// 账单金额
				countNum += (int) (bill.getNoCollectSum() * 100);
				// countNum = ArithUtils.add(countNum,
				// bill.getNoCollectSum());// 总金额
				unionpayCollectionDetail.setPrivateDomain("506");// 私有域
				unionpayCollectionDetail.setProjectId(projectId);// 项目ID
				unionpayCollectionDetail.setUnionpayCounterofferDetaiId(null);// 银联回盘明细文件id
				unionpayCollectionDetail.setUnionpayCollectionTotallId(unionpayCollectionTotallId);// 总结文件ID
				unionpayCollectionDetail.setBillId(bill.getBillId());// 应收款id
				unionpayCollectionDetail.setCustName(cm.getCustName());// 户主姓名
				unionpayCollectionDetail.setCollectionState(0);// 托收状态 0-未托收
				unionpayCollectionDetail.setBuildingId(buildingId);// 建筑结构ID
				unionpayCollectionDetail.setChargeTypeId(bill.getChargeTypeId());// 收费类型ID
				String orderNo = bill.getBillNum().substring(10);

				unionpayCollectionDetail.setOrderNum(orderNo);// 订单号
				/*
				 * if (cm.getFinancialBankNum() != null) {
				 * unionpayCollectionDetail.setBankNum(cm.getFinancialBankNum().
				 * getUnionpayBankNum());// 开户行号 }
				 */
				unionpayCollectionDetail.setBankNum(cm.getBankName());// 银行行号
				unionpayCollectionDetail.setPurpose("0");// 用途

				if (bsn != null) {
					unionpayCollectionDetail.setHouseNum(bsn.getBuildingCertificate());// 房屋编号
					unionpayCollectionDetail.setHouseAddress(bsn.getFullName());// 房屋地址
				}
				UnionpayCollectionDetailList.add(unionpayCollectionDetail);
				i++;
				unionpayCollectionDetailMapper.insertUnionpayCollectionDetail(unionpayCollectionDetail);
			}
		}
		if (i > 0) {
			Project project = projectMapper.getProject(projectId);
			unionpayCollectionTotall.setProjectId(projectId);// 项目ID
			unionpayCollectionTotall.setProjectName(project.getProjectName());// 项目名称
			unionpayCollectionTotall.setMerchantsNum(merchantNo);// 商户号 ---
																	// 不同项目不同商户号
			unionpayCollectionTotall.setBatchNum(batchNumber);
			unionpayCollectionTotall.setTotalSum(countNum);// 总金额
			unionpayCollectionTotall.setCreateTime(new Date());// 创建时间
			unionpayCollectionTotall.setTotalTradeNum(i);// 总笔数
			unionpayCollectionTotall.setCollectionType(0);// 托收状态
			// 明细文件数据
			unionpayCollectionTotall.setUnionpayCollectionDetails(UnionpayCollectionDetailList);
			unionpayCollectionTotallMapper.insertUnionpayCollectionTotall(unionpayCollectionTotall);
		} else {
			unionpayCollectionTotall.setUnionpayCollectionTotallId(null);
			unionpayCollectionTotall.setFileNames("未生成托收记录！");
		}
		return unionpayCollectionTotall;
	}

	/**
	 * 银联取消托收
	 */
	@Override
	public void cancelCollection(String projectId) {
		UnionpayCollectionTotall uct = new UnionpayCollectionTotall();
		uct.setCollectionType(0);
		uct.setProjectId(projectId);
		List<UnionpayCollectionTotall> list = unionpayCollectionTotallMapper.queryByIdAndType(uct);
		if (list.size() > 0) {
			for (UnionpayCollectionTotall u : list) {
				unionpayCollectionTotallMapper.deleteTotallById(u.getUnionpayCollectionTotallId());
				unionpayCollectionDetailMapper.deleteDetailById(u.getUnionpayCollectionTotallId());
			}
		}

	}

}