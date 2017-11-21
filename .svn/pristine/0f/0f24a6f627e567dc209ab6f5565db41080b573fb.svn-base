package com.flf.mapper;

import java.util.List;

import com.flf.entity.Vacation;

/**
 * 内部专业线_ 假期管理(映射类)
 * 
 * @author 阮枚星
 * 
 * @createDate:2015-05-26
 * 
 */
public interface VacationMapper {
	/**
	 * 获取所有假期管理信息
	 * 
	 * @param Vacation
	 *            假期管理对象
	 * @return 返回假期管理对象集合
	 */
	public List<Vacation> getAllVacation(Vacation aacation);

	/**
	 * 根据id获取管理对象
	 * 
	 * @param id
	 *            假期id
	 * @return 返回假期对象
	 */
	public Vacation getVacationById(Integer id);

	/**
	 * 根据假期名称模糊查询假期信息
	 * 
	 * @param VacationName
	 *            假期名称
	 * @return 返回假期管理对象集合
	 */
	public List<Vacation> getVacationByName(String VacationName);

	/**
	 * 修改假期管理信息
	 * 
	 * @param Vacation
	 *            假期对象信息
	 */
	public void editVacation(Vacation Vacation);

	/**
	 * 根据假期id删除假期对象信息
	 * 
	 * @param id
	 *            假期id
	 */
	public void delVacationById(Integer id);

	/**
	 * 增加假期信息
	 * 
	 * @param holiday
	 *            假期对象信息
	 */
	public void addVacation(Vacation vacation);

	/**
	 * 
	 * getVacation(获取所有假期信息)
	 * 
	 * @Title: getVacation
	 * @Description: TODO
	 * @param @return 设定文件
	 * @return List<Vacation> 假期对象信息
	 * @throws
	 */
	public List<Vacation> getVacation();
}
