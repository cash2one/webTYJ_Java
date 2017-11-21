package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.flf.entity.Annex;
import com.flf.entity.PraiseOrders;
import com.flf.entity.PraiseStaff;
import com.flf.entity.TasksJournal;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.PraiseOrdersMapper;
import com.flf.mapper.PraiseStaffMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.service.PraiseOrdersService;

/**
 * 
 * @author fansensen
 *	最后更改时间：2015-08-19
 */
public class PraiseOrdersServiceImpl implements PraiseOrdersService {

	private PraiseOrdersMapper praiseOrdersMapper;//表扬单mapper接口
	private TasksJournalMapper tasksJournalMapper;
	private AnnexMapper annexMapper;
	private PraiseStaffMapper praiseStaffMapper;
	
	public PraiseStaffMapper getPraiseStaffMapper() {
		return praiseStaffMapper;
	}

	public void setPraiseStaffMapper(PraiseStaffMapper praiseStaffMapper) {
		this.praiseStaffMapper = praiseStaffMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public PraiseOrdersMapper getPraiseOrdersMapper() {
		return praiseOrdersMapper;
	}

	public void setPraiseOrdersMapper(PraiseOrdersMapper praiseOrdersMapper) {
		this.praiseOrdersMapper = praiseOrdersMapper;
	}

	@Override
	public List<PraiseOrders> listAllPraiseOrder() {
		// TODO Auto-generated method stub
		return praiseOrdersMapper.listAllPraiseOrder();
	}

	@Override
	public PraiseOrders getPraiseOrderById(String id) {
		// TODO Auto-generated method stub
		return praiseOrdersMapper.getPraiseOrderById(id);
	}

	@Override
	public int insertPraiseOrder(PraiseOrders order) {
		// TODO Auto-generated method stub
		return praiseOrdersMapper.insertPraiseOrder(order);
	}

	@Override
	public int deletePraiseOrder(String id) {
		// TODO Auto-generated method stub
		return praiseOrdersMapper.deletePraiseOrder(id);
	}

	@Override
	public int updatePraiseOrder(PraiseOrders order) {
		// TODO Auto-generated method stub
		return praiseOrdersMapper.updatePraiseOrder(order);
	}


	@Override
	public void addPraiseOrder(PraiseOrders order) {
		// TODO Auto-generated method stub
		String uuid = UUID.randomUUID().toString();
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//判断对象是否为空
		if(order!=null){
			List<Annex> annexList = order.getAnnexs();
			order.setOrderId(uuid);
			order.setFinishTime(date);
			//遍历创建表扬员工表
			if(order.getStaffList()!=null){
				for (int i = 0; i < order.getStaffList().size(); i++) {
					PraiseStaff praiseStaff = new PraiseStaff();
					praiseStaff.setPraiseStaffId(UUID.randomUUID().toString());
					praiseStaff.setOrderId(uuid);
					praiseStaff.setStaffId(order.getStaffList().get(i).getStaffId());
					praiseStaffMapper.insertPraiseStaffbyOrder(praiseStaff);
				}
			}
			Integer result = praiseOrdersMapper.insertPraiseOrder(order);
			//判断是否添加成功
			if(result>0){
			
				//附件信息保存
				if(annexList!=null && annexList.size()>0){
					for(Annex annex :annexList){
						annex.setRelationId(uuid);
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}
				
				TasksJournal journal = new TasksJournal();
				journal.setTaskId(order.getTaskId());
				journal.setCreOrderId(uuid);
				journal.setCreOrderType(order.getOrderType());
				journal.setChangeOrderState(order.getOrderState());
				journal.setOperatorId(order.getOperatorId());
				journal.setRemarks(order.getRemarks());
				journal.setOperationTime(date);
				tasksJournalMapper.insertTasksJournal(journal);
			}
		}
	}

	@Override
	public void deletePraiseOrderById(String id) {
		// TODO Auto-generated method stub
		praiseOrdersMapper.deletePraiseOrder(id);
	}

	@Override
	public void updatePraiseOrderInfo(PraiseOrders order) {
		praiseOrdersMapper.updatePraiseOrder(order);
	}

	@Override
	public PraiseOrders FindPraiseOrderById(String orderId) {
		// TODO Auto-generated method stub
		PraiseOrders praiseOrder = praiseOrdersMapper.getPraiseOrderById(orderId);
		return praiseOrder;
	}

	@Override
	public void closePraiseOrder(PraiseOrders order) {
		// TODO Auto-generated method stub
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		if(order!=null){
			Integer orderState = order.getOrderState();
			String closePersonId = order.getClosePersonId();
			if(orderState!=null && closePersonId!=null && !closePersonId.isEmpty()){
				order.setCloseTime(date);
				order.setOrderState(0);
				praiseOrdersMapper.updatePraiseOrder(order);//更新表扬表对象
			}
		}
	}

}
