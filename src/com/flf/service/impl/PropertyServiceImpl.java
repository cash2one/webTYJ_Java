/**
 * @Title: PropertyServiceImpl.java
 * @Package com.flf.service.impl
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-5 上午10:15:27
 * @version V1.0
 */

package com.flf.service.impl;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.flf.entity.Annex;
import com.flf.entity.Contract;
import com.flf.entity.ContractPropertyStructure;
import com.flf.entity.Log;
import com.flf.entity.PageRestful;
import com.flf.entity.Property;
import com.flf.entity.PropertyType;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ContractPropertyStructureMapper;
import com.flf.mapper.OrderAttachmentMapper;
import com.flf.mapper.PropertyMapper;
import com.flf.mapper.PropertyTypeMapper;
import com.flf.request.ExcelInfo;
import com.flf.request.Info;
import com.flf.request.PropertyResult;
import com.flf.request.PropertyTypeResult;
import com.flf.service.LogService;
import com.flf.service.PropertyService;
import com.flf.util.Excel;
import com.flf.util.ExcelUtils;
import com.flf.util.Tools;

/**
 * @ClassName: PropertyServiceImpl
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-5 上午10:15:27
 * @author zhuwei
 * @date 2015-06-29
 */

public class PropertyServiceImpl implements PropertyService {

	private PropertyMapper propertyMapper;

	private LogService logService;

	private PropertyTypeMapper propertyTypeMapper;

	private OrderAttachmentMapper orderAttachmentMapper;

	private ContractPropertyStructureMapper contractPropertyStructureMapper;

	private AnnexMapper annexMapper;

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public PropertyTypeMapper getPropertyTypeMapper() {
		return propertyTypeMapper;
	}

	public void setPropertyTypeMapper(PropertyTypeMapper propertyTypeMapper) {
		this.propertyTypeMapper = propertyTypeMapper;
	}

	public ContractPropertyStructureMapper getContractPropertyStructureMapper() {
		return contractPropertyStructureMapper;
	}

	public void setContractPropertyStructureMapper(ContractPropertyStructureMapper contractPropertyStructureMapper) {
		this.contractPropertyStructureMapper = contractPropertyStructureMapper;
	}

	public OrderAttachmentMapper getOrderAttachmentMapper() {
		return orderAttachmentMapper;
	}

	public void setOrderAttachmentMapper(OrderAttachmentMapper orderAttachmentMapper) {
		this.orderAttachmentMapper = orderAttachmentMapper;
	}

	public PropertyMapper getPropertyMapper() {
		return propertyMapper;
	}

	public void setPropertyMapper(PropertyMapper propertyMapper) {
		this.propertyMapper = propertyMapper;
	}

	public LogService getLogService() {
		return logService;
	}

	public void setLogService(LogService logService) {
		this.logService = logService;
	}

	@Override
	public Property getPropertyByIdRest(String id) {
		// TODO Auto-generated method stub
		return propertyMapper.selectByPrimaryKey(id);
	}

	/*
	 * <p>Title: AddProperty</p> <p>Description: </p>
	 * 
	 * @param property
	 * 
	 * @see com.flf.service.PropertyService#AddProperty(com.flf.entity.Property)
	 */

	@Override
	public void AddProperty(Property property) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();// 生成UUID
		//根据id查询资产分类
		PropertyType propertyType=propertyTypeMapper.selectPropertyTypeByProperty(property.getPropertyTypeId());
		//查询资产中有没有这个分类
		
		List<Property> propertys=propertyMapper.getPropertyByparentIdRest(propertyType.getPropertyTypeId());
		//如果propertys为空，则没有从001，如果有则编号加一
		int num=1;
		if(propertys.size()==0){
			property.setPropertyNumber(propertyType.getPropertyTypeNumber()+String.format("%04d",num));
		}else{
			num=propertys.size()+1;
			property.setPropertyNumber(propertyType.getPropertyTypeNumber()+String.format("%04d",num));
		}
		
