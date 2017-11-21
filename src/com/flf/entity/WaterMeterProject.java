package com.flf.entity;
/* Created by Administrator on 2015/6/15. 
author:尹磊
修改时间：2015/6/15  修改人：尹磊 */
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WaterMeterProject")  //水表使用记录抄表计划关系表
public class WaterMeterProject {
    private String waterMeterProjectId;  //水表使用记录抄表计划关系id

    private String waterMeterRecordsId; //水表使用记录id

    private String readingProgramId;// 抄表计划id
    
    private String buildingStructureId; //建筑结构id

    public String getBuildingStructureId() {
		return buildingStructureId;
	}

	public void setBuildingStructureId(String buildingStructureId) {
		this.buildingStructureId = buildingStructureId;
	}

	public String getWaterMeterProjectId() {
        return waterMeterProjectId;
    }

    public void setWaterMeterProjectId(String waterMeterProjectId) {
        this.waterMeterProjectId = waterMeterProjectId;
    }

    public String getWaterMeterRecordsId() {
        return waterMeterRecordsId;
    }

    public void setWaterMeterRecordsId(String waterMeterRecordsId) {
        this.waterMeterRecordsId = waterMeterRecordsId;
    }

    public String getReadingProgramId() {
        return readingProgramId;
    }

    public void setReadingProgramId(String readingProgramId) {
        this.readingProgramId = readingProgramId;
    }
}