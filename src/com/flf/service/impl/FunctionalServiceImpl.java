package com.flf.service.impl;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.ComponentProperty;
import com.flf.entity.Functional;
import com.flf.entity.PageRestful;
import com.flf.mapper.FunctionalMapper;
import com.flf.service.FunctionalService;
import com.flf.util.DateUtil;

public class FunctionalServiceImpl implements FunctionalService {

	private FunctionalMapper functionalMapper;
	
	
	public FunctionalMapper getFunctionalMapper() {
		return functionalMapper;
	}

	public void setFunctionalMapper(FunctionalMapper functionalMapper) {
		this.functionalMapper = functionalMapper;
	}

	@Override
	public PageRestful listPageFunctional(Functional functional) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<Functional> functionals =functionalMapper.listPageFunctional(functional);	
		functionals.add(0,null);
		pagerestful.setFunctionals(functionals);
		pagerestful.setPage(functional.getPage());
		return pagerestful;
	}

	@Override
	public List<Functional> listFunctionalAll() {
		// TODO Auto-generated method stub
		return functionalMapper.listFunctionalAll();
	}

	@Override
	public Functional getFunctionalByIdRest(String functionalId) {
		// TODO Auto-generated method stub
		return functionalMapper.selectFunctionalById(functionalId);
	}

	@Override
	public void AddFunctional(Functional functional) {
		// TODO Auto-generated method stub
		functional.setFunctionalId(UUID.randomUUID().toString());
		//生成编号 朱琪 2016.02.23
		String number=functionalMapper.selectCustCode();		// 查询组件表中最大的组件编号
		if(number==null||number.equals("")){
			number="10000";			
		}else{
			number=String.valueOf(Integer.parseInt(number)+1);
		}
		functional.setFunctionalNo(number);
		functional.setCreaterDate(new Date());
		System.out.println(functional.getCreaterDate());
		functionalMapper.insertFunctionalUUID(functional);
	}

	@Override
	public void UpdateFunctional(Functional functional) {
		// TODO Auto-generated method stub
		functional.setUpdateDate(new Date());
		functionalMapper.updateFunctional(functional);
	}

	@Override
	public void DeleteFunctionalById(String functionalId) {
		// TODO Auto-generated method stub
		functionalMapper.deleteFunctional(functionalId);

	}

	@Override
	public int getCountByNoOrName(Functional functional){
		functional.setFunctionalNo(null);
		return functionalMapper.getCountByNoOrName(functional);
	}
}
