package com.flf.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.cxf.binding.corba.wsdl.Array;

import com.flf.entity.Gift;
import com.flf.entity.GiftArticle;
import com.flf.entity.HouseArticle;
import com.flf.entity.PageRestful;
import com.flf.mapper.GiftArticleMapper;
import com.flf.mapper.GiftMapper;
import com.flf.mapper.HouseArticleMapper;
import com.flf.service.GiftArticleService;

public class GiftArticleServiceImpl implements GiftArticleService {
	
	private GiftArticleMapper giftArticleMapper;

	private GiftMapper giftMapper;
	
	private HouseArticleMapper  houseArticleMapper;
	
	public HouseArticleMapper getHouseArticleMapper() {
		return houseArticleMapper;
	}

	public void setHouseArticleMapper(HouseArticleMapper houseArticleMapper) {
		this.houseArticleMapper = houseArticleMapper;
	}

	public GiftArticleMapper getGiftArticleMapper() {
		return giftArticleMapper;
	}

	public void setGiftArticleMapper(GiftArticleMapper giftArticleMapper) {
		this.giftArticleMapper = giftArticleMapper;
	}

	public GiftMapper getGiftMapper() {
		return giftMapper;
	}

	public void setGiftMapper(GiftMapper giftMapper) {
		this.giftMapper = giftMapper;
	}

	
	/**
	 * 礼包物品新增
	 */
	@Override
	public void insertContractRest(GiftArticle giftArticle) {
		// TODO Auto-generated method stub
		String giftuuid=UUID.randomUUID().toString();
		Gift gift =new Gift();
		gift.setGiftId(giftuuid);
		gift.setGiftName(giftArticle.getGift().getGiftName());
		gift.setGiftAmount(giftArticle.getGift().getGiftAmount());
		giftArticle.setGift(gift); 
		giftMapper.insertGift(giftArticle.getGift());		//新增礼包信息
		for (HouseArticle houseArticle : giftArticle.getHouseArticles()) {
			String houseArticlegiftuuid=UUID.randomUUID().toString();
			houseArticle.setArticleId(houseArticlegiftuuid);
			houseArticleMapper.insertHouseArticle(houseArticle);  //新增物品信息
			String giftArticlegiftuuid=UUID.randomUUID().toString();
			giftArticle.setGiftArticleId(giftArticlegiftuuid);
			giftArticle.setArticleId(houseArticlegiftuuid);
			giftArticle.setGiftId(giftuuid);
			giftArticle.setQuantity(houseArticle.getQuantity());
			giftArticleMapper.insertGiftArticle(giftArticle);   //建立礼包物品之间关系
			}
	}

	
	/**
	 * 礼包物品修改
	 */
	@Override
	public void updateContractRest(GiftArticle giftArticle) {
		//判断有id的情况
		//如果有，修改物品表，建立关系（先删后加）
		//如果没有，判断名称是否有
		//如果名称有，建立关系
		//如果名称没有，物品表新增，建立关系
		
		
		
		
		// TODO Auto-generated method stub
			giftMapper.updateGift(giftArticle.getGift());	
			//获取礼包物品关系
			List<GiftArticle> giftArticles=giftArticleMapper.listGiftArticle(giftArticle.getGift().getGiftId());
			//删除所选礼包 所有的礼包物品关系
			for (GiftArticle giftArticle1 : giftArticles) {
				giftArticleMapper.deleteGiftArticle(giftArticle1.getGiftArticleId());
			}
			List<String> a=new ArrayList<String>();
			List<String> c=new ArrayList<String>();
			List<String> d=new ArrayList<String>();
			//查询所有物品
			List<HouseArticle> houseArticles=houseArticleMapper.listAllHouseArticle();
			if(giftArticle.getHouseArticles()!=null){
				for (HouseArticle houseArticle1 : giftArticle.getHouseArticles()) {
					//判断礼包新增的物品还是修改的物品
				   if(houseArticle1.getArticleId()!=null){
					houseArticleMapper.updateHouseArticle(houseArticle1);
					String giftArticleuuid=UUID.randomUUID().toString();
					giftArticle.setGiftArticleId(giftArticleuuid);
					giftArticle.setArticleId(houseArticle1.getArticleId());
					giftArticle.setGiftId(giftArticle.getGift().getGiftId());
					giftArticle.setQuantity(houseArticle1.getQuantity());
					giftArticleMapper.insertGiftArticle(giftArticle);	
				   }else{			
					   if(houseArticle1.getArticleName()!=null){
							d.add(houseArticle1.getArticleName());	
							for (HouseArticle houseArticle : houseArticles) {
							a.add(houseArticle.getArticleId());							
							//判断数据库是否有该物品
							if(houseArticle.getArticleName()==houseArticle1.getArticleName()){		  
						    String giftArticleuuid=UUID.randomUUID().toString();
							giftArticle.setGiftArticleId(giftArticleuuid);
							giftArticle.setArticleId(houseArticle1.getArticleId());
							giftArticle.setGiftId(giftArticle.getGift().getGiftId());
							giftArticle.setQuantity(houseArticle1.getQuantity());
							giftArticleMapper.insertGiftArticle(giftArticle);
							c.add(houseArticle.getArticleName());
							}
						  }	
							}
							//获取数据库没有的物品
							  d.removeAll(c);
							 for (String x : d){
								 if(x==houseArticle1.getArticleName()){
									 	String uuid=UUID.randomUUID().toString();
									 	houseArticle1.setArticleId(uuid);
										houseArticleMapper.insertHouseArticle(houseArticle1);
										String giftArticleuuid=UUID.randomUUID().toString();
										giftArticle.setGiftArticleId(giftArticleuuid);
										giftArticle.setArticleId(houseArticle1.getArticleId());
										giftArticle.setGiftId(giftArticle.getGift().getGiftId());
										giftArticle.setQuantity(houseArticle1.getQuantity());
										giftArticleMapper.insertGiftArticle(giftArticle);	
								 							 
							 }
					  }
				   
				}
			}		
				
		}		
	}

	
	/**
	 * 根据礼包id查询物品
	 *
	 */
	@Override
	public List<GiftArticle> getGiftArticlebyGiftId(String giftId) {
		// TODO Auto-generated method stub
		return giftArticleMapper.listGiftArticle(giftId);
	}

	

}
