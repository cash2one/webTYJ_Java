package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/*Created by Administrator on 2015/6/5. 
author:尹磊
修改时间：2015/6/5  修改人：尹磊 */

import com.flf.entity.ArticleRelease;
import com.flf.entity.EnterpriseCustNew;
import com.flf.entity.Items;
import com.flf.entity.PageRestful;
import com.flf.entity.Search;
import com.flf.mapper.ArticleReleaseMapper;
import com.flf.mapper.EnterpriseCustNewMapper;
import com.flf.mapper.ItemsMapper;
import com.flf.mapper.PersonCustNewMapper;
import com.flf.service.ArticleReleaseService;
import com.flf.util.JsonUtil;
import com.flf.util.JsonUtils;

import net.sf.ezmorph.object.DateMorpher;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

public class ArticleReleaseServiceImpl implements ArticleReleaseService {
	
	private ArticleReleaseMapper  articleReleaseMapper;
	
	private ItemsMapper itemsMapper;
	
	private PersonCustNewMapper personCustNewMapper;
	
	private EnterpriseCustNewMapper enterpriseCustNewMapper;

	public ArticleReleaseMapper getArticleReleaseMapper() {
		return articleReleaseMapper;
	}

	public void setArticleReleaseMapper(ArticleReleaseMapper articleReleaseMapper) {
		this.articleReleaseMapper = articleReleaseMapper;
	}
	
	public ItemsMapper getItemsMapper() {
		return itemsMapper;
	}

	public void setItemsMapper(ItemsMapper itemsMapper) {
		this.itemsMapper = itemsMapper;
	}
	
	public PersonCustNewMapper getPersonCustNewMapper() {
		return personCustNewMapper;
	}

	public void setPersonCustNewMapper(PersonCustNewMapper personCustNewMapper) {
		this.personCustNewMapper = personCustNewMapper;
	}

	public EnterpriseCustNewMapper getEnterpriseCustNewMapper() {
		return enterpriseCustNewMapper;
	}

	public void setEnterpriseCustNewMapper(EnterpriseCustNewMapper enterpriseCustNewMapper) {
		this.enterpriseCustNewMapper = enterpriseCustNewMapper;
	}

