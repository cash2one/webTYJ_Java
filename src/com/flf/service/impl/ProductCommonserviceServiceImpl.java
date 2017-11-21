package com.flf.service.impl;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;

import com.flf.entity.Annex;
import com.flf.entity.AreaDivision;
import com.flf.entity.BuildingStructureNew;
import com.flf.entity.DataDictionarySlave;
import com.flf.entity.PageRestful;
import com.flf.entity.Product;
import com.flf.entity.ProductBs;
import com.flf.entity.ProductCommonservice;
import com.flf.entity.ServiceProject;
import com.flf.entity.StallNew;
import com.flf.entity.Project;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.AreaDivisionMapper;
import com.flf.mapper.BuildingStructureNewMapper;
import com.flf.mapper.ProductBsMapper;
import com.flf.mapper.ProductCommonserviceMapper;
import com.flf.mapper.ProductMapper;
import com.flf.mapper.ProjectMapper;
import com.flf.mapper.ServiceProjectMapper;
import com.flf.mapper.StallNewMapper;
import com.flf.request.FixedParkingSpace;
import com.flf.request.Info;
import com.flf.service.ProductCommonserviceService;
import com.flf.service.ProductService;
import com.flf.util.Tools;

import net.sf.json.JSONObject;

/**
 * 产品模块后台接口实现类
 * 
 * @author hanyupeng
 * 
 */
public class ProductCommonserviceServiceImpl implements ProductCommonserviceService {
	Map<String,String> map=new HashMap<String,String>();
	private ProductCommonserviceMapper productCommonserviceMapper;
	
	public ProductCommonserviceMapper getProductCommonserviceMapper() {
		return productCommonserviceMapper;
	}

	public void setProductCommonserviceMapper(ProductCommonserviceMapper productCommonserviceMapper) {
		this.productCommonserviceMapper = productCommonserviceMapper;
	}
	@Autowired
	private ProjectMapper projectMapper;
	@Override
	public String addProductCommon(ProductCommonservice productCommon) {
		String name=productCommon.getCommonserviceName();
		ProductCommonservice _name;
		_name=productCommonserviceMapper.selectByName(name);
		if(_name!=null){
			String EndDate=_name.getProductEndDate();
			if(EndDate!=null){
			EndDate=EndDate.replace("-",""); 
			Date now = new Date(); 
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
			String dt = dateFormat.format(now);
			int a=Integer.parseInt(EndDate);
			int b=Integer.parseInt(dt);
			if(a>=b){
			map.put("code","0");
		    return JSONObject.fromObject(map).toString();
			}
			else{
				String productCommonserviceid = UUID.randomUUID().toString();
				// 设置产品类型
				String projectId=productCommon.getCommonserviceId();
				productCommon.setProductType("6");
				// 设置产品id
				productCommon.setCommonserviceId(productCommonserviceid);
				//设置产品编号
				String areaCode="440300";
				String divideCode=productCommon.getProductServicetype();
				String productTypeNumber="001";
				String serialNumber=getMaxCode();
				String pce=getProductNumber(areaCode, projectId, divideCode, productTypeNumber, serialNumber);

				pce=pce.substring(9,pce.length()-2);
				productCommon.setProductCode(pce);
				productCommonserviceMapper.insert(productCommon);
				map.put("code","1");
			    return JSONObject.fromObject(map).toString();
			}
			}
			else{
				map.put("code","0");
			    return JSONObject.fromObject(map).toString();
			}
		}
		else{
		String productCommonserviceid = UUID.randomUUID().toString();
		// 设置产品类型
		String projectId=productCommon.getCommonserviceId();
		productCommon.setProductType("6");
		// 设置产品id
		productCommon.setCommonserviceId(productCommonserviceid);
		//设置产品编号
		String areaCode="440300";
		String divideCode=productCommon.getProductServicetype();
		String productTypeNumber="001";
		String serialNumber=getMaxCode();
		String pce=getProductNumber(areaCode, projectId, divideCode, productTypeNumber, serialNumber);

		pce=pce.substring(9,pce.length()-2);
		productCommon.setProductCode(pce);
		productCommonserviceMapper.insert(productCommon);
		map.put("code","1");
	    return JSONObject.fromObject(map).toString();
		}
	}

