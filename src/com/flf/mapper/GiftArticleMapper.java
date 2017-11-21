package com.flf.mapper;

import java.util.List;

import com.flf.entity.GiftArticle;

public interface GiftArticleMapper {

	List<GiftArticle> listAllGiftArticle();//查询所有礼包信息
    List<GiftArticle> listPageGiftArticle(GiftArticle giftArticle);//分页条件查询礼包信息
    GiftArticle getGiftArticleById(String giftArticleId); //通过礼包id查询礼包信息
    int deleteGiftArticle(String giftArticleId);//通过礼包id删除礼包信息
    int insertGiftArticle(GiftArticle giftArticle);//增加礼包信息
    int updateGiftArticle(GiftArticle giftArticle);//修改礼包信息
    
    List<GiftArticle> listGiftArticle(String giftId);//根据礼包id查询礼包物品关系
    
    int updateGiftArticleState(GiftArticle giftArticle);//修改状态
}