	//查询所有放行条信息
	@Override
	public List<ArticleRelease> listAllArticleRelease(Search search) {
		// TODO Auto-generated method stub
		return articleReleaseMapper.listAllArticleRelease(search);
	}
	//条件分页查询放行条信息
	@Override
	public PageRestful listPageArticleReleaseByCondition(Search search) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		//pageRestful.setArticleReleases(articleReleaseMapper.listPageArticleReleaseByCondition(search));
		//pageRestful.setPage(articleRelease.getPage());
		List<ArticleRelease> searchArticleRelease = articleReleaseMapper.listPageArticleReleaseByCondition(search);
		searchArticleRelease.add(0, null);
		pageRestful.setArticleReleases(searchArticleRelease);
		pageRestful.setPage(search.getPage());
		return pageRestful;
	}
	

	//根据id查询放行条信息
	@Override
	public ArticleRelease getUserByIdRest(String id) {
		// TODO Auto-generated method stub
		return articleReleaseMapper.getArticleReleasebyId(id);
	}

	//新增放行条信息
	@Override
	public void insertArticleReleaserest(ArticleRelease articleRelease) {
		//获取当前时间
		String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
		
		UUID uuid = UUID.randomUUID();
		articleRelease.setId(uuid.toString());
		//生成放行条编号
		String releaseCode = "FXT" + date;
		
		articleRelease.setReleaseCode(releaseCode);
		articleReleaseMapper.insertArticleRelease(articleRelease);
		List<Items> items=articleRelease.getItem();
		if(items!=null){
			for(Items item:items){
				item.setReleaseId(uuid.toString());
				itemsMapper.insertItems(item);
			}
		}
		
	}

	//修改放行条信息
	@Override
	public void updateArticleReleaserest(ArticleRelease articleRelease) {
		// TODO Auto-generated method stub
		articleReleaseMapper.updateArticleRelease(articleRelease);
	}

	//删除放行条信息
	@Override
	public void deleteArticleReleaserest(String id) {
		// TODO Auto-generated method stub
		articleReleaseMapper.deleteArticleRelease(id);
	}

	@Override
	public List<ArticleRelease> listAllArticleReleaseByPersonId(String personId) {
		// TODO Auto-generated method stub
		List<ArticleRelease> aaa=articleReleaseMapper.listAllArticleReleaseByPersonId(personId);
		return aaa;
	}

	@Override
	public PageRestful listPageArticleReleaseByPersonId(ArticleRelease articleRelease) {
		PageRestful pageRestful = new PageRestful();
		List<ArticleRelease> list_ar = articleReleaseMapper.listPageArticleReleaseByPersonId(articleRelease);
		list_ar.add(0, null);
		pageRestful.setArticleReleases(list_ar);
		pageRestful.setPage(articleRelease.getPage());
		return pageRestful;
	}

	@Override
	public PageRestful listPageArticleReleaseByContion(
			ArticleRelease articleRelease) {
		// TODO Auto-generated method stub
		PageRestful pageRestful = new PageRestful();
		List<ArticleRelease> list_ar = articleReleaseMapper.listPageArticleReleaseByContion(articleRelease);
		list_ar.add(0, null);
		pageRestful.setArticleReleases(list_ar);
		pageRestful.setPage(articleRelease.getPage());
		return pageRestful;
	}

	@Override
	public String addArticleRelease(String jsonStr) {
		try {
			Map<String, Object> classMap = new HashMap<String, Object>();
			classMap.put("releaseItem", Items.class);
			classMap.put("notReleaseItem", Items.class);
			String[] dateFormats = new String[] {"yyyy-MM-dd HH:mm"};
			JSONUtils.getMorpherRegistry().registerMorpher(new DateMorpher(dateFormats));
			ArticleRelease articleRelease = (ArticleRelease) JSONObject.toBean(JSONObject.fromObject(jsonStr), ArticleRelease.class, classMap);
			String articleReleaseId = UUID.randomUUID().toString();
			articleRelease.setId(articleReleaseId);
			//获取当前时间
			String date = new SimpleDateFormat("yyyyMMddHHmmss").format(new Date());
			//生成放行条编号
			String releaseCode = "FXT" + date;
			articleRelease.setReleaseCode(releaseCode);
			articleRelease.setApplyTime(new Date());
			articleReleaseMapper.insertArticleRelease(articleRelease);
			//添加放行的物品
			for (Items item : articleRelease.getReleaseItem()) {
				item.setReleaseId(articleReleaseId);
				item.setContaitState(1);
				itemsMapper.insertItems(item);
			}//添加不放行的物品
			for (Items item : articleRelease.getNotReleaseItem()) {
				item.setReleaseId(articleReleaseId);
				item.setContaitState(0);
				itemsMapper.insertItems(item);
			}
			return "success";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";
		}
		
	}

	@Override
	public String getArticleReleaseByCustIdList(List<String> custIdList) {
		List<ArticleRelease> articleReleaseList = articleReleaseMapper.getArticleReleaseByCustIdList(custIdList);
		if(articleReleaseList != null && articleReleaseList.size() > 0){
			for (ArticleRelease articleRelease : articleReleaseList) {
				if(articleRelease.getCustomerType() == 0){//个人客户
					articleRelease.setCustName(personCustNewMapper.getPersonCustNewById(articleRelease.getCustId()).getName());
				} else {
					articleRelease.setCustName(personCustNewMapper.getPersonCustNewById(articleRelease.getCustId()).getName());
				}
			}
			String[] property = {"custName","houseName","releaseTime","releaseTimeEnd","releaseCode","releaseItem","notReleaseItem"};
			return JsonUtils.toJsonStringFilterProperty(articleReleaseList, ArticleRelease.class, property);
		}
		return null;
	}

	@Override
	public String getArticleReleaseByBuildingStructure(String buildingStructureId) {
		List<ArticleRelease> articleReleaseList = articleReleaseMapper.getArticleReleaseByBuildingStructure(buildingStructureId);
		if(articleReleaseList != null && articleReleaseList.size() > 0){
			String[] property = {"custName","houseName","releaseTime","releaseTimeEnd","releaseCode","releaseItem","notReleaseItem"};
			return JsonUtils.toJsonStringFilterProperty(articleReleaseList, ArticleRelease.class, property);
		} else {
			return null;
		}
	}
	
}
