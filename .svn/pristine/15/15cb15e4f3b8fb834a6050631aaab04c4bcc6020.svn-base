package com.flf.mapper;
import java.util.List;
import com.flf.entity.Lost;
import com.flf.entity.Search;
	    
public interface LostMapper {
	List<Lost> listAllLost();          //查询所有的遗失记录
    List<Lost> listPageLost(Lost Lost);//分页查询遗失物品记录
    Lost getLostById(String id);           //通过记录id查询遗失物品信息
    int deleteLost(String id);             //根据id删除记录
    int insertLost(Lost Lost);          //插入信息
    int updateLost(Lost Lost);           //修改信息
    List<Lost> listAllLostBySearch(Search search);//根据条件查询遗失物品信息(search.lostState=0为拾取到的物品记录，=1为遗失物品记录，=2为已领取物品记录)
    int updateLostClaim(Lost Lost);          //将遗失物品状态是指为2 表示领取
    List<Lost> listAllLostSearch(Search search);//遗失的物品的人
    List<Lost> listAllGetSearch(Search search);//领取物品的人
    List<Lost> listAllUpSearch(Search search);//捡到物品的人
    int countLostByState(Integer lostState);
}
