package com.flf.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.flf.entity.BuildingStructureNew;
import com.flf.entity.ChargeItemNew;
import com.flf.entity.SchemeDatails;

public interface SchemeDatailsMapper {
	/*查询所有的方案公式收费项目关系信息*/
	List<SchemeDatails> listAllSchemeDatails();
	/*分页查询方案公式收费项目关系信息*/
    List<SchemeDatails> listPageSchemeDatails(SchemeDatails schemeDatails);
    /*根据id查询方案公式收费项目关系信息*/
    SchemeDatails getSchemeDatailsById(String schemeDatailsId);
    int deleteSchemeDatails(String schemeDatailsId);
    /*新增方案公式收费项目关系信息*/
    int insertSchemeDatails(SchemeDatails schemeDatails);
    /*修改方案公式收费项目关系信息*/
    int updateSchemeDatails(SchemeDatails schemeDatails);
    
    /**
     * 根据方案id和二级收费项目id查询方案公式收费项目关联数据
     * @param map
     * @return list
     */
    List<SchemeDatails> getSchemeDatailsBySchemeIdAndchargeItemId(Map<String, String> map);
    
    /**
     * 根据方案id查询方案公式收费项目关联表中对应的建筑结构id集合
     * @param schemeId
     * @return list
     */
    List<String> getBuildingIdBySchemeId(String schemeId);
    
    /**
     * 根据收费项目id查询所有数据
     * @param chargeItemId
     * @return
     */
    List<SchemeDatails> getSchemeDatailsByChargeItemId(String chargeItemId);
    
    /**
     * 根据方案id查询建筑结构id和名字
     * @param schemeId
     * @return
     */
    List<BuildingStructureNew> getBuildingBySchemeId(String schemeId);
   
    
    List<SchemeDatails> getSchemeDatailsBySchemeId(String schemeId);
    
    //根据方案id查询
    List<SchemeDatails> getSchemeDatailsResBySchemeId(String schemeId);
    
    /**
     * 查询手动计费的方案公式收费项目集合
     * @param Map 查询条件
     * @param List<SchemeDatails> 方案公式收费项目关系集合
     * @return
     */
    List<SchemeDatails> getManualCharge(Map map);
    
    /**
     * 根据建筑收费项目ID查询方案公式收费项目集合
     * @param Map 查询条件
     * @param List<SchemeDatails> 方案公式收费项目关系集合
     * @return
     */
    List<SchemeDatails> getDatailsByBuildingBillingId(Map map);
}