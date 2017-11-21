package com.flf.entity;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 内部专业线_假期管理(实体类)
 * 
 * @author 阮枚星
 * 
 * @createDate:2015-05-26
 * 
 * @修改时间:2015-05-28
 */
@XmlRootElement(name = "Vacation")
public class Vacation implements Serializable {

	/**
	 * 序列号
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 主键id
	 */
	private Integer id;

	/**
	 * 假期名称
	 */
	private String vacationName;

	/**
	 * 分页
	 */
	private Page page;

	/**
	 * 假期开始时间
	 */
	private @DateTimeFormat(pattern = "yyyy-mm-dd")
	Date vacationStartDate;

	/**
	 * 假期结束时间
	 */
	private @DateTimeFormat(pattern = "yyyy-mm-dd")
	Date vacationEndDate;

	/**
	 * 假期天数
	 */
	private Integer dayCount;

	/**
	 * 假期信息状态,1为正常,0为删除
	 */
	private Boolean state;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVacationName() {
		return vacationName;
	}

	public void setVacationName(String vacationName) {
		this.vacationName = vacationName;
	}

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public Date getVacationStartDate() {
		return vacationStartDate;
	}

	public void setVacationStartDate(Date vacationStartDate) {
		this.vacationStartDate = vacationStartDate;
	}

	public Date getVacationEndDate() {
		return vacationEndDate;
	}

	public void setVacationEndDate(Date vacationEndDate) {
		this.vacationEndDate = vacationEndDate;
	}

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	public Boolean getState() {
		return state;
	}

	public void setState(Boolean state) {
		this.state = state;
	}

	/**
	 * 默认的构造方法
	 */
	public Vacation() {
		super();
	}
}
