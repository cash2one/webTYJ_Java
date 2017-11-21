/*
 *  创建 by 肖聪
 * 2015/6/4
 * 产权变更mapper
 */
package com.flf.mapper;
import java.util.List;
import com.flf.entity.ChangeTitle;
public interface ChangeTitleMapper {
	    List<ChangeTitle> listAllChangeTitle(ChangeTitle changeTitle);
	    List<ChangeTitle> listPageChangeTitle(ChangeTitle ChangeTitle);
	    ChangeTitle getChangeTitleById(String changeTitleId);
	    List<ChangeTitle> getChangeTitleByStallId(String stallId);
	    int deleteChangeTitle(String changeTitleId);
	    int insertChangeTitle(ChangeTitle ChangeTitle);
	    int updateChangeTitle(ChangeTitle ChangeTitle);
	    List<ChangeTitle> getHouseHistoryByCustId(String custId);//根据客户id获取房屋变更历信息
	    List<ChangeTitle> getStallHistoryByCustId(String custId);//根据客户id获取房屋变更历信息
	    List<ChangeTitle> getStoreHistoryByCustId(String custId);//根据客户id获取房屋变更历信息
}