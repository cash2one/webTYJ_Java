package com.flf.mapper;

/*Created by Administrator on 2015/6/5. 
author:尹磊
修改时间：2015/6/5  修改人：尹磊 */

import com.flf.entity.Items;
import java.util.List;

public interface ItemsMapper {
	
	//删除物品信息
	int deleteItems(String id);

	//新增物品信息
    int insertItems(Items items);

  //分页查询所有物品信息
    List<Items> listPageItems(Items items);
    
  //查询所有物品信息
    List<Items> listAllItems();

  //根据物品id查询物品信息
    Items getItemsbyId(String id);

  //修改物品信息
    int updateItems(Items items);
    //根据放行条id获取物品信息
    List<Items> getItemsbyArticleReleaseId(String id);
    
    /**
     * 根据id查询允许放行的物品
     * @param id
     * @return
     */
    List<Items> getReleaseItemByArticleReleaseId(String id);
    
    /**
     * 根据id查询不允许放行的物品
     * @param id
     * @return
     */
    List<Items> getNotReleaseItemByArticleReleaseId(String id);
    
}