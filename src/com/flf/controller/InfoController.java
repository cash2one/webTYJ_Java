package com.flf.controller;

import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.flf.entity.BuildingComponent;
import com.flf.entity.BuildingStructureSearch;
import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.Info;
import com.flf.entity.Page;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Property;
import com.flf.entity.Staff;
import com.flf.entity.UnionpayCollectionTotall;
import com.flf.mapper.UnionpayCollectionTotallMapper;
import com.flf.service.BuildingComponentService;
import com.flf.service.BuildingStructureNewService;
import com.flf.service.ElectricityMeterReadingDataService;
import com.flf.service.ElectricityMeterReadingProgramService;
import com.flf.service.ElectricityMeterService;
import com.flf.service.EnterpriseCustNewService;
import com.flf.service.FinancialGroupDetailService;
import com.flf.service.FinancialGroupTotalService;
import com.flf.service.HouseNewService;
import com.flf.service.InfoService;
import com.flf.service.MeterReadingDataService;
import com.flf.service.MeterReadingProgramService;
import com.flf.service.MeterReadingResultsService;
import com.flf.service.PersonCustNewService;
import com.flf.service.PropertyService;
import com.flf.service.StaffService;
import com.flf.service.StallNewService;
import com.flf.service.StoreNewService;
import com.flf.service.UnionpayCollectionDetailService;
import com.flf.service.UnionpayCollectionTotallService;
import com.flf.service.UnionpayCounterofferDetaiService;
import com.flf.service.UnionpayCounterofferTotalService;
import com.flf.service.WaterMeterRecordsService;
import com.flf.service.WaterMeterService;
import com.flf.util.MapUtils;

@SuppressWarnings("deprecation")
@Controller
@RequestMapping(value = "/info")
public class InfoController {

	@Autowired
	private InfoService infoService;

	@Autowired
	private HouseNewService houseNewServ;

	@Autowired
	private StallNewService stallNewServ;

	@Autowired
	private StoreNewService storeNewServ;

	@Autowired
	private UnionpayCollectionTotallService unionpayCollectionTotallService;

	@Autowired
	private UnionpayCollectionDetailService nionpayCollectionDetailService;

	@Autowired
	private UnionpayCounterofferTotalService unionpayCounterofferTotalService;

	@Autowired
	private UnionpayCounterofferDetaiService unionpayCounterofferDetaiService;

	@Autowired
	private MeterReadingProgramService meterReadingProgramService;

	@Autowired
	private ElectricityMeterReadingProgramService electricityMeterReadingProgramService;
	@Autowired
	private MeterReadingResultsService meterReadingResultsService;

	@Autowired
	private MeterReadingDataService meterReadingDataService;

	@Autowired
	private ElectricityMeterReadingDataService electricityMeterReadingDataService;

	@Autowired
	private PersonCustNewService personCustNewService;
	@Autowired
	private WaterMeterService waterMeterService;

	@Autowired
	private BuildingComponentService buildingComponentService;
	@Autowired
	private EnterpriseCustNewService enterpriseCustNewService;
	@Autowired
	private WaterMeterRecordsService waterMeterRecordsService;

	@Autowired
	private FinancialGroupTotalService financialGroupTotalService;

	@Autowired
	private FinancialGroupDetailService financialGroupDetailService;
	@Autowired
	private StaffService staffService;

	@Autowired
	private BuildingStructureNewService buildingStructureNewService;

	@Autowired
	private ElectricityMeterService electricityMeterService;

	@Autowired
	private PropertyService propertyService;

	@Autowired
	private UnionpayCollectionTotallMapper unionpayCollectionTotallMapper;

	public static Staff staff = new Staff();// 定义一个员工变量,用于查询导出数据用

	public static Property property = new Property();// 定义一个资产变量,用于查询导出数据用

	@RequestMapping
	public String info(Model model, Page page) {
		List<Info> infoList = infoService.listPageInfo(page);
		model.addAttribute("infoList", infoList);
		model.addAttribute("page", page);
		return "info";
	}

