/**
 * @Title: StallNewMapper.java
 * @Package com.flf.mapper
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-5-25 下午1:25:41
 * @version V1.0
 */

package com.flf.mapper;

import java.util.List;

import com.flf.entity.HouseNew;
import com.flf.entity.PersonBuildingNew;
import com.flf.entity.Search;
import com.flf.entity.StallNew;

/**
 * @ClassName: StallNewMapper
 * @Description: TODO
 * @author wangyong
 * @date 2015-5-25 下午1:25:41
 *
 */

public interface StallNewMapper {

	/*
	 *  车位信息表
	 */
    List<StallNew> listPageStallNew(StallNew stallNew);//分页查询显示车位信息
    List<StallNew> listAllStallNew(); //查询车位信息
    StallNew getStallNewById(String stallId);//根据id查询车位信息
    int insertStallNew(StallNew stallNew); //添加车位信息
    int updateStallNew(StallNew stallNew); //修改车位信息
    int updateStallNewType(StallNew stallNew); //修改车位类型
    int deleteStallNew(String stallId); //删除车位信息
    List<StallNew> listSearchStallNew(Search search);//物业服务搜索  
    StallNew listStallByBuildingStructureId(String buildingStructureId );  //根据建筑结构id查询车位信息
	List<StallNew> listSearchStallNewAu(Search search);//通过条件查询授权和办理人的的车位信息
	List<StallNew> listStallByPersonCustId(String personCustId);//查询客户关联车位信息
	
	 List<StallNew> listPageStallNewByType(StallNew stallNew);//通过车位类型查询车位

	 /**
	  * 根据项目id查询车位数据
	  * @param projectId
	  * @return
	  */
	 List<StallNew> listStallByProjectId(String projectId);
	 
	 /**
	  * 根据车位类型查询车位
	  * @param projectId
	  * @return
	  */
	 List<StallNew> listStallByStallType(String stallType);
	 
	 /**
	  * 根据建筑结构id修改房产证信息
	  * @author xiaocong
	  * @date 上午10:33:14
	  * @Description:TODO
	  * @param id
	  * @param buildingCertificate
	  * @updateby
	  */
	void updateStall(String id, String buildingCertificate);
	
	/**
	 * 批量插入车位信息
	 * @param list
	 * @return
	 */
	int insertList(List<StallNew> list);
	
	 /**
	  * 根据项目id分页查询车位数据
	  * @author wangzhou 
	  * date 2016-03-24
	  * @param projectId
	  * @return
	  */
	 List<StallNew> listPageStallByProjectId(StallNew stallNew);
	 /**
	  * 获取固定车位信息
	  * @author chenlang
	  * date 2016-04-25 16:25:50
	  * @param StallNew
	  * @return List<StallNew>
	  */
	 List<StallNew> listPageFixedStallNew(StallNew stallNew);
	 
	 
	 /**
	  * 根据建筑结构ID分页查询车位数据
	  * @author ylq 
	  * date 2016-07-06
	  * @param StallNew.buildingStructureId
	  * @return
	  */
	 List<StallNew> listPageStallByBuildingStructureId(StallNew stallNew);
	 /**
	  * 根据建筑结构ID获取车位
	  * @author maogaofei
	  * @date 2016年7月28日 下午2:27:43
	  * @param buildingId
	  * @return
	  */
	 StallNew getStallNewByBuildingStructureId(String buildingId);
	 /**
	  * 根据建筑结构ID获取建筑面积
	  * @author maogaofei
	  * @date 2016年7月28日 下午4:54:42
	  * @param buildingId
	  * @return
	  */
	Double getUsableAreaByBuildingStructureId(String buildingId);
	
	List<StallNew> listPageprivateStall(PersonBuildingNew personBuildingNew);
	 
}