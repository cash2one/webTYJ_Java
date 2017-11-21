package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.jws.WebService;

import com.flf.entity.Annex;
import com.flf.entity.PageRestful;
import com.flf.entity.Rules;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.RulesMapper;
import com.flf.service.RulesService;

@WebService
public class RulesServiceImpl implements RulesService {
	
	private RulesMapper rulesMapper;
	private AnnexMapper annexMapper;
	
	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public RulesMapper getRulesMapper() {
		return rulesMapper;
	}

	public void setRulesMapper(RulesMapper rulesMapper) {
		this.rulesMapper = rulesMapper;
	}
	

	@Override
	public List<Rules> listAllRules() {
		// TODO Auto-generated method stub
		return rulesMapper.listAllRules();
	}

	@Override
	public Rules getRulesByIdRest(String id) {
		// TODO Auto-generated method stub
		return rulesMapper.getRulesById(id);
	}

	@Override
	public void AddRules(Rules rules) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if( rules!= null){
			List<Annex> annexList = rules.getAnnexs();
			rules.setId(uuid);
			Integer result = rulesMapper.AddRules(rules);
			if(result>0){
				if(annexList != null && annexList.size()>0){
					for(Annex annex : annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
			}
		}
	}

	@Override
	public void UpdateRules(Rules rules) {
		// TODO Auto-generated method stub
		rulesMapper.UpdateRules(rules);
	}

	@Override
	public void DeleteRulesById(String id) {
		// TODO Auto-generated method stub
		rulesMapper.DeleteRulesById(id);
	}

	/*
	  * <p>Title: listPageRules</p>
	  * <p>Description: </p>
	  * @param rules
	  * @return
	  * @see com.flf.service.RulesService#listPageRules(com.flf.entity.Rules)
	  */
	
	
	@Override
	public PageRestful listPageRules(Rules rules) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<Rules> ruless = rulesMapper.listPageRules(rules);
		for(Rules rule:ruless){
			if(rule.getId()!=null){
				List<Annex> annexList = annexMapper.getAnnexbyRelationId(rule.getId());
				rule.setAnnexs(annexList);
			}
		}
		ruless.add(0,null);
		pageRestful.setRuless(ruless);
		pageRestful.setPage(rules.getPage());
		return pageRestful;
	}

	@Override
	public List<Rules> listAllsRules() {
		// TODO Auto-generated method stub
		return rulesMapper.listAllsRules();
	}

}
