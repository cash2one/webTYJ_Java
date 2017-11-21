package com.flf.mapper;

import java.util.List;

import com.flf.entity.ScoreSubitemItems;

public interface ScoreSubitemItemsMapper {

	int insertScoreSubitemItems(ScoreSubitemItems scoreSubitemItems);
	
	int updateScoreSubitemItems(ScoreSubitemItems ScoreSubitemItems);
	
	ScoreSubitemItems getScoreSubitemItemsbyId(String subitemId);
	
	List<ScoreSubitemItems> getScoreSubitemItemsbyCriteriaItemId(String criteriaItemId);
}