	@Override//生成产品编号BEGIN——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	public String getProductNumber(String areaCode, String projectId, String divideCode, String productTypeNumber,String serialNumber) {		
		//判断字符是否为空
		if(areaCode!=null&&projectId!=null&&divideCode!=null&&productTypeNumber!=null&&serialNumber!=null)
		{
			String projectNumber=getProjectNumberById(projectId);
			if(projectNumber==null){//判断用户Id是否找到项目号
				map.put("code","无法通过此Id找到项目号");
				return JSONObject.fromObject(map).toString();
			}
			else{
				if(isNumeric(areaCode+divideCode+productTypeNumber+serialNumber)){//判断字符是否为数字
					map.put("code","无法转换非数字字符");
					return JSONObject.fromObject(map).toString();
				}
				else{
				//对正确字符进行处理		
				areaCode=getFiveNumber(areaCode);//得到5位地区码
				projectNumber=getFiveNumber(projectNumber);//得到5位项目号
				divideCode=getTwoNumber(divideCode);
				productTypeNumber=getThreeNumber(productTypeNumber);//得到3位业务类型编号
				serialNumber=getFiveNumber(serialNumber);//得到5位的自然码
				int _serialNumber=Integer.parseInt(serialNumber);
				_serialNumber++;//获得的是最后一位自然码，所以下一位自然码要加1
				serialNumber=Integer.toString(_serialNumber);
				serialNumber=getFiveNumber(serialNumber);//转int会清除前面的0，所以要获得5位自然码
				String productNumber=areaCode+projectNumber+divideCode+productTypeNumber+getNowDate()+serialNumber;//对字段进行拼接
				map.put("code",productNumber);
			    return JSONObject.fromObject(map).toString();}//返回正确的产品编号
			}
		}
		else{//空字符处理
			map.put("code","不可以传入空字符");
			return JSONObject.fromObject(map).toString();
		}
	}
	private boolean isNumeric(String str){//判断是否为数字函数    是 返回false   否返回true
		  for (int i = 0; i < str.length(); i++){
		   System.out.println(str.charAt(i));
		   if (!Character.isDigit(str.charAt(i))){
		    return true;
		   }
		  }
		  return false;
	}
	private String getTwoNumber(String Number){//得到一个2位数
		for(int i=Number.length();i<2;i++){//小于2处理
			Number="0"+Number;
		}
		if(Number.length()>2){//大于2处理
			Number=Number.substring(Number.length()-2,Number.length());
		}
		return Number;
		
	}
	private String getThreeNumber(String Number){//得到一个3位数
		
		for(int i=Number.length();i<3;i++){//小于3处理
			Number="0"+Number;
		}
		if(Number.length()>3){//大于3处理
			Number=Number.substring(Number.length()-3,Number.length());
		}
		return Number;
	}
	private String getFiveNumber(String Number){//得到一个5位数
	
			for(int i=Number.length();i<5;i++){//小于5处理
				Number="0"+Number;
			}
			if(Number.length()>5){//大于5处理
				Number=Number.substring(0,5);
			}
		return Number;
	}
	private String getNowDate(){//得到当前时间
		Date now = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMM");
		String dt = dateFormat.format(now); 
		return dt;
	}
	private String getProjectNumberById(String projectId){//得到项目编码
		Project pro=new Project();
		pro=projectMapper.getProjectJson(projectId);
		return pro.getProjectNumber();
	}//生成产品编号END——————————————————————————————————————————————————————————————————————————————————————————————————————————————
	//获取普通服务产品编号max BEGIN
	private String getMaxCode(){
		String mc="";
		try
		{
			mc=productCommonserviceMapper.selectMaxCode().getProductCode();	
			return mc;
		}
		catch(Exception e){
			mc="0";
			return mc;
			}
	}
	//获取普通服务产品编号max END
	@Override
	public String checkProduct(String productId) {
		ProductCommonservice pce=new ProductCommonservice();
		pce=productCommonserviceMapper.selectByPrimaryKey(productId);
		return JSONObject.fromObject(pce).toString();
	}

	@Override
	public String updateProduct(ProductCommonservice productCommon) {
		productCommonserviceMapper.updateByPrimaryKey(productCommon);
		return null;
	}
	
	@Override
	public List<ProductCommonservice> getProductCommonListByType(String Type){
		List<ProductCommonservice> productCommonservice = productCommonserviceMapper.getProductCommonByType(Type);
		return productCommonservice;
	}

}
