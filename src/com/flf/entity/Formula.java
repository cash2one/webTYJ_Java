package com.flf.entity;



import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Formula") //公式表
public class Formula {
    private String formulaId;  // 公式id

    private String formulaName; //公式名称

    private String formulaExpression; // 公式表达式
    
    private String conditionName;//条件名称
    
    private String conditionExpression;//条件表达式
    
    private String chargeItemDetailsId;//收费项目详情ID
    
    /*自定义属性不在数据库中*/
    private String projectId;
    /*自定义属性不在数据库中 END*/

	public String getChargeItemDetailsId() {
		return chargeItemDetailsId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setChargeItemDetailsId(String chargeItemDetailsId) {
		this.chargeItemDetailsId = chargeItemDetailsId;
	}

	public String getFormulaId() {
		return formulaId;
	}

	public void setFormulaId(String formulaId) {
		this.formulaId = formulaId;
	}

	public String getFormulaName() {
		return formulaName;
	}

	public void setFormulaName(String formulaName) {
		this.formulaName = formulaName;
	}

	public String getFormulaExpression() {
		return formulaExpression;
	}

	public void setFormulaExpression(String formulaExpression) {
		this.formulaExpression = formulaExpression;
	}

	public String getConditionName() {
		return conditionName;
	}

	public void setConditionName(String conditionName) {
		this.conditionName = conditionName;
	}

	public String getConditionExpression() {
		return conditionExpression;
	}

	public void setConditionExpression(String conditionExpression) {
		this.conditionExpression = conditionExpression;
	}
    
}