	@RequestMapping(value = "/outputExcel", method = RequestMethod.GET)
	public void outputExcel(@RequestParam("projectId") String projectId, @RequestParam("types") String types,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "";
		if (types.equals("house")) {
			excelName = "住宅记录模板.xls";// 获取excel文件名称
		} else if (types.equals("stall")) {
			excelName = "车位记录模板.xls";
		} else if (types.equals("store")) {
			excelName = "商铺记录模板.xls";
		}
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		if (types.equals("house")) {
			InputStream in = houseNewServ.exportHouseNewFile(projectId);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				outputSream.write(buf, 0, len);
			}
			in.close();
		} else if (types.equals("stall")) {
			InputStream in = stallNewServ.exportStallNewFile(projectId);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				outputSream.write(buf, 0, len);
			}
			in.close();
		} else if (types.equals("store")) {
			InputStream in = storeNewServ.exportStoreNewFile(projectId);
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				outputSream.write(buf, 0, len);
			}
			in.close();
		}
		outputSream.close();
	}

	@RequestMapping(value = "/outExcel", method = RequestMethod.GET)
	public void outExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "抄表计划.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		InputStream in = meterReadingProgramService.exportMeterReadingFile();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	@RequestMapping(value = "/outMeterReadingResultsExcel", method = RequestMethod.GET)
	public void outMeterReadingResultsExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "抄表报表.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = meterReadingResultsService.exportMeterReadingResults();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	@RequestMapping(value = "/outElectricityDataReportExcel", method = RequestMethod.GET)
	public void outElectricityDataReportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "电表数据报表.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = electricityMeterReadingDataService.exportElectricityDataReportExcel();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	@RequestMapping(value = "/outWaterDataReportExcel", method = RequestMethod.GET)
	public void outWaterDataReportExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "水表数据报表.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = meterReadingDataService.exportWaterDataReportExcel();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	@RequestMapping(value = "/outPersonCustExcel", method = RequestMethod.GET)
	public void outPersonCustExcel(HttpServletRequest request, HttpServletResponse response,
			PersonCustNew personCustNew) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "个人客户.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(excelName, "UTF8");
			excelName = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = personCustNewService.exportPersonCustNewFile(personCustNew);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	@RequestMapping(value = "/exportElectricityMeterFileExcel", method = RequestMethod.GET)
	public void exportElectricityMeterFileExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "电表导入模版.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = electricityMeterService.exportElectricityMeterFile();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	@RequestMapping(value = "/outWaterMeterExcel", method = RequestMethod.GET)
	public void outWaterMeterExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "水表导入模版.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = waterMeterService.exportWaterMeterFile();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	// 导入模板
	@RequestMapping(value = "/importExcelTemplet", method = RequestMethod.GET)
	public void importExcelTemplet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "个人客户导入模版.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(excelName, "UTF8");
			excelName = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = personCustNewService.importExcelTemplet();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	/**
	 * 建筑组件导出模板
	 */
	@RequestMapping(value = "/importExcelBuildingComponent", method = RequestMethod.GET)
	public void importExcelBuildingComponent(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "建筑组件导入模板.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream ops = response.getOutputStream();
		InputStream in = buildingComponentService.importExcelBuildingComponent();
		int length = 0;
		byte[] bytes = new byte[1024];
		while ((length = in.read(bytes, 0, 1024)) != -1) {
			ops.write(bytes, 0, length);
		}
		in.close();
		ops.close();
	}

	/**
	 * 导出企业客户 宋佳 2016-02-25
	 * 
	 * @param request
	 * @param response
	 * @param enterpriseCustNew
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportEnterperiseFile", method = RequestMethod.GET)
	public void exportEnterperiseFile(HttpServletRequest request, HttpServletResponse response,
			EnterpriseCustNew enterpriseCustNew) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "企业客户.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(excelName, "UTF8");
			excelName = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = enterpriseCustNewService.exportEnterperiseFile(enterpriseCustNew);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 企业客户导入模版下载 宋佳 2016-02-22
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/importEnterpriseExcelTemplet", method = RequestMethod.GET)
	public void importEnterpriseExcelTemplet(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String fileNames = "企业客户导入模版.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(fileNames, "UTF8");
			fileNames = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			fileNames = new String(fileNames.getBytes("UTF-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileNames));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = enterpriseCustNewService.importEnterpriseExcelTemplet();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 2015-12-22 陶勇超
	 * 
	 * @param response
	 * @throws Exception
	 *             水表管理抄表结果导入模版下载
	 */
	@RequestMapping(value = "/outMeterReadingExcel", method = RequestMethod.GET)
	public void outMeterReadingExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "抄表结果.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = meterReadingResultsService.exportMeterReading();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 2015-12-24 陶勇超
	 * 
	 * @param response
	 * @throws Exception
	 *             水表管理抄表结果导入模版下载
	 */
	@RequestMapping(value = "/outMeterRecordsExcel", method = RequestMethod.GET)
	public void outMeterRecordsExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "抄表结果详情.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = waterMeterRecordsService.exportMeterRecords();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 银联托收文件导出
	 * 
	 * @param unionpayCollectionTotallId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportUTotalFile", method = RequestMethod.GET)
	public void exportUTotalFile(@RequestParam("unionpayCollectionTotallId") String unionpayCollectionTotallId,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/plain;charset=utf-8");

		List<UnionpayCollectionTotall> uct = unionpayCollectionTotallMapper
				.getUnionpayCollectionTotallById(unionpayCollectionTotallId);
		if (uct.size() > 0) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
			String dateStr = sdf.format(new Date());

			String txtName = uct.get(0).getMerchantsNum() + "_" + dateStr + "_" + uct.get(0).getBatchNum() + "_Q.txt";

			response.setHeader("Content-Disposition",
					"attachment;filename=" + new String(txtName.getBytes("UTF-8"), "ISO8859-1"));
			OutputStream outputSream = response.getOutputStream();

			InputStream in = unionpayCollectionTotallService.exportUcollectionFile(unionpayCollectionTotallId);

			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				outputSream.write(buf, 0, len);

			}
			in.close();
			outputSream.close();
		}
	}

	// 导出盘回总结文件模版
	@RequestMapping(value = "/exportUTotalMBFile", method = RequestMethod.GET)
	public void exportUTotalMBFile(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "盘回总结文件模版.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = unionpayCounterofferTotalService.exportUTotalMBFile();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	// 银联托收文件体导出
	@RequestMapping(value = "/exportUDetailFile", method = RequestMethod.GET)
	public void exportUDetailFile(@RequestParam("unionpayCollectionTotallId") String unionpayCollectionTotallId,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "银联托收文件体.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = nionpayCollectionDetailService.exportUDetailFile(unionpayCollectionTotallId);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	// 盘回总结明细模版导出
	@RequestMapping(value = "/exportMBUDetailFile", method = RequestMethod.GET)
	public void exportMBUDetailFile(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "盘回总结明细模版.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = unionpayCounterofferDetaiService.exportMBUDetailFile();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	// 金融银行总结模版导出
	@RequestMapping(value = "/exportFTotalMBFile", method = RequestMethod.GET)
	public void exportFTotalMBFile(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "金融银行总结模版导出.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupTotalService.exportFTotalMBFile();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 金融银行总结导出TXT文件
	 * 
	 * @author maogaofei
	 * @date 2016年6月3日 下午2:27:38
	 * @param financialGroupTotalId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportTotalFileTxt", method = RequestMethod.GET)
	public void exportTotalFileTxt(@RequestParam("financialGroupTotalId") String financialGroupTotalId,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/plain;charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String dateStr = sdf.format(new Date());
		String txtName = "Header_H5100_" + dateStr + ".txt";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(txtName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupTotalService.exportTotalFileTxt(financialGroupTotalId);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 金融银行总结历史导出TXT文件
	 * 
	 * @author maogaofei
	 * @date 2016年6月3日 下午2:27:38
	 * @param financialGroupTotalId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportFTotalFileTxt", method = RequestMethod.GET)
	public void exportFTotalFileTxt(@RequestParam("financialGroupTotalId") String financialGroupTotalId,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/plain;charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String dateStr = sdf.format(new Date());
		String txtName = "Header_H5100_" + dateStr + ".txt";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(txtName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupTotalService.exportFTotalFileTxt(financialGroupTotalId);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 金融银行明细导出TXT文件
	 * 
	 * @author maogaofei
	 * @date 2016年6月3日 下午2:27:15
	 * @param financialGroupTotalId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportDetailFileTxt", method = RequestMethod.GET)
	public void exportDetailFileTxt(@RequestParam("financialGroupTotalId") String financialGroupTotalId,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/plain;charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String dateStr = sdf.format(new Date());
		String txtName = "Liners_H5100_" + dateStr + ".txt";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(txtName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupDetailService.exportDetailFileTxt(financialGroupTotalId);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 金融银行明细历史导出TXT文件
	 * 
	 * @author maogaofei
	 * @date 2016年6月3日 下午2:27:15
	 * @param financialGroupTotalId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportFDetailFileTxt", method = RequestMethod.GET)
	public void exportFDetailFileTxt(@RequestParam("financialGroupTotalId") String financialGroupTotalId,
			HttpServletResponse response) throws Exception {
		response.setContentType("text/plain;charset=utf-8");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String dateStr = sdf.format(new Date());
		String txtName = "Liners_H5100_" + dateStr + ".txt";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(txtName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupDetailService.exportFDetailFileTxt(financialGroupTotalId);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	// 金融银行总结导出
	@RequestMapping(value = "/exportFTotalFile", method = RequestMethod.GET)
	public void exportFTotalFile(@RequestParam("financialGroupTotalId") String financialGroupTotalId,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "金融银行总结.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupTotalService.exportFTotalFile(financialGroupTotalId);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	// 金融银行明细模版导出
	@RequestMapping(value = "/exportMFUDetailFile", method = RequestMethod.GET)
	public void exportMFUDetailFile(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "盘回总结明细模版.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupDetailService.exportMFUDetailFile();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	// 金融银行明细导出
	@RequestMapping(value = "/exportFDetailFile", method = RequestMethod.GET)
	public void exportFDetailFile(@RequestParam("financialGroupTotalId") String financialGroupTotalId,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "金融银行明细导出.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = financialGroupDetailService.exportFDetailFile(financialGroupTotalId);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 建筑初始化住宅、商铺、车位所有数据导出 王洲 2016.1.8
	 * 
	 * @param types
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getexportExcel", method = RequestMethod.GET)
	public void getexportExcel(@RequestParam("types") String types, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "";
		if (types.equals("house")) {
			excelName = "住宅记录.xls";// 获取excel文件名称
		} else if (types.equals("stall")) {
			excelName = "车位记录.xls";
		} else if (types.equals("store")) {
			excelName = "商铺记录.xls";
		}
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		if (types.equals("house")) {
			InputStream in = houseNewServ.exportAllHouseNew();
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				outputSream.write(buf, 0, len);
			}
			in.close();
		} else if (types.equals("stall")) {
			InputStream in = stallNewServ.exportAllStallNew();
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				outputSream.write(buf, 0, len);
			}
			in.close();
		} else if (types.equals("store")) {
			InputStream in = storeNewServ.exportAllStoreNew();
			int len = 0;
			byte[] buf = new byte[1024];
			while ((len = in.read(buf, 0, 1024)) != -1) {
				outputSream.write(buf, 0, len);
			}
			in.close();
		}
		outputSream.close();
	}

	/**
	 * 导出建筑组件所有数据 王洲 2016.1.11
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/getexportExcelBuildingComponent", method = RequestMethod.GET)
	public void getexportExcelBuildingComponent(HttpServletResponse response, BuildingComponent buildingComponent)
			throws Exception {
		// 生成文件头及文件名
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "组件数据.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		// 获取数据并写到本地
		InputStream in = buildingComponentService.createExcelBuildingComponent(buildingComponent);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	/**
	 * 员工导入模板下载 宋佳 2016.02.22
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/importStaffTemplet", method = RequestMethod.GET)
	public void importStaffTemplet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "员工导入模版.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(excelName, "UTF8");
			excelName = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = staffService.importStaffTemplet();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 员工导入模板下载 宋佳 2016.02.22
	 * 
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/exportStaffTemplet", method = RequestMethod.GET)
	public void exportStaffTemplet(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "员工导入模版.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(excelName, "UTF8");
			excelName = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = staffService.exportStaffTemplet();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/*
	 * 资产导出 朱琪 2016.02.23
	 */
	@RequestMapping(value = "/outPropertyExcel", method = RequestMethod.GET)
	public void outPropertyExcel(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "资产信息.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = propertyService.exportPropertyFile(property);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	/**
	 * 将资产信息存于变量property中,查询导出资产数据用 陈浪 2016.03.9
	 * 
	 * @param property
	 * @throws Exception
	 */
	@RequestMapping(value = "/outPropertyExcel", method = RequestMethod.POST)
	public @ResponseBody String importPropertyTemplet(HttpServletRequest request, HttpServletResponse response,
			Property propert) throws Exception {
		property = propert;
		return "{\"code\":\"100\",\"msg\":\"success\"}";
	}

	/**
	 * 资产模板下载 朱琪 2016.02.23
	 */
	@RequestMapping(value = "/importPropertyTemplet", method = RequestMethod.GET)
	public void importPropertyTemplet(HttpServletResponse response, Property property) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "资产导入模板.xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = propertyService.importPropertyTemplet();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	/**
	 * 将员工信息存于变量staff中,查询导出员工数据用 宋佳 2016.03.28
	 * 
	 * @param staff
	 * @throws Exception
	 */
	@RequestMapping(value = "/outStaffExcel", method = RequestMethod.POST)
	public @ResponseBody String outStaffExcel(HttpServletRequest request, HttpServletResponse response, Staff staf)
			throws Exception {
		staff = staf;
		return "{\"code\":\"100\",\"msg\":\"success\"}";
	}

	/**
	 * 导出员工信息 宋佳 2016.02.22
	 * 
	 * @param staff
	 * @throws Exception
	 */
	@RequestMapping(value = "/outStaffExcel", method = RequestMethod.GET)
	public void outStaffExcel(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "员工.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(excelName, "UTF8");
			excelName = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		}

		response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = staffService.exportStaffFile(staff);

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	// 金融银行总结模版导出
	@SuppressWarnings("unused")
	@RequestMapping(value = "/listBuildingStructureSearchMB", method = RequestMethod.GET)
	public void listBuildingStructureSearchMB(@RequestParam("projectId") String projectId,
			@RequestParam("fullName") String fullName, @RequestParam("name") String name,
			@RequestParam("isBindingAssets") Byte isBindingAssets, @RequestParam("num") Byte num,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "文件";
		if (num == 1) {
			excelName = "资产绑定导出文件.xls";
		} else if (num == 2) {
			excelName = "资产绑定文件模版.xls";
		}

		String name1 = new String(name.getBytes("ISO-8859-1"), "UTF-8");
		String fullName1 = new String(fullName.getBytes("ISO-8859-1"), "UTF-8");
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		BuildingStructureSearch buildingStructureSearch = new BuildingStructureSearch();
		InputStream in = buildingStructureNewService.listBuildingStructureSearchMB(projectId, fullName1, name1,
				isBindingAssets, num);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	// 住宅、商铺、车位合并为一个模板进行导出 王洲 2016.03.04
	@RequestMapping(value = "/importAllBuildingStructureByProjectId", method = RequestMethod.GET)
	public void importAllBuildingStructureByProjectId(@RequestParam("projectId") String projectId,
			HttpServletResponse response) throws Exception {

		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "";
		excelName = "住宅商铺及车位导入模板.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		InputStream in = buildingStructureNewService.importAllBuidingStructureByProjectId(projectId);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	/**
	 * 住宅、商铺、车位信息一个excel导出 王洲 2016.03.08
	 * 
	 * @param projectId
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "exportAllBuildingStructtureByProjectId", method = RequestMethod.GET)
	public void exportAllBuildingStructtureByProjectId(@RequestParam("projectId") String projectId,
			HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "住宅商铺及车位数据记录.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputStream = response.getOutputStream();
		InputStream in = buildingStructureNewService.exportAllBuildingStructtureByProjectId(projectId);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputStream.write(buf, 0, len);
		}
		in.close();
		outputStream.close();
	}

	@RequestMapping(value = "createBuildingModel", method = RequestMethod.GET)
	public void createBuildingModel(HttpServletResponse response) throws Exception {

		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "建筑结构导入模板.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputStream = response.getOutputStream();
		InputStream in = buildingStructureNewService.createBuildingModel();
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputStream.write(buf, 0, len);
		}
		in.close();
		outputStream.close();
	}

	@RequestMapping(value = "/getImportProcess", method = RequestMethod.GET)
	@ResponseBody
	public String getBuildingStructureNewProcess(String key) {
		String info = "";
		info = MapUtils.getMap().get(key);
		return info;
	}

	// 客户关联资产导出
	@RequestMapping(value = "/importExcelTempletForBuil", method = RequestMethod.GET)
	public void importExcelTempletForBuil(HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = "客户关联资产导入模版.xls";

		String agent = request.getHeader("USER-AGENT");
		if (null != agent && -1 != agent.indexOf("MSIE") || null != agent && -1 != agent.indexOf("Trident")) {// ie
			String name = java.net.URLEncoder.encode(excelName, "UTF8");
			excelName = name;
		} else if (null != agent && -1 != agent.indexOf("Mozilla")) {// 火狐,chrome等
			excelName = new String(excelName.getBytes("UTF-8"), "iso-8859-1");
		}
		response.setHeader("Content-Disposition", "attachment;filename=" + new String(excelName));
		OutputStream outputSream = response.getOutputStream();

		InputStream in = buildingStructureNewService.importExcelTemplet();

		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);
		}
		in.close();
		outputSream.close();
	}

	/**
	 * 抄表计划导出
	 * 
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value = "/outReadingProgramExcel", method = RequestMethod.GET)
	public void outReadingProgramExcel(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = request.getParameter("fileName") + ".xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		InputStream in = meterReadingProgramService.exportMeterReadingDataFile(request);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 电表计划导出
	 * 
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/outElectricityReadingProgramExcel", method = RequestMethod.GET)
	public void outElectricityReadingProgramExcel(HttpServletResponse response, HttpServletRequest request)
			throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		String excelName = request.getParameter("fileName") + ".xls";

		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		InputStream in = electricityMeterReadingProgramService.exportElectricityMeterReadingDataFile(request);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 水损列表导出
	 * 
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/outWaterLossExcel", method = RequestMethod.GET)
	public void outWaterLossExcel(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月");
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		String qwer = request.getParameter("queryDate");
		System.out.println(qwer);
		String excelName = "";
		if (request.getParameter("queryDate") == null || request.getParameter("queryDate") == "") {
			excelName = sf.format(new Date()).toString();
		} else {
			excelName = sf.format(sf1.parse(request.getParameter("queryDate"))).toString();
		}
		excelName = excelName + "水损分析.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		InputStream in = meterReadingProgramService.exportWaterLossExcel(request);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
	}

	/**
	 * 电损列表导出
	 * 
	 * @param response
	 * @param request
	 * @throws Exception
	 */
	@RequestMapping(value = "/outElectricityLossExcel", method = RequestMethod.GET)
	public void outElectricityLossExcel(HttpServletResponse response, HttpServletRequest request) throws Exception {
		response.setContentType("application/vnd.ms-excel;charset=utf-8");
		SimpleDateFormat sf = new SimpleDateFormat("yyyy年MM月");
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		String qwer = request.getParameter("queryDate");
		System.out.println(qwer);
		String excelName = "";
		if (request.getParameter("queryDate") == null || request.getParameter("queryDate") == "") {
			excelName = sf.format(new Date()).toString();
		} else {
			excelName = sf.format(sf1.parse(request.getParameter("queryDate"))).toString();
		}
		excelName = excelName + "电损分析.xls";
		response.setHeader("Content-Disposition",
				"attachment;filename=" + new String(excelName.getBytes("UTF-8"), "ISO8859-1"));
		OutputStream outputSream = response.getOutputStream();
		InputStream in = electricityMeterReadingProgramService.exportElectricityLossExcel(request);
		int len = 0;
		byte[] buf = new byte[1024];
		while ((len = in.read(buf, 0, 1024)) != -1) {
			outputSream.write(buf, 0, len);

		}
		in.close();
		outputSream.close();
		// return null;
	}

}