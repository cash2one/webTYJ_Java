package com.flf.mapper;

import com.flf.entity.ElectricityMeterReadingComplaints;
import java.util.List;

public interface ElectricityMeterReadingComplaintsMapper {
	int deleteElectricityMeterReadingComplaints(String electricityMeterReadingComplaintsId);  //���ݵ��Ͷ��idɾ����Ϣ

    int insertElectricityMeterReadingComplaints(ElectricityMeterReadingComplaints electricityMeterReadingComplaints); //������Ͷ����Ϣ

    List<ElectricityMeterReadingComplaints> listPageElectricityMeterReadingComplaints(ElectricityMeterReadingComplaints electricityMeterReadingComplaints);//��ҳ��ѯ���Ͷ����Ϣ
    
    List<ElectricityMeterReadingComplaints> listAllElectricityMeterReadingComplaints(); //��ѯ���е��Ͷ����Ϣ

    ElectricityMeterReadingComplaints getElectricityMeterReadingComplaintsbyId(String electricityMeterReadingComplaintsId); //ͨ�����Ͷ��id��ȡ���Ͷ����Ϣ

    int updateElectricityMeterReadingComplaints(ElectricityMeterReadingComplaints electricityMeterReadingComplaints);//���µ��Ͷ����Ϣ
}