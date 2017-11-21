package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.ScoreCriteria;
import com.flf.entity.ScoreCriteriaItems;
import com.flf.entity.ScoreSubitemItems;
import com.flf.mapper.ScoreCriteriaItemsMapper;
import com.flf.mapper.ScoreCriteriaMapper;
import com.flf.mapper.ScoreSubitemItemsMapper;
import com.flf.service.ScoreCriteriaService;

public class ScoreCriteriaServiceImpl implements ScoreCriteriaService{

	private ScoreCriteriaMapper scoreCriteriaMapper;
	private ScoreSubitemItemsMapper scoreSubitemItemsMapper;
	private ScoreCriteriaItemsMapper scoreCriteriaItemsMapper;
	
	public ScoreSubitemItemsMapper getScoreSubitemItemsMapper() {
		return scoreSubitemItemsMapper;
	}

	public void setScoreSubitemItemsMapper(
			ScoreSubitemItemsMapper scoreSubitemItemsMapper) {
		this.scoreSubitemItemsMapper = scoreSubitemItemsMapper;
	}

	public ScoreCriteriaItemsMapper getScoreCriteriaItemsMapper() {
		return scoreCriteriaItemsMapper;
	}

	public void setScoreCriteriaItemsMapper(
			ScoreCriteriaItemsMapper scoreCriteriaItemsMapper) {
		this.scoreCriteriaItemsMapper = scoreCriteriaItemsMapper;
	}

	public ScoreCriteriaMapper getScoreCriteriaMapper() {
		return scoreCriteriaMapper;
	}

	public void setScoreCriteriaMapper(ScoreCriteriaMapper scoreCriteriaMapper) {
		this.scoreCriteriaMapper = scoreCriteriaMapper;
	}

	@Override
	public ScoreCriteria getScoreCriteriabyId(String criteriaId) {
		// TODO Auto-generated method stub
		return scoreCriteriaMapper.getScoreCriteriabyId(criteriaId);
	}

	
	@Override
	public void insertScoreCriteria(ScoreCriteria scoreCriteria) {
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(new Date());
		List<ScoreCriteriaItems> criteriaItems = scoreCriteria.getScoreCriteriaItemsList();
		
		if(scoreCriteria != null){
			scoreCriteria.setCriteriaId(uuid);
			scoreCriteria.setCreateTime(date);
			Integer result = scoreCriteriaMapper.insertScoreCriteriaUUID(scoreCriteria);
			if(result>0 && criteriaItems != null && criteriaItems.size()>0){
				for(ScoreCriteriaItems sci : criteriaItems){
					String criteriaItemsUUID = UUID.randomUUID().toString();
					sci.setCriteriaId(uuid);
					sci.setCriteriaItemId(criteriaItemsUUID);
					Integer result1 = scoreCriteriaItemsMapper.insertScoreCriteriaItemsUUID(sci);
					List<ScoreSubitemItems> subitemItems = sci.getScoreSubitemItemsList();
					if(result1>0 && subitemItems!=null && subitemItems.size()>0){
						for(ScoreSubitemItems ssi : subitemItems){
							ssi.setCriteriaItemId(criteriaItemsUUID);
							scoreSubitemItemsMapper.insertScoreSubitemItems(ssi);
						}
					}
				}
			}
		}
		return;
	}

	@Override
	public void updateScoreCriteria(ScoreCriteria scoreCriteria) {
		// TODO Auto-generated method stub
		scoreCriteriaMapper.updateScoreCriteria(scoreCriteria);
	}

	@Override
	public List<ScoreCriteria> getScoreCriteriabyType(String criteriabyType) {
		// TODO Auto-generated method stub
		return scoreCriteriaMapper.getScoreCriteriabyType(criteriabyType);
	}

	@Override
	public ScoreCriteria getScoreCriteriaDetailedbyId(String criteriaId) {
		// TODO Auto-generated method stub
		
		if(criteriaId != null && !"".equals(criteriaId)){
			
			List<ScoreCriteriaItems> scoreCriteriaItemsList = new ArrayList<ScoreCriteriaItems>();
			scoreCriteriaItemsList.add(null);
			ScoreCriteria sc = scoreCriteriaMapper.getScoreCriteriabyId(criteriaId);
			
			if(sc != null){
				List<ScoreCriteriaItems> sciList = scoreCriteriaItemsMapper.getScoreCriteriaItemsbyCriteriaId(criteriaId);
				if(sciList != null && sciList.size()>0){
					for(ScoreCriteriaItems sci : sciList){
						List<ScoreSubitemItems> ssiList = scoreSubitemItemsMapper.getScoreSubitemItemsbyCriteriaItemId(sci.getCriteriaItemId());
						if(ssiList!=null && ssiList.size()==1){
							ssiList.add(null);
						}
						sci.setScoreSubitemItemsList(ssiList);
						scoreCriteriaItemsList.add(sci);
					}
					sc.setScoreCriteriaItemsList(scoreCriteriaItemsList);
					return sc;
				}
			}
		}
		return null;
	}

}
