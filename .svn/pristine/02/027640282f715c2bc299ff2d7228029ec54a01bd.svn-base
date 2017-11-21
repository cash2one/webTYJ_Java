/**
 * 创建 by 肖聪   2015/6/1
 * 新租赁的mapper
 */
package com.flf.mapper;
import java.util.List;
import com.flf.entity.NewLease;
import com.flf.entity.Search;
public interface NewLeaseMapper {
	    List<NewLease> listAllNewLease(NewLease newLease);//查询所有的租赁信息也可更据条件查询
	    
	    List<NewLease> listPageNewLease(NewLease newLease);//分页查询所有的租赁信息
	   
	    List<NewLease> getNewLeaseById(String id);//根据租赁id查询该条租赁信息
	    
	    int deleteNewLease(String id);//删除租赁信息，根据状态进行逻辑删除
	    
	    int insertNewLease(NewLease newLease);//增加租赁信息
	    
	    int updateNewLease(NewLease newLease);//更新租赁信息
	    
	    List<NewLease> getNewLeaseByleasePerson(String leasePersonId);//根据租客id查询该条租赁信息

		List<NewLease> listSearchLease(Search search);//通过条件查询租赁信息

		List<NewLease> listSearchLeaseone(Search search);//通过条件查询

		List<NewLease> listSearchLeaseAu(Search search);//通过条件查询办理人和授权人的租赁信息
		
		List<NewLease> listPageListSearchLease(NewLease newLease);//分页查询客户所有租赁
		
		List<NewLease> listPagegetNewLeasesByHonseId(NewLease newLease);//根据房屋id获取租赁信息
		
		List<NewLease> listPageNewLeaseByContion(NewLease newLease);
	    
		/**
		 * 根据租客id和建筑结构id查询租赁
		 * @param leasePersonId
		 * @param houseId
		 * @return
		 */
		NewLease getNewLeaseByleasePersonIdAndHouseId(String leasePersonId, String houseId);
	    
}