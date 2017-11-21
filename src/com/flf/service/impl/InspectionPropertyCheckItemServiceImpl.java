package com.flf.service.impl;

import java.util.List;

import com.flf.entity.InspectionPropertyCheckItem;
import com.flf.mapper.InspectionPropertyCheckItemMapper;
import com.flf.service.InspectionPropertyCheckItemService;

public class InspectionPropertyCheckItemServiceImpl implements InspectionPropertyCheckItemService{
	public InspectionPropertyCheckItemMapper getInspectionPropertyCheckItemMapper() {
		return inspectionPropertyCheckItemMapper;
	}
	public void setInspectionPropertyCheckItemMapper(
			InspectionPropertyCheckItemMapper inspectionPropertyCheckItemMapper) {
		this.inspectionPropertyCheckItemMapper = inspectionPropertyCheckItemMapper;
	}
	private InspectionPropertyCheckItemMapper inspectionPropertyCheckItemMapper;
	@Override
	public List<InspectionPropertyCheckItem> selectInspectionPropertyCheckItem(
			String inspectionPlanId) {
		// TODO Auto-generated method stub
		return inspectionPropertyCheckItemMapper.selectInspectionPropertyCheckItem(inspectionPlanId);
	}

}
