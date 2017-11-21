package com.flf.mapper;

import com.flf.entity.ElectricityMeterRecords;
import com.flf.entity.SearchMeter;
import com.flf.entity.WaterMeterRecords;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ElectricityMeterRecordsMapper {
	int deleteElectricityMeterRecords(String electricityMeterRecordsId);  //��ݵ��ʹ�ü�¼idɾ����Ϣ

    int insertElectricityMeterRecords(ElectricityMeterRecords electricityMeterRecords); //������ʹ�ü�¼��Ϣ

    List<ElectricityMeterRecords> listPageElectricityMeterRecords(SearchMeter searchMeter);//��ҳ��ѯ���ʹ�ü�¼��Ϣ
    
    List<ElectricityMeterRecords> listAllElectricityMeterRecords(); //��ѯ���е��ʹ�ü�¼��Ϣ

    ElectricityMeterRecords getElectricityMeterRecordsbyId(String electricityMeterRecordsId); //ͨ����ʹ�ü�¼id��ȡ���ʹ�ü�¼��Ϣ

    int updateElectricityMeterRecords(ElectricityMeterRecords electricityMeterRecords);//���µ��ʹ�ü�¼��Ϣ
    
    List<ElectricityMeterRecords> listElectricityMeterRecordsbyWaterId(
			String waterMeterNum); //根据水表编号查询水表使用记录
    
    int updateElectricityMeterRecordsbyNum(ElectricityMeterRecords electricityMeterRecords); // 停用电表
    
    ElectricityMeterRecords listElectricityMeterRecordsbybuildigIds(String buildingStructureId); //根据建筑结构id查询电表使用记录
    
    List<ElectricityMeterRecords> listElectricityMeterRecordsByElectricityMeterId(String electricityMeterId,Integer year);//根据电表ID查询电表使用记录信息
        
    List<ElectricityMeterRecords> listElectricityMeterRecordsbybuildigId(String buildingStructureId);//查询建筑下所有停用电表记录 
        
    List<ElectricityMeterRecords> listElectricityMeterRecordsByIds(String buildingStructureId);//查询建筑下所有用电表记录 

    ElectricityMeterRecords selectByBuildingStructureId(String buildingStructureId);
    
    /**
     * 电损列表第一级
     * @return
     */
    List<ElectricityMeterRecords> listPageElectricityDamage(ElectricityMeterRecords electricityMeterRecords);

    /**
	 * 根据父表标号查询子表读数总和
	 * @param waterMeterNum
	 * @param date 
	 * @return
	 */
	Double selectSumReadingByParentNum(String electricityMeterNum, Date date);

	/**
	 * 根据父表标号查询子表用量总和
	 * @param waterMeterNum
	 * @param date 
	 * @return
	 */
//	Double selectSumConsumptionByParentNum(String electricityMeterNum, Date date,String publicElectricity);
	
	Double selectSumConsumptionByParentNum(String electricityMeterNum, Date date);
	
	Double selectSumReadingByParentNum_AndIsBilling1(String electricityMeterNum, Date date);
    
	/**
	 * 根据电表使用记录id查询读数
	 * @param electricityMeterRecordsId
	 * @param date 
	 * @return
	 */
	ElectricityMeterRecords selectReadingById(String electricityMeterRecordsId, Date date);
    
	/**
	 * 电损列表第二级
	 * @param electricityMeterRecords
	 * @return
	 */
	List<ElectricityMeterRecords> listPageElectricityDamageTwo(ElectricityMeterRecords electricityMeterRecords);
	
	List<ElectricityMeterRecords> getElectricityDamage(ElectricityMeterRecords electricityMeterRecords);

	List<ElectricityMeterRecords> getElectricityDamageTwo(Map<String, Object> map);

    
    ElectricityMeterRecords selectByPrimePrimaryKey(String id);
}