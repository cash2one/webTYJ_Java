package com.flf.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.AdvancePaymentsDetails;
import com.flf.entity.Annex;
import com.flf.entity.Bill;
import com.flf.entity.FinancialGroupDetail;
import com.flf.entity.PageRestful;
import com.flf.entity.TempDemo;
import com.flf.entity.UnionpayCollectionDetail;
import com.flf.entity.UnionpayCollectionTotall;
import com.flf.entity.UnionpayCounterofferDetai;
import com.flf.entity.UnionpayCounterofferTotal;
import com.flf.mapper.AdvancePaymentsDetailsMapper;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.BillMapper;
import com.flf.mapper.UnionpayCollectionDetailMapper;
import com.flf.mapper.UnionpayCollectionTotallMapper;
import com.flf.mapper.UnionpayCounterofferDetaiMapper;
import com.flf.mapper.UnionpayCounterofferTotalMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.service.UnionpayCounterofferTotalService;
import com.flf.util.ArithUtils;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

public class UnionpayCounterofferTotalServiceImpl implements UnionpayCounterofferTotalService {

	private AnnexMapper annexMapper;
	@Autowired
	private UnionpayCounterofferTotalMapper unionpayCounterofferTotalMapper;
	@Autowired
	private UnionpayCollectionTotallMapper unionpayCollectionTotallMapper;
	@Autowired
	private UnionpayCounterofferDetaiMapper unionpayCounterofferDetaiMapper;
	@Autowired
	private UnionpayCollectionDetailMapper unionpayCollectionDetailMapper;
	@Autowired
	private BillMapper billMapper;
	@Autowired
	private AdvancePaymentsDetailsMapper advancePaymentsDetailsMapper;

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public UnionpayCounterofferTotalMapper getUnionpayCounterofferTotalMapper() {
		return unionpayCounterofferTotalMapper;
	}

	public void setUnionpayCounterofferTotalMapper(UnionpayCounterofferTotalMapper unionpayCounterofferTotalMapper) {
		this.unionpayCounterofferTotalMapper = unionpayCounterofferTotalMapper;
	}

