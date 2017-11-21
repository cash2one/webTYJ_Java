package com.flf.service.impl;

import java.util.List;




import com.flf.entity.GiftArticle;
import com.flf.entity.HouseArticle;
import com.flf.entity.HouseNew;
import com.flf.entity.PageRestful;
import com.flf.entity.Intake;
import com.flf.entity.PersonCustNew;
import com.flf.entity.Search;
import com.flf.mapper.GiftArticleMapper;
import com.flf.mapper.HouseArticleMapper;
import com.flf.mapper.IntakeMapper;
import com.flf.request.HouseNewResult;
import com.flf.request.IntakeResult;
import com.flf.service.HouseNewService;
import com.flf.service.IntakeService;


public class IntakeServiceImpl implements IntakeService{
	
	private IntakeMapper intakeMapper;
	
	private GiftArticleMapper giftArticleMapper;
	
	private HouseNewService houseNewService;
	
	private HouseArticleMapper houseArticleMapper;

	public GiftArticleMapper getGiftArticleMapper() {
		return giftArticleMapper;
	}

	public void setGiftArticleMapper(GiftArticleMapper giftArticleMapper) {
		this.giftArticleMapper = giftArticleMapper;
	}

	public HouseArticleMapper getHouseArticleMapper() {
		return houseArticleMapper;
	}

	public void setHouseArticleMapper(HouseArticleMapper houseArticleMapper) {
		this.houseArticleMapper = houseArticleMapper;
	}

	public HouseNewService getHouseNewService() {
		return houseNewService;
	}

	public void setHouseNewService(HouseNewService houseNewService) {
		this.houseNewService = houseNewService;
	}

	public IntakeMapper getIntakeMapper() {
		return intakeMapper;
	}

	public void setIntakeMapper(IntakeMapper intakeMapper) {
		this.intakeMapper = intakeMapper;
	}

	/*@Override
	public List<Intake> listAllIntake() {
		// TODO Auto-generated method stub
		return intakeMapper.listAllIntake();
	}

	@Override
	public List<Intake> listPageIntake(Intake Intake) {
		// TODO Auto-generated method stub
		return intakeMapper.listPageIntake(Intake);
	}

	@Override
	public Intake getIntakeById(String id) {
		// TODO Auto-generated method stub
		return intakeMapper.getIntakeById(id);
	}

	@Override
	public int insertIntake(Intake Intake) {
		// TODO Auto-generated method stub
		return intakeMapper.insertIntake(Intake);
	}

	@Override
	public int updateIntake(Intake Intake) {
		// TODO Auto-generated method stub
		return intakeMapper.updateIntake( Intake);
	}*/

	@Override
	public PageRestful listPageIntakeRestful(Intake Intake) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		List<Intake> intakes =intakeMapper.listPageIntake(Intake);
		intakes.add(0,null);
		pagerestful.setIntakes(intakes);
		pagerestful.setPage(Intake.getPage());
		return pagerestful;
	}

	@Override
	public List<Intake> listAllIntakeRestful() {
		// TODO Auto-generated method stub
		return intakeMapper.listAllIntake();
	}

	@Override
	public Intake getIntakeByIdRestful(String id) {
		// TODO Auto-generated method stub
		return intakeMapper.getIntakeById(id);
	}

	@Override
	public void deleteIntakeRestful(String id) {
		// TODO Auto-generated method stub
		intakeMapper.deleteIntake(id);
	}

	@Override
	public void insertIntakeRestful(Intake Intake) {
		// TODO Auto-generated method stub
		intakeMapper.insertIntake(Intake);
	}

	@Override
	public void updateIntakeRestful(Intake Intake) {
		// TODO Auto-generated method stub
		intakeMapper.updateIntake( Intake);
	}  
	
	@Override
	public List<Intake>  listAllIntakeBySearch(Search search) {
		// TODO Auto-generated method stub
		return intakeMapper.listAllIntakeBySearch(search);
	}
	
	@Override
	public void insertIntakesRestful(IntakeResult intakeResult) {
		// TODO Auto-generated method stub
		for (HouseNew house : intakeResult.getHouses()) {
			houseNewService.joinGang(house.getId(),1);
			for (GiftArticle giftArticle : house.getGift().getGiftArticles()) {
				giftArticleMapper.updateGiftArticle(giftArticle);
			}
		}
		List<Intake> listIntake = intakeResult.getIntakes();
		for(Intake intake : listIntake){
			intakeMapper.insertIntake(intake);
		}
	}

	@Override
	public void insertIntakes(Intake intake) {
		// TODO Auto-generated method stub
		
	}
}
