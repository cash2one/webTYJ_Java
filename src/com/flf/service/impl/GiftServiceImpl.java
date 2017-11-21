package com.flf.service.impl;

import java.util.List;

import com.flf.entity.Gift;
import com.flf.entity.GiftArticle;
import com.flf.entity.PageRestful;
import com.flf.mapper.GiftMapper;
import com.flf.service.GiftService;

public class GiftServiceImpl implements GiftService {
		private GiftMapper giftMapper;

		public GiftMapper getGiftMapper() {
			return giftMapper;
		}

		public void setGiftMapper(GiftMapper giftMapper) {
			this.giftMapper = giftMapper;
		}
		
		@Override
		public PageRestful listPageGift(Gift gift) {
			// TODO Auto-generated method stub
			PageRestful pageRestful=new PageRestful();
			List<Gift> gifts=giftMapper.listPageGift(gift);
			gifts.add(0,null);
			pageRestful.setGift(gifts);
			pageRestful.setPage(gift.getPage());
			return pageRestful;
		}
		
}