	@Override
	public int insertUnionpayCounterofferTotal(UnionpayCounterofferTotal unionpayCounterofferTotal) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<UnionpayCounterofferTotal> getUnionpayCounterofferTotalById(String unionpayCounterofferCotalId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertUnionpayCounterofferTotal1(UnionpayCounterofferTotal unionpayCounterofferTotal) {
		// TODO Auto-generated method stub
		unionpayCounterofferTotalMapper.insertUnionpayCounterofferTotal(unionpayCounterofferTotal);
	}

	@Override
	public List<UnionpayCounterofferTotal> getUnionpayCounterofferTotalById1(String unionpayCounterofferCotalId) {
		// TODO Auto-generated method stub
		return unionpayCounterofferTotalMapper.getUnionpayCounterofferTotalById(unionpayCounterofferCotalId);
	}

	@Override
	public List<UnionpayCounterofferTotal> listPageUnionpayCounterofferTotal(
			UnionpayCounterofferTotal unionpayCounterofferTotal) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PageRestful listPageUnionpayCounterofferTotalRes(UnionpayCounterofferTotal unionpayCounterofferTotal) {
		PageRestful pageRestful = new PageRestful();
		List<UnionpayCounterofferTotal> unionpayCounterofferTotals = unionpayCounterofferTotalMapper
				.listPageUnionpayCounterofferTotal(unionpayCounterofferTotal);
		unionpayCounterofferTotals.add(0, null);
		pageRestful.setUnionpayCounterofferTotals(unionpayCounterofferTotals);
		pageRestful.setPage(unionpayCounterofferTotal.getPage());
		return pageRestful;
	}

	@Override
	public Info importExcelFile(UnionpayCounterofferTotal unionpayCounterofferTotal) {
		// 1.判断总文件id是否为空
		// 2.如果为空，总文件新增，子文件新增
		// 3。如果不为空，子文件新增
		// TODO Auto-generated method stub
		List<UnionpayCounterofferTotal> unionpayCounterofferTotals = unionpayCounterofferTotal
				.getUnionpayCounterofferTotals();// 存放导入的数据
		if (unionpayCounterofferTotals != null) {
			// unionpayCounterofferTotalMapper.inserts(unionpayCounterofferTotals);
			for (UnionpayCounterofferTotal u : unionpayCounterofferTotals) {
				unionpayCounterofferTotalMapper.insertUnionpayCounterofferTotal(u);
			}
			return Tools.msg("数据导入成功!", true);
		}
		return Tools.msg("数据导入失败!", true);
	}

	@Override
	public List<UnionpayCounterofferTotal> returnImportExcelFile(Annex annex) {
		// TODO Auto-generated method stub
		/*
		 * List<UnionpayCounterofferTotal> unionpayCounterofferTotals = new
		 * ArrayList<UnionpayCounterofferTotal>();// 存放导入的数据 // SimpleDateFormat
		 * sdf = new SimpleDateFormat("yyyy-MM-dd"); String filePath =
		 * annex.getAnnexAddress();
		 * 
		 * if (Tools.notEmpty(filePath)) { try { List<Map<Short, String>>
		 * dataList = new ExcelUtils().readExcel(filePath); if (dataList != null
		 * && dataList.size() > 0) { for (Map<Short, String> t : dataList) {
		 * UnionpayCounterofferTotal unionpayCounterofferTotal = new
		 * UnionpayCounterofferTotal(); // String uuid =
		 * UUID.randomUUID().toString(); //
		 * unionpayCounterofferTotal.setUnionpayCollectionOfferDetaiId(uuid);//
		 * 设置Id unionpayCounterofferTotal.setUnionpayCounterofferCotalId(UUID.
		 * randomUUID().toString());
		 * unionpayCounterofferTotal.setFileName(t.get((short) 0)); // 文件明
		 * unionpayCounterofferTotal.setTotalTradeNum(Integer.parseInt(t.get((
		 * short) 1).trim()));// 总笔数
		 * unionpayCounterofferTotal.setTotalSum(Double.parseDouble(t.get((
		 * short) 2)));// 总金额
		 * unionpayCounterofferTotal.setSuccessTradeNum(Integer.parseInt(t.get((
		 * short) 3).trim()));// 总笔数
		 * unionpayCounterofferTotal.setSuccessSum(Double.parseDouble(t.get((
		 * short) 4)));// 成功金额 unionpayCounterofferTotal.setUpDate(new
		 * Date());// 上传日期
		 * unionpayCounterofferTotals.add(unionpayCounterofferTotal);// 将数据存入集合
		 * } }
		 * 
		 * //
		 * unionpayCounterofferTotalMapper.inserts(unionpayCounterofferTotals);
		 * 
		 * } catch (Exception e) { e.printStackTrace(); } }
		 */
		return null;
	}

	/**
	 * 盘回总结文件模版
	 * 
	 * @author xiaocong
	 * @date 下午7:18:00
	 * @Description:TODO
	 * @return
	 * @updateby
	 */
	@Override
	public InputStream exportUTotalMBFile() {
		Excel ex = new Excel();
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "文件名", "总笔数", "总金额", "成功笔数", "成功金额" };
		String[] fields = { "fileName", "totalTradeNum", "totalSum", "successTradeNum", "successSum" };
		List<UnionpayCounterofferTotal> dataset = new ArrayList<UnionpayCounterofferTotal>();
		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("盘回总结文件模版 ");
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
	 * 银联导入回盘文件
	 */
	@Override
	public Info importCollectionFile(UnionpayCollectionTotall unionpayCollectionTotall) {
		// 上传的文件名
		String unionpayFiles = unionpayCollectionTotall.getFileNames();
		// 项目ID
		String projectId = unionpayCollectionTotall.getProjectId();
		Info info = new Info();
		String msg = "";

		// 查询已托收的托收记录
		List<UnionpayCollectionTotall> uctList = unionpayCollectionTotallMapper.listAllUnionpay(projectId);

		if (uctList.size() != 1) {
			msg = "已托收的记录为空或者超过一条！";
			info.setCode("-1");
			info.setInfo(msg);
			return info;
		}
		UnionpayCollectionTotall fct = uctList.get(0);
		String batchNumber = fct.getBatchNum();

		if (unionpayFiles == null || "".equals(unionpayFiles)) {
			msg = "请选择文件上传";
			info.setCode("-1");
			info.setInfo(msg);
			return info;
		}
		// 删除未回盘状态的回盘总结文件和回盘明细文件
		deleteCounterofferByOfferstate(projectId);

		String[] files = unionpayFiles.split(",");
		Map<String, String> fileNameMap = new HashMap<String, String>();
		List<String> oldFileNameList = new ArrayList<String>();
		// List<String> newFileNameList = new ArrayList<String>();

		for (int i = 0; i < files.length; i++) {
			String fileName = files[i];
			String oldFileName = getStr(fileName, 2);
			oldFileNameList.add(oldFileName);
			// newFileNameList.add(fileName);
			fileNameMap.put(oldFileName, fileName);
		}

		for (int i = 0; i < oldFileNameList.size(); i++) {
			String oldFileName = oldFileNameList.get(i);

			String[] str = oldFileName.split("_");
			if (str.length != 4) {
				msg = "文件 " + oldFileName + "不是有效回盘文件";
				info.setCode("-1");
				info.setInfo(msg);
				return info;
			}

			// 从文件中读取的回盘标志
			String counterofferSign = oldFileName.substring(oldFileName.lastIndexOf("_") + 1, oldFileName.indexOf("."));
			if (!"P".equals(counterofferSign) || counterofferSign.length() != 1) {
				msg = "文件 " + oldFileName + "不是有效回盘文件";
				info.setCode("-1");
				info.setInfo(msg);
				return info;
			}

			try {
				// 从文件名中读取的商户号
				String merchantNum = oldFileName.substring(0, oldFileName.indexOf("_"));
				// 从文件中读取的批次号
				String batchNo = getStr(oldFileName, 2).substring(0, getStr(oldFileName, 2).indexOf("_"));
				// 从文件中读取的日期
				SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMdd");
				String date = getStr(oldFileName, 1).substring(0, getStr(oldFileName, 1).indexOf("_"));
				if (merchantNum.length() != 15 || batchNo.length() != 6 || date.length() != 8) {
					msg = "文件 " + oldFileName + "不是有效回盘文件";
					info.setCode("-1");
					info.setInfo(msg);
					return info;
				}

				// 通过项目ID和文件名称，判断文件是否已经导入过，避免重复导入数据
				UnionpayCounterofferTotal unionct = new UnionpayCounterofferTotal();
				unionct.setFileName(oldFileName);
				unionct.setProjectId(projectId);
				int num = unionpayCounterofferTotalMapper.selectFileCount(unionct);
				if (num > 0) {
					msg = "文件 " + oldFileName + " 已经导入过！";
					info.setCode("-1");
					info.setInfo(msg);
					return info;
				}

				// 查询托收是否有对应的托收数据
				UnionpayCollectionTotall union = new UnionpayCollectionTotall();
				union.setProjectId(projectId);
				union.setMerchantsNum(merchantNum);
				union.setBatchNum(batchNo);
				union.setCreateTime(formatDate.parse(date));

				List<UnionpayCollectionTotall> unionpayCTs = unionpayCollectionTotallMapper.listPageUnionpay(union);
				if (unionpayCTs.size() == 0) {
					msg = "找不到与" + oldFileName + "对应的托收记录";
					info.setCode("-1");
					info.setInfo(msg);
					return info;
				} else {
					try {
						TempDemo temp = readAndInsert(projectId, batchNo, oldFileName, fileNameMap.get(oldFileName));
						if (!temp.getBool()) {
							msg = temp.getBuff();
							info.setCode("-1");
							info.setInfo(msg);
							return info;
						}
					} catch (URISyntaxException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						msg = "文件" + oldFileName + "导入失败！";
						info.setCode("-1");
						info.setInfo(msg);
						return info;
					}
				}
			} catch (ParseException e) {
				msg = "文件 " + oldFileName + "不是有效回盘文件";
				info.setCode("-1");
				info.setInfo(msg);
				return info;
			}
		}

		info.setCode(batchNumber);
		info.setInfo(msg);
		return info;

		/*
		 * for (int i = 0; i < oldFileNameList.size(); i++) { String oldFileName
		 * = oldFileNameList.get(i); String fileNameExt =
		 * oldFileName.substring(oldFileName.lastIndexOf(".")); if
		 * (".txt".equals(fileNameExt)) {
		 * 
		 * try { TempDemo temp = readAndInsert(projectId, batchNumber,
		 * oldFileName, fileNameMap.get(oldFileName)); if (!temp.getBool()) { bl
		 * = true; sb.append(oldFileName + ","); } } catch (Exception e) { //
		 * TODO Auto-generated catch block e.printStackTrace(); bl = true;
		 * sb.append(oldFileName + ","); } } }
		 */
	}

	/**
	 * 删除未回盘状态的回盘总结文件和回盘明细文件
	 * 
	 * @param projectId
	 */
	private void deleteCounterofferByOfferstate(String projectId) {
		UnionpayCounterofferTotal uniontotal = new UnionpayCounterofferTotal();
		uniontotal.setOfferState(0);
		uniontotal.setProjectId(projectId);
		// 查找在该项目下回盘状态为0的数据，如果有则删除
		List<UnionpayCounterofferTotal> ucdd = unionpayCounterofferTotalMapper
				.listPageUnionpayCounterofferTotal(uniontotal);

		for (UnionpayCounterofferTotal fcot : ucdd) {
			UnionpayCounterofferDetai ucda = new UnionpayCounterofferDetai();
			ucda.setUnionpayCounterofferTotalId(fcot.getUnionpayCounterofferCotalId());
			List<UnionpayCounterofferDetai> ucdetail = unionpayCounterofferDetaiMapper
					.listAllgetUnionpayCounterofferDetai(ucda);

			for (UnionpayCounterofferDetai fcd : ucdetail) {
				unionpayCounterofferDetaiMapper.deleteByPrimaryKey(fcd.getUnionpayCounterofferDetaiId());
			}
			unionpayCounterofferTotalMapper.deleteByPrimaryKey(fcot.getUnionpayCounterofferCotalId());
		}
	}

	// 切分文件名的方法，取出文件名
	private static String getStr(String str, int n) {

		int i = 0;
		int s = 0;

		while (i++ < n) {
			s = str.indexOf("_", s + 1);

			if (s == -1) {
				return str;
			}
		}
		return str.substring(s + 1);

	}

	private TempDemo readAndInsert(String projectId, String batchNumber, String totalFileName, String fileName)
			throws URISyntaxException {

		TempDemo temp = new TempDemo();

		String str = getClass().getClassLoader().getResource("").toURI().getPath();
		// 获取文件路径
		String fileNamePath = "/" + str.substring(str.indexOf("/", 0) + 1, str.lastIndexOf("WEB-INF/")) + fileName;
		try {
			String encoding = "UTF-8";
			File file = new File(fileNamePath);
			if (file.isFile() && file.exists()) {
				InputStreamReader detailRead = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
				BufferedReader detailBufferedReader = new BufferedReader(detailRead);
				String detailLineTxt = null;
				int i = 0;
				int count = 0;

				UnionpayCounterofferTotal uct = new UnionpayCounterofferTotal();
				List<UnionpayCounterofferDetai> ucdList = new ArrayList<UnionpayCounterofferDetai>();
				String uuid1 = UUID.randomUUID().toString();
				uct.setUnionpayCounterofferCotalId(uuid1);
				while ((detailLineTxt = detailBufferedReader.readLine()) != null) {
					String[] arr = detailLineTxt.split("\\|");

					if ((arr.length < 10 && arr.length != 4) || arr.length > 10) {
						detailBufferedReader.close();
						detailRead.close();
						temp.setBool(false);
						temp.setBuff("文件内容不匹配！");
						return temp;
					} else if (arr.length == 10) {
						UnionpayCounterofferDetai ucd = new UnionpayCounterofferDetai();
						SimpleDateFormat data = new SimpleDateFormat("yyyyMMdd");
						String uuid = UUID.randomUUID().toString();
						ucd.setUnionpayCounterofferDetaiId(uuid);
						ucd.setBankNum(arr[0]);// 开户行号
						ucd.setTransactionDate(data.parse(arr[1]));// 交易日期
						ucd.setOrderNum(arr[2]); // 订单号
						UnionpayCollectionDetail uu = new UnionpayCollectionDetail();

						uu.setOrderNum(arr[2]);
						List<UnionpayCollectionDetail> ucdl = unionpayCollectionDetailMapper
								.listAllDetailByOrderNum(uu);
						if (ucdl.size() > 0) {
							long ucdSum = ucdl.get(0).getSum();
							if (Long.parseLong(arr[7]) != ucdSum) {
								detailBufferedReader.close();
								detailRead.close();
								temp.setBool(false);
								temp.setBuff("订单号为" + arr[2] + "的数据回盘金额与托收金额不一致！");
								return temp;
							}
						}

						ucd.setTransactionType(arr[3]);// 交易状态
						ucd.setResponseCode(arr[4]);// 响应码
						ucd.setAccountType(Integer.parseInt(arr[5]));// 卡折类型
						ucd.setAccountNum(arr[6]);// 卡折号
						ucd.setSum(Long.parseLong(arr[7]));// 金额
						ucd.setPurpose(arr[8]);// 用途
						ucd.setPrivateDomain(arr[9]);// 私有域
						ucd.setUnionpayCounterofferTotalId(uuid1);
						ucd.setOfferState(0);// 回盘状态
						ucd.setBatchNum(batchNumber);// 批次号
						ucdList.add(ucd);
						count++;
					} else if (arr.length == 4) {
						uct.setProjectId(projectId);// 项目id
						uct.setFileName(totalFileName);// 文件名称
						uct.setUpDate(new Date());// 上传时间
						uct.setTotalTradeNum(Integer.parseInt(arr[0]));// 总笔数
						uct.setTotalSum(Long.parseLong(arr[1]));// 总金额
						uct.setSuccessTradeNum(Integer.parseInt(arr[2]));// 成功笔数
						uct.setSuccessSum(Long.parseLong(arr[3].substring(0, arr[3].length() - 256)));// 成功金额
						uct.setBatchNum(batchNumber);// 批次号
						uct.setOfferState(0);// 回盘状态，0-未回盘，确认导入后改为1-已回盘
						i++;
					}

				}
				if (i > 1) {
					detailBufferedReader.close();
					detailRead.close();
					temp.setBool(false);
					temp.setBuff("总结数据内容不应超过1行！");
					return temp;
				}

				if (count != uct.getTotalTradeNum()) {
					detailBufferedReader.close();
					detailRead.close();
					temp.setBuff("总结文件中总笔数与明细笔数不对！");
					temp.setBool(false);
					return temp;
				}
				// 将回盘总文件插入数据库
				unionpayCounterofferTotalMapper.insertUnionpayCounterofferTotal(uct);
				// 将回盘明细文件插入数据库
				for (UnionpayCounterofferDetai uDetail : ucdList) {
					unionpayCounterofferDetaiMapper.insertUnionpayCounterofferDetai(uDetail);
				}
				detailBufferedReader.close();
				detailRead.close();
				temp.setBool(true);
				return temp;
			} else {
				temp.setBool(false);
				temp.setBuff("找不到指定的文件！");
				return temp;
			}
		} catch (Exception e) {
			e.printStackTrace();
			temp.setBool(false);
			temp.setBuff("读取文件内容出错！");
			return temp;
		}
	}

	/**
	 * 确认导入 zhoumingsheng
	 */
	@Override
	public Info confirmImport(UnionpayCollectionTotall unionpayCollectionTotall) {
		Info info = new Info();
		String msg = "确认导入成功！";
		List<UnionpayCollectionTotall> uctList = unionpayCollectionTotallMapper
				.listPageUnionpay(unionpayCollectionTotall);
		if (uctList.size() != 1) {
			msg = "根据项目和批次号查询托收总结记录为空或者大于1条！";
		} else {
			// 根据项目和批次获取托收的总笔数和总金额，用来判断是否回盘成功
			UnionpayCollectionTotall unct = uctList.get(0);
			int totalTradeNum = unct.getTotalTradeNum();// 总笔数

			long totalSum = unct.getTotalSum();// 总金额
			// BigDecimal b_sum = BigDecimal.valueOf(totalSum);

			// 根据项目和批次查询回盘表
			UnionpayCounterofferTotal unionpayCounterofferTotal = new UnionpayCounterofferTotal();
			unionpayCounterofferTotal.setBatchNum(unionpayCollectionTotall.getBatchNum());
			unionpayCounterofferTotal.setProjectId(unionpayCollectionTotall.getProjectId());
			List<UnionpayCounterofferTotal> uctList1 = unionpayCounterofferTotalMapper
					.listPageUnionpayCounterofferTotal(unionpayCounterofferTotal);

			if (uctList1.size() == 0) {
				msg = "文件导入失败！";
				info.setInfo(msg);
				return info;
			}

			long importNum = 0;// 导入的总笔数

			long b_importSum = 0;// 导入的总金额
			// 获取导入的总笔数和总金额，用来在导入完成以后判断是否全部回盘成功
			for (UnionpayCounterofferTotal uct : uctList1) {
				importNum = importNum + uct.getTotalTradeNum();
				b_importSum = uct.getTotalSum();
			}

			unionpayCounterofferTotal.setOfferState(0);// 未回盘
			List<UnionpayCounterofferTotal> ucdList = unionpayCounterofferTotalMapper
					.listPageUnionpayCounterofferTotal(unionpayCounterofferTotal);

			for (UnionpayCounterofferTotal ucot : ucdList) {
				UnionpayCounterofferDetai unionpayCounterofferDetai = new UnionpayCounterofferDetai();
				unionpayCounterofferDetai.setUnionpayCounterofferTotalId(ucot.getUnionpayCounterofferCotalId());
				List<UnionpayCounterofferDetai> ucodList = unionpayCounterofferDetaiMapper
						.listPagegetUnionpayCounterofferDetai(unionpayCounterofferDetai);
				// 把导入的明细回盘状态改为已回盘并核销账单
				for (UnionpayCounterofferDetai ucd : ucodList) {
					String orderNumber = ucd.getOrderNum();
					UnionpayCollectionDetail unionpayCD = new UnionpayCollectionDetail();
					unionpayCD.setOrderNum(orderNumber);
					List<UnionpayCollectionDetail> ucdl = unionpayCollectionDetailMapper
							.listAllDetailByOrderNum(unionpayCD);
					if (ucdl.size() > 0) {
						UnionpayCollectionDetail ucdetail = ucdl.get(0);
						unionpayCollectionDetailMapper.updateCollectionStateToTwo(ucdetail);
						Bill bil = new Bill();
						bil.setBuildingId(ucdetail.getBuildingId());
						bil.setChargeTypeId(ucdetail.getChargeTypeId());
						List<Bill> billList = billMapper.listAllBill(bil);
						if ("1001".equals(ucd.getTransactionType()) && "00".equals(ucd.getResponseCode())) {

							BigDecimal total_noColl = BigDecimal.valueOf(0);
							for (Bill deBill : billList) {
								total_noColl = total_noColl.add(new BigDecimal(deBill.getNoCollectSum()));
							}
							Double d_no = ArithUtils.sub(total_noColl.doubleValue(), (ucd.getSum() / 100.0));

							for (int i = 0; i < billList.size(); i++) {
								Bill bill = billList.get(i);
								bill.setCollectSum(bill.getNoCollectSum());// 实收金额
								bill.setCurrentOweSum(0.0);// 本期欠款余额
								bill.setLastOweSum(0.0);// 上期欠款余额
								if (i == 0) {
									bill.setNoCollectSum(d_no);// 未收金额
									bill.setOverdue(d_no);// 滞纳金
								} else {
									bill.setNoCollectSum(0.0);// 未收金额
									bill.setOverdue(0.0);// 滞纳金
								}
								BigDecimal zero = BigDecimal.valueOf(0);
								BigDecimal b_no = new BigDecimal(d_no);
								if (zero.compareTo(b_no) == 0) {
									bill.setBillState(1);// 1-已核销
								}
								billMapper.updateBill(bill);

								/*
								 * for (Bill b : billList) {
								 * b.setCollectSum(b.getNoCollectSum());// 实收金额
								 * b.setNoCollectSum(0.0);// 未收金额
								 * b.setCurrentOweSum(0.0);// 本期欠款余额
								 * b.setLastOweSum(0.0);// 上期欠款余额
								 * b.setOverdue(0.0);// 滞纳金 b.setBillState(1);//
								 * 1-已核销 billMapper.updateBill(b);
								 */

								AdvancePaymentsDetails apd = new AdvancePaymentsDetails();
								apd.setAdvancePaymentsDetailsId(UUID.randomUUID().toString());
								apd.setTransactionAmount(ucd.getSum());
								apd.setIsOutIn(4);
								apd.setTransactionDate(new Date());
								advancePaymentsDetailsMapper.insertAdvancePaymentsDetails(apd);
							}
						} else {
							for (Bill b : billList) {
								b.setBillState(2);// 2-未核销
								billMapper.updateBill(b);
							}
						}

						ucd.setOfferState(1);// 1-已回盘
						unionpayCounterofferDetaiMapper.updateOfferState(ucd);
					} else {
						msg = "订单号不匹配！";
						info.setInfo(msg);
						return info;
					}
				}
				ucot.setOfferState(1);// 1-已回盘
				unionpayCounterofferTotalMapper.updateOfferTotalState(ucot);
			}
			// 总笔数相同，总金额相同时，将回盘总结文件状态改为已回盘
			if ((totalTradeNum == importNum) && (totalSum == b_importSum)) {
				unct.setCollectionType(2);
				unionpayCollectionTotallMapper.updateCollectionStateTo(unct);
			}
		}
		info.setInfo(msg);
		return info;
	}
}
