package com.flf.entity;

import java.util.Date;

public class ElectricityLoss {

		private Integer id;

	    private Integer level;

	    private String electricityNum;//电表编号

	    private String electricityName;//电表描述

	    private Double consumption;//用量

	    private Double childConsumption;//子表用量

	    private Double electricityLoss;//电损

	    private String lossRate;//损耗率

	    private Date meterDate;//抄表月份
	    
	    private double bootChildConsumption;//底层子级电表用量
	    
	    private Date queryDate; //电损查询日期

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getLevel() {
			return level;
		}

		public void setLevel(Integer level) {
			this.level = level;
		}

		public String getElectricityNum() {
			return electricityNum;
		}

		public void setElectricityNum(String electricityNum) {
			this.electricityNum = electricityNum;
		}

		public String getElectricityName() {
			return electricityName;
		}

		public void setElectricityName(String electricityName) {
			this.electricityName = electricityName;
		}

		public Double getConsumption() {
			return consumption;
		}

		public void setConsumption(Double consumption) {
			this.consumption = consumption;
		}

		public Double getChildConsumption() {
			return childConsumption;
		}

		public void setChildConsumption(Double childConsumption) {
			this.childConsumption = childConsumption;
		}

		public Double getElectricityLoss() {
			return electricityLoss;
		}

		public void setElectricityLoss(Double electricityLoss) {
			this.electricityLoss = electricityLoss;
		}

		public String getLossRate() {
			return lossRate;
		}

		public void setLossRate(String lossRate) {
			this.lossRate = lossRate;
		}

		public Date getMeterDate() {
			return meterDate;
		}

		public void setMeterDate(Date meterDate) {
			this.meterDate = meterDate;
		}

		public double getBootChildConsumption() {
			return bootChildConsumption;
		}

		public void setBootChildConsumption(double bootChildConsumption) {
			this.bootChildConsumption = bootChildConsumption;
		}

		public Date getQueryDate() {
			return queryDate;
		}

		public void setQueryDate(Date queryDate) {
			this.queryDate = queryDate;
		}
	    
}
