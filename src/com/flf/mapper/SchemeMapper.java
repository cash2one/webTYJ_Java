package com.flf.mapper;

import java.util.List;

import com.flf.entity.Scheme;

/**
 * @author maogaofei
 * @date 2016年6月29日 下午3:03:02
 */
public interface SchemeMapper {
	//根据主键删除
    int deleteByPrimaryKey(String schemeId);
    //插入对象中所有字段
    int insert(Scheme record);
    //根据条件插入对象字段
    int insertSelective(Scheme record);
    //根据主键查询
    Scheme selectByPrimaryKey(String schemeId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(Scheme record);
    //修改对象所有属性
    int updateByPrimaryKey(Scheme record);
    /**
     * 根据项目ID查询所有的计费方案列表
     * @author maogaofei
     * @date 2016年6月29日 下午3:05:43
     * @param projectId
     * @return
     */
    List<Scheme> getSchemeByProjectId(String projectId);
	List<Scheme> getSchemeByChargeTypeId(String chargeTypeId);
	/**
	 * 获取当前可用的手动计费方法列表
	 * @author maogaofei
	 * @date 2016年7月11日 下午2:42:28
	 * @return
	 */
	List<Scheme> getManualSchemeList(String nowDateStr,String projectId);
	/**
	 * 根据条件查询所有的计费方案
	 * @author maogaofei
	 * @date 2016年7月12日 下午6:51:22
	 * @param sm
	 * @return
	 */
	List<Scheme> listAllScheme(Scheme sm);
	/**
	 * 获取当前可用的自动计费方法列表
	 * @author maogaofei
	 * @date 2016年7月13日 上午3:28:45
	 * @param nowDateStr
	 * @return
	 */
	List<Scheme> getAutoSchemeList(String nowDateStr);
}