		property.setPropertyId(uuid.toString());// 主键
		if (propertyMapper.insert(property) > 0) {
			Log log = new Log();
			log.setOperation("新增");// 操作
			log.setService("资产");// 业务
			log.setRelevanceId(property.getOperator());// 操作人
			log.setTable("t_property");// 操作的表明名
			log.setRelevanceId(property.getPropertyId());// 关联id
			logService.insertLog(log);// 记录日志
		}
	}

	/*
	 * <p>Title: UpdateProperty</p> <p>Description: </p>
	 * 
	 * @param property
	 * 
	 * @see
	 * com.flf.service.PropertyService#UpdateProperty(com.flf.entity.Property)
	 */

	@Override
	public void UpdateProperty(Property property) {
		// TODO Auto-generated method stub
		if (propertyMapper.updateByPrimaryKey(property) > 0) {
			Log log = new Log();
			log.setOperation("修改");// 操作
			log.setService("资产");// 业务
			log.setRelevanceId(property.getOperator());// 操作人
			log.setTable("t_property");// 操作的表名
			log.setRelevanceId(property.getPropertyId());// 关联id
			logService.insertLog(log);// 记录日志
		}
	}

	/*
	 * <p>Title: DeletePropertyById</p> <p>Description: </p>
	 * 
	 * @param id
	 * 
	 * @see
	 * com.flf.service.PropertyService#DeletePropertyById(java.lang.Integer)
	 */

	@Override
	public void DeletePropertyById(String id) {
		// TODO Auto-generated method stub
		propertyMapper.deleteByPrimaryKey(id);

	}

	/*
	 * <p>Title: getPropertyByparentIdRest</p> <p>Description: </p>
	 * 
	 * @param parentId
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.PropertyService#getPropertyByparentIdRest(java.lang.String
	 * )
	 */

	@Override
	public List<Property> getPropertyByparentIdRest(String parentId) {
		// TODO Auto-generated method stub
		return propertyMapper.getPropertyByparentIdRest(parentId);
	}

	/*
	 * <p>Title: listProperty</p> <p>Description: </p>
	 * 
	 * @param property
	 * 
	 * @return
	 * 
	 * @see
	 * com.flf.service.PropertyService#listProperty(com.flf.entity.Property)
	 */

	@Override
	public List<Property> listProperty(Property property) {
		// TODO Auto-generated method stub
		return propertyMapper.listProperty(property);
	}

	/*
	 * <p>Title: initializeProperty</p> <p>Description: </p>
	 * 
	 * @param propertyResult
	 * 
	 * @see com.flf.service.PropertyService#initializeProperty(com.flf.request.
	 * PropertyResult)
	 */

	@Override
	public void initializeProperty(PropertyResult propertyResult) {
		// TODO Auto-generated method stub
		UUID uuid = UUID.randomUUID();
		Contract contract = propertyResult.getContract();
		contract.setId(uuid.toString());
		Log log = new Log();
		log.setOperation("新增");// 操作
		log.setService("合同初始化");// 业务
		log.setRelevanceId(contract.getOperator());// 操作人
		log.setTable("t_property");// 操作的表明名
		log.setRelevanceId(contract.getId());// 关联id
		logService.insertLog(log);// 记录日志
		List<String> propertys = propertyResult.getPropertys();// 资产id集合
		List<String> buildingStructures = propertyResult.getBuildingStructureNews();// 建筑结构id集合
		for (String property : propertys) {
			for (String buildingStructure : buildingStructures) {
				ContractPropertyStructure contractPropertyStructure = new ContractPropertyStructure();
				contractPropertyStructure.setPropertyId(property);// 资产id
				contractPropertyStructure.setContractId(contract.getId());// 合同id
				contractPropertyStructure.setBuildingStructureId(buildingStructure);// 建筑结构id
				contractPropertyStructureMapper.insertContractPropertyStructure(contractPropertyStructure);
			}
		}
		// if(propertyResult.getBase64Str()!=null &&
		// propertyResult.getFileType()!=null &&
		// "".equals(propertyResult.getBase64Str()) &&
		// "".equals(propertyResult.getFileType()))
		// {
		// BASE64Decoder decoder = new BASE64Decoder();
		// OutputStream out=null;
		// try {
		// // Base64解码
		// byte[] bytes = decoder.decodeBuffer((String)
		// propertyResult.getBase64Str());//获取map中base64加密过的字符串
		// for (int i = 0; i < bytes.length; ++i) {
		// if (bytes[i] < 0) {// 调整异常数据
		// bytes[i] += 256;
		// }
		// }
		// HttpServletRequest request =
		// ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		// String path =
		// request.getSession().getServletContext().getRealPath("/uploads");//获取uploads文件夹在服务器上的绝对路径
		// //生成jpeg图片
		// Long now = Long.parseLong(new
		// SimpleDateFormat("yyyyMMddHHmmss").format(new Date()));
		// String fileName =
		// path+"\\"+now+uuid+propertyResult.getBase64Str()+"."+propertyResult.getFileType();
		// //设置生产文件的名称和文件类型
		// out = new FileOutputStream(fileName);
		// out.write(bytes);
		// OrderAttachment orderAttachment=new OrderAttachment();
		// orderAttachment.setFilePath(fileName);//文件在服务器上的绝对路径
		// orderAttachment.setFileName(now.toString()+uuid+propertyResult.getBase64Str()+"."+propertyResult.getFileType());//文件名称
		// orderAttachment.setFileSrcType(propertyResult.getFileType());//附件类型
		// orderAttachment.setDbLastUpdSrc(propertyResult.getFileType());//获取上传文件后缀
		// orderAttachment.setProcess("合同");
		// orderAttachmentMapper.insertOrderAttachment(orderAttachment);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }finally{
		// try {
		// out.flush();
		// out.close();
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }

	}

	@Override
	public List<PropertyType> listPropertys(PropertyTypeResult propertyTypeResult) {
		Property temp = new Property();
		temp.setPropertyName("");
		PropertyTypeResult result = new PropertyTypeResult();
		result.setProperty(temp);
		List<PropertyType> listPropertyType = listPropertyByPropertyTypes(result);

		Property p = propertyTypeResult.getProperty();
		String name = p.getPropertyName();
		String brand = p.getBrand();
		String producingArea = p.getProducingArea();
		String manufacturer = p.getManufacturer();
		String parentProprety = propertyTypeResult.getPropertyTypeParent();
		String sonProprety = propertyTypeResult.getPropertyTypeSon();

		if (listPropertyType != null && listPropertyType.size() > 0) {
			if (propertyTypeResult.getPropertyTypes() != null && propertyTypeResult.getPropertyTypes().size() > 0) {
				List<PropertyType> list = new ArrayList<PropertyType>();
				for (PropertyType propertyType : propertyTypeResult.getPropertyTypes()) {
					PropertyType obj = propertyType;
					Property property = propertyTypeResult.getProperty();
					property.setPropertyTypeId(propertyType.getPropertyTypeId());
					List<Property> propertys = propertyMapper.listPropertyByParentPropertyType(property);
					obj.setPropertys(propertys);
					list.add(obj);
				}
				return list;
			} else if (Tools.notEmpty(name) || Tools.notEmpty(brand) || Tools.notEmpty(manufacturer) || Tools.notEmpty(producingArea) || Tools.notEmpty(parentProprety) || Tools.notEmpty(sonProprety)) {
				Iterator<PropertyType> it = listPropertyType.iterator();
				if (Tools.notEmpty(parentProprety)) {
					while (it.hasNext()) {
						PropertyType pt = it.next();
						if (!parentProprety.contains(pt.getPropertyTypeName())) {
							it.remove();
						}
					}

				}

				if (Tools.notEmpty(sonProprety)) {
					Iterator<PropertyType> iterator1 = listPropertyType.iterator();
					while (iterator1.hasNext()) {
						PropertyType pt = iterator1.next();
						List<PropertyType> ptList = pt.getPropertyTypes();
						if (ptList != null && ptList.size() > 0) {
							Iterator<PropertyType> ptIt = ptList.iterator();
							while (ptIt.hasNext()) {
								PropertyType son_pt = ptIt.next();
								if (son_pt != null && Tools.notEmpty(son_pt.getPropertyTypeName())) {
									if (!son_pt.getPropertyTypeName().contains(sonProprety)) {
										ptIt.remove();
									}
								}

								if (ptList.size() == 1) {
									iterator1.remove();
								}
							}
						} else {
							iterator1.remove();
						}
					}
				}

				if (Tools.notEmpty(name) || Tools.notEmpty(brand) || Tools.notEmpty(producingArea) || Tools.notEmpty(manufacturer)) {
					Iterator<PropertyType> iterator2 = listPropertyType.iterator();
					while (iterator2.hasNext()) {
						PropertyType pt = iterator2.next();
						// 获取分类集合
						List<PropertyType> ptList = pt.getPropertyTypes();
						if (ptList != null && ptList.size() > 0) {
							// 获取分类迭代器
							Iterator<PropertyType> ptIt = ptList.iterator();
							while (ptIt.hasNext()) {
								// 获取下一个分类
								PropertyType son_pt = ptIt.next();

								// 判断资产分类是否为空
								if (son_pt != null) {
									// 获取资产列表
									List<Property> pList = son_pt.getPropertys();
									if (pList != null && pList.size() > 0) {
										// 获取资产列表迭代器
										Iterator<Property> propertyIt = pList.iterator();

										while (propertyIt.hasNext()) {

											Property property = propertyIt.next();
											if (property != null) {
												if (Tools.notEmpty(name) && Tools.notEmpty(property.getPropertyName())) {
													if (!property.getPropertyName().contains(name)) {
														propertyIt.remove();
														continue;
													}
												}
												if (Tools.notEmpty(brand) && Tools.notEmpty(property.getBrand())) {
													if (!property.getBrand().contains(brand)) {
														propertyIt.remove();
														continue;
													}
												}
												if (Tools.notEmpty(producingArea) && Tools.notEmpty(property.getProducingArea())) {
													if (!property.getProducingArea().contains(producingArea)) {
														propertyIt.remove();
														continue;
													}
												}
												if (Tools.notEmpty(manufacturer) && Tools.notEmpty(property.getManufacturer())) {
													if (!property.getManufacturer().contains(manufacturer)) {
														propertyIt.remove();
														continue;
													}
												}
											}
										}
										if (pList.size() == 1 || ptList.size() == 0) {
											ptIt.remove();
											continue;
										}
									}
								}
							}
						}
						if (ptList.size() == 1 || ptList.size() == 0) {
							iterator2.remove();
						}
					}
				}
				return listPropertyType;
			} else {
				return listPropertyType;
			}
		}

		// boolean flag1 = true;
		// boolean flag2 = true;
		// boolean flag3 = true;
		// boolean flag4 = true;
		// boolean flag5 = true;
		// boolean flag6 = true;
		// Property temp = new Property();
		// temp.setPropertyName("");
		// PropertyTypeResult result = new PropertyTypeResult();
		// result.setProperty(temp);
		// List<PropertyType> listPropertyType =
		// listPropertyByPropertyTypes(result);
		// Property p = propertyTypeResult.getProperty();
		// String name = p.getPropertyName();
		// String brand = p.getBrand();
		// String producingArea = p.getProducingArea();
		// String manufacturer = p.getManufacturer();
		// String parentProprety = propertyTypeResult.getPropertyTypeParent();
		// String sonProprety = propertyTypeResult.getPropertyTypeSon();

		// if(listPropertyType!=null && listPropertyType.size()>0){
		// if(propertyTypeResult.getPropertyTypes()!=null &&
		// propertyTypeResult.getPropertyTypes().size()>0){
		// return listPropertyType;
		// }else
		// if(Tools.notEmpty(name)||Tools.notEmpty(brand)||Tools.notEmpty(manufacturer)||Tools.notEmpty(producingArea)
		// ||Tools.notEmpty(parentProprety)||Tools.notEmpty(sonProprety)){
		// for(int i=0;i<=listPropertyType.size();i++){
		// if(Tools.notEmpty(parentProprety)){
		// flag5 =
		// parentProprety.contains(listPropertyType.get(i).getPropertyTypeName());
		// }
		// if(flag5){
		// List<PropertyType> sonList =
		// listPropertyType.get(i).getPropertyTypes();
		// if(sonList!=null && sonList.size()>0){
		// sonList.remove(0);
		// for(int j=0;j< sonList.size();j++){
		// if(Tools.notEmpty(sonProprety)){
		// flag6 = sonProprety.contains(sonList.get(j).getPropertyTypeName());
		// }
		// if(flag6){
		// List<Property> pList = sonList.get(j).getPropertys();
		// if(pList!=null && pList.size()>0){
		// for(int k=0;k<=pList.size();k++){
		// if(Tools.notEmpty(name)){
		// flag1 = name.contains(pList.get(k).getPropertyName());
		// if(!flag1){
		// pList.remove(k);
		// k--;
		// break;
		// }
		// }
		// if(Tools.notEmpty(producingArea)){
		// flag2 = producingArea.contains(pList.get(k).getProducingArea());
		// if(!flag2){
		// pList.remove(k);
		// k--;
		// break;
		// }
		// }
		// if(Tools.notEmpty(brand)){
		// flag3 = brand.contains(pList.get(k).getBrand());
		// if(!flag3){
		// pList.remove(k);
		// k--;
		// break;
		// }
		// }
		// if(Tools.notEmpty(manufacturer)){
		// flag4 = manufacturer.contains(pList.get(k).getManufacturer());
		// if(!flag4){
		// pList.remove(k);
		// k--;
		// break;
		// }
		// }
		//
		// }
		// }
		// }else{
		// sonList.remove(j);
		// j--;
		// }
		// }
		// }else{
		// listPropertyType.remove(i);
		// i--;
		// }
		// }else{
		// listPropertyType.remove(i);
		// i--;
		// }
		// }
		// return listPropertyType;
		// }
		// }
		return null;
	}

	@Override
	public PageRestful listPageProperty(Property property) {
		PageRestful pagerestful = new PageRestful();
		List<Property> propertys = propertyMapper.listPageProperty(property);
		propertys.add(0, null);
		pagerestful.setPropertys(propertys);
		pagerestful.setPage(property.getPage());
		return pagerestful;
	}

	@Override
	public List<PropertyType> listPropertyByPropertyTypes(PropertyTypeResult propertyTypeResult) {
		// TODO Auto-generated method stub
		List<PropertyType> listPropertyType = new ArrayList<PropertyType>();
		// 获取专业集合
		List<PropertyType> propertyTypes = propertyTypeMapper.listParentPropertyType();
		// 遍历专业集合
		for (PropertyType propertyType : propertyTypes) {
			PropertyType obj = propertyType;
			Property property = propertyTypeResult.getProperty();
			property.setPropertyTypeId(propertyType.getPropertyTypeId());
			List<Property> propertys = propertyMapper.listPropertyByParentPropertyType(property);
			obj.setPropertys(propertys);
			// 获取分类的集合
			List<PropertyType> subPTList = propertyTypeMapper.selectByIds(propertyType.getPropertyTypeId());
			// 将分类集合set到专业对象中

			// 遍历分类集合获取资产
			if (subPTList != null && subPTList.size() > 0) {
				// 存储分类对象
				List<PropertyType> subListPropertyType = new ArrayList<PropertyType>();
				subListPropertyType.add(0, null);
				for (PropertyType pt : subPTList) {
					List<Property> pList = propertyMapper.getPropertyByparentIdRest(pt.getPropertyTypeId());
					pList.add(0, null);
					pt.setPropertys(pList);
					subListPropertyType.add(pt);
					obj.setPropertyTypes(subListPropertyType);
				}
			} else {
				obj.setPropertyTypes(subPTList);
			}
			listPropertyType.add(obj);
		}

		return listPropertyType;
	}

	@Override
	public List<Property> listPropertyAll() {
		return propertyMapper.listPropertyAll();
	}

	@Override
	public List<Property> getPropertyDataByIdRest(String id) {
		// TODO Auto-generated method stub
		return propertyMapper.selectDataByPrimaryKey(id);
	}

	/** 
     * 手机号验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isMobile(String str) {   
        Pattern p = null;  
        Matcher m = null;  
        boolean b = false;   
        p = Pattern.compile("^[1][3,4,5,8][0-9]{9}$"); // 验证手机号  
        m = p.matcher(str);  
        b = m.matches();   
        return b;  
    }  
    /** 
     * 电话号码验证 
     *  
     * @param  str 
     * @return 验证通过返回true 
     */  
    public static boolean isPhone(String str) {   
        Pattern p1 = null,p2 = null;  
        Matcher m = null;  
        boolean b = false;    
        p1 = Pattern.compile("^[0][1-9]{2,3}-[0-9]{5,10}$");  // 验证带区号的  
        p2 = Pattern.compile("^[1-9]{1}[0-9]{5,8}$");         // 验证没有区号的  
        if(str.length() >9)  
        {   m = p1.matcher(str);  
            b = m.matches();    
        }else{  
            m = p2.matcher(str);  
            b = m.matches();   
        }    
        return b;  
    }  
	
	/**
	 * 资产导入
	 * 朱琪 2016.02.23
	 */
	@Override
	public Info importExcelFileProperty(Annex annex) {
		String filePath = annex.getAnnexAddress();
		String companyId = annex.getIsMain();
		Property property = null;
		if (Tools.notEmpty(filePath)) {
			try {
				/**
				 * Bug 824 陈浪 2016.3.7
				 */
				int successNum = 0;
				
				List<Map<Short, String>> dataList = new ExcelUtils().readExcel(filePath);
				
				if (dataList != null && dataList.size() > 0) {
					List<PropertyType> list = propertyTypeMapper.listPropertyType();
					for (Map<Short, String> t : dataList) {
						property = new Property();						
						property.setPropertytypeNumber(t.get((short) 0).toString());//专业编号
						property.setPropertytypename(t.get((short) 1));//专业名
						property.setPropertytypeNumbers(t.get((short) 2).toString());//专业分类编号
						property.setPropertytypenames(t.get((short) 3));//专业分类名
						property.setPropertyId(UUID.randomUUID().toString()); // 资产id
//						property.setPropertyNumber(t.get((short) 4).toString()); // 资产编号
						property.setPropertyName(t.get((short) 4)); // 资产名称
						property.setPropertySpecification(t.get((short) 5).toString()); // 资产规格/型号
						property.setPropertySpecification(t.get((short) 6).toString()); // 使用年限
						property.setBrand(t.get((short) 7)); // 品牌
						property.setProducingArea(t.get((short) 8)); // 产地
						property.setManufacturer(t.get((short) 9)); // 厂商
						property.setManufacturerPhone(t.get((short) 10)); // 厂商电话
						
						if( !property.getPropertyName().equals(null) && !property.getPropertyName().equals("")
								&& !property.getManufacturerPhone().equals(null)&&!property.getManufacturerPhone().equals("")
								&& (isMobile(property.getManufacturerPhone())||isPhone(property.getManufacturerPhone()))){
							for (int i = 0; i < list.size(); i++) {
								PropertyType propertyType = list.get(i);
								//判断专业是否存在
								if(property.getPropertytypeNumber().equals(propertyType.getPropertyTypeNumber()) && propertyType.getParentId() == null){
									for (int j = 0; j < list.size(); j++) {
										//判断专业分类是否存在
										if (property.getPropertytypeNumbers().equals(list.get(j).getPropertyTypeNumber()) && list.get(j).getParentId() != null){
											//判断专业分类是否在对应专业下
											if (propertyType.getPropertyTypeId().equals(list.get(j).getParentId())){
												property.setPropertyTypeId(list.get(j).getPropertyTypeId());
												property.setCompanyId(companyId);
												property.setPropertyNumber(propertyType.getPropertyTypeNumber());//资产编号（专业编号）
												propertyMapper.insert(property);
												successNum ++;
											}
										}
									}
								}
							}							
						}
						
					}
						return Tools.msg("导入"+successNum+"条数据成功!"+(dataList.size()-successNum)
								+"条数据失败!", true);				
				}
			} catch (Exception e) {
				e.printStackTrace();
				/**
				 * Bug 824 陈浪 2016.3.7
				 */
				return Tools.msg("导入文件出错!", false);
			}
		}
		return Tools.msg("数据导入失败!", false);
	}

	/**
	 * 导入模板
	 * 朱琪 2016.02.23
	 */
	@Override
	public InputStream importPropertyTemplet() {
		List<Property> person = new ArrayList<Property>();
		person.add(null);
		Excel ex = new Excel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "专业编号", "专业名称", "专业分类编号", "专业分类名称", "资产名称", "规格型号","使用年限", "品牌", "产地", "厂商", "厂商电话" };
		String[] fields = { "propertytypeNumber", "propertytypename", "propertytypeNumbers", "propertytypenames", "propertyNumber", "propertyName", "propertySpecification", "brand", "producingArea",
				"manufacturer", "manufacturerPhone" };
		Property porperty = new Property();
		List<Property> dataset = propertyMapper.listPropertyType(porperty);
		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("资产导入模版");
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
	 * 导出资产
	 * 朱琪 2016.02.23
	 */
	@Override
	public InputStream exportPropertyFile(Property property) {
		List<Property> person = new ArrayList<Property>();
		person.add(null);
		Excel ex = new Excel();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<ExcelInfo> list = new ArrayList<ExcelInfo>();
		String[] headers = { "专业编号", "专业名称", "专业分类编号", "专业分类名称", "资产编号", "资产名称", "规格型号", "品牌", "产地", "厂商", "厂商电话" };
		String[] fields = { "propertytypeNumber", "propertytypename", "propertytypeNumbers", "propertytypenames", "propertyNumber", "propertyName", "propertySpecification", "brand", "producingArea",
				"manufacturer", "manufacturerPhone" };
		List<Property> dataset = propertyMapper.listPropertys(property);
		ExcelInfo exl = new ExcelInfo();
		exl.setFields(fields);
		exl.setTitles(headers);
		exl.setSheetName("资产信息");
		exl.setList(dataset);
		list.add(exl);
		try {
			return ex.createExcelInputStream(list);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
