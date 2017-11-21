package com.flf.mapper;

import java.util.List;

import com.flf.entity.ProjectBilling;

/**
 * @author maogaofei
 * @date 2016年7月9日 下午2:03:16
 */
public interface ProjectBillingMapper {
	//根据主键删除
    int deleteByPrimaryKey(String projectBillingId);
    //插入对象中所有字段
    int insert(ProjectBilling record);
    //根据条件插入对象字段
    int insertSelective(ProjectBilling record);
    //根据主键查询
    ProjectBilling selectByPrimaryKey(String projectBillingId);
    //根据条件修改对象属性
    int updateByPrimaryKeySelective(ProjectBilling record);
    //修改对象所有属性
    int updateByPrimaryKey(ProjectBilling record);
    /**
     * 根据条件分页查询项目计费列表
     * @author maogaofei
     * @date 2016年7月9日 下午4:13:09
     * @param projectBilling
     * @return
     */
	List<ProjectBilling> listPageProjectBilling(ProjectBilling projectBilling);
	/**
	 * 根据条件查询项目计费列表
	 * @author maogaofei
	 * @date 2016年7月15日 上午9:18:10
	 * @param projectBilling
	 * @return
	 */
	List<ProjectBilling> listAllProjectBilling(ProjectBilling projectBilling);
}