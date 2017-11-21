package com.flf.entity;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 包含方案表对象、常量表对象、条件表对象、公式表对象、
 * 方案收费项目关系表对象及方案公式收费项目关系表对象
 * 用于新增方案时封装前台传入的多对象参数，可用于查询方案时封装方案所有数据
 * @author wangzhou
 *
 */
@XmlRootElement(name="AboutScheme")
public class AboutScheme {
	
	//方案表对象
	private Scheme scheme;
	
	//常量表对象
	private List<Constant> constantList;
	
	//方案收费项目关系表
	private List<SchemeRelation> schemeRelation;
	
	//方案公式收费项目关系表
	private List<SchemeDatails> schemeDetails;
	
	//收费项目表
	private List<ChargeItemNew> chargeItemNewList;
	
	//条件表
	private List<Condition> condtionList;
	
	//公式表
	private List<Formula> formulaList;

	public Scheme getScheme() {
		return scheme;
	}

	public void setScheme(Scheme scheme) {
		this.scheme = scheme;
	}

	public List<Constant> getConstantList() {
		return constantList;
	}

	public void setConstantList(List<Constant> constantList) {
		this.constantList = constantList;
	}

	public List<SchemeRelation> getSchemeRelation() {
		return schemeRelation;
	}

	public void setSchemeRelation(List<SchemeRelation> schemeRelation) {
		this.schemeRelation = schemeRelation;
	}

	public List<SchemeDatails> getSchemeDetails() {
		return schemeDetails;
	}

	public void setSchemeDetails(List<SchemeDatails> schemeDetails) {
		this.schemeDetails = schemeDetails;
	}
	
	public List<ChargeItemNew> getChargeItemNewList() {
		return chargeItemNewList;
	}

	public void setChargeItemNewList(List<ChargeItemNew> chargeItemNewList) {
		this.chargeItemNewList = chargeItemNewList;
	}

	public List<Condition> getCondtionList() {
		return condtionList;
	}

	public void setCondtionList(List<Condition> condtionList) {
		this.condtionList = condtionList;
	}

	public List<Formula> getFormulaList() {
		return formulaList;
	}

	public void setFormulaList(List<Formula> formulaList) {
		this.formulaList = formulaList;
	}

}
