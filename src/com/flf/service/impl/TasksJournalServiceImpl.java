package com.flf.service.impl;
import java.util.List;

import javax.jws.WebService;

import com.flf.entity.AcceptanceOrders;
import com.flf.entity.AppealOrders;
import com.flf.entity.CheckOrders;
import com.flf.entity.ClaimToCustomerOrders;
import com.flf.entity.ClosedOrders;
import com.flf.entity.CompensateOwner;
import com.flf.entity.ComplaintOrders;
import com.flf.entity.ConstructionAcceptanceOrders;
import com.flf.entity.ConstructionCheckOrders;
import com.flf.entity.ConstructionInspectionOrders;
import com.flf.entity.ConsultationOrders;
import com.flf.entity.DepartmentOrders;
import com.flf.entity.DisposeOrder;
import com.flf.entity.FixedParkingOrders;
import com.flf.entity.InspectorOrder;
import com.flf.entity.MeterReadingOrders;
import com.flf.entity.PraiseOrders;
import com.flf.entity.QuoteOrders;
import com.flf.entity.RenovationAcceptanceOrders;
import com.flf.entity.RenovationCheckOrders;
import com.flf.entity.RenovationInspectionOrders;
import com.flf.entity.RepairOrders;
import com.flf.entity.ReturnVisitOrders;
import com.flf.entity.SettleAccountsOrders;
import com.flf.entity.TasksJournal;
import com.flf.entity.WaterMeterOrders;
import com.flf.mapper.AcceptanceOrdersMapper;
import com.flf.mapper.AppealOrdersMapper;
import com.flf.mapper.CheckOrdersMapper;
import com.flf.mapper.ClaimToCustomerOrdersMapper;
import com.flf.mapper.ClosedMapper;
import com.flf.mapper.CompensateOwnerMapper;
import com.flf.mapper.ComplaintOrdersMapper;
import com.flf.mapper.ConstructionAcceptanceOrdersMapper;
import com.flf.mapper.ConstructionCheckOrdersMapper;
import com.flf.mapper.ConstructionInspectionOrdersMapper;
import com.flf.mapper.ConsultationOrdersMapper;
import com.flf.mapper.DepartmentOrdersMapper;
import com.flf.mapper.DisposeOrderMapper;
import com.flf.mapper.FixedParkingOrdersMapper;
import com.flf.mapper.InspectorOrderMapper;
import com.flf.mapper.MeterReadingOrdersMapper;
import com.flf.mapper.PraiseOrdersMapper;
import com.flf.mapper.QuoteOrdersMapper;
import com.flf.mapper.RenovationAcceptanceOrdersMapper;
import com.flf.mapper.RenovationCheckOrdersMapper;
import com.flf.mapper.RenovationInspectionOrdersMapper;
import com.flf.mapper.RepairOrdersMapper;
import com.flf.mapper.ReturnVisitOrdersMapper;
import com.flf.mapper.SettleAccountsOrdersMapper;
import com.flf.mapper.TasksJournalMapper;
import com.flf.mapper.WaterMeterOrdersMapper;
import com.flf.service.TasksJournalService;
/**
 * 任务日志表
 * 创建人：邵政
 * 创建时间：2015/6/23
 */
@WebService
public class TasksJournalServiceImpl implements TasksJournalService {
	
	private TasksJournalMapper tasksJournalMapper;
	private QuoteOrdersMapper quoteOrdersMapper;
	private DisposeOrderMapper disposeOrderMapper;
	private AcceptanceOrdersMapper acceptanceOrdersMapper;
	private CheckOrdersMapper checkOrdersMapper;
	private SettleAccountsOrdersMapper settleAccountsOrdersMapper;
	private CompensateOwnerMapper compensateOwnerMapper;
	private PraiseOrdersMapper praiseOrdersMapper;
	private DepartmentOrdersMapper departmentOrdersMapper;
	private ReturnVisitOrdersMapper returnVisitOrdersMapper;
	private AppealOrdersMapper appealOrdersMapper;
	private WaterMeterOrdersMapper waterMeterOrdersMapper;
	private MeterReadingOrdersMapper meterReadingOrdersMapper;
	private ComplaintOrdersMapper complaintOrdersMapper;
	private ConsultationOrdersMapper consultationOrdersMapper;
	private FixedParkingOrdersMapper fixedParkingOrdersMapper;
	private RenovationCheckOrdersMapper renovationCheckOrdersMapper;
	private RenovationInspectionOrdersMapper renovationInspectionOrdersMapper;
	private RenovationAcceptanceOrdersMapper renovationAcceptanceOrdersMapper;
	private InspectorOrderMapper inspectorOrderMapper;
	private ConstructionCheckOrdersMapper constructionCheckOrdersMapper;
	private ConstructionInspectionOrdersMapper constructionInspectionOrdersMapper;
	private ConstructionAcceptanceOrdersMapper constructionAcceptanceOrdersMapper;
	private RepairOrdersMapper repairOrdersMapper;
	private ClosedMapper closedMapper;
	private ClaimToCustomerOrdersMapper claimToCustomerOrdersMapper;
	
	public ClaimToCustomerOrdersMapper getClaimToCustomerOrdersMapper() {
		return claimToCustomerOrdersMapper;
	}

	public void setClaimToCustomerOrdersMapper(
			ClaimToCustomerOrdersMapper claimToCustomerOrdersMapper) {
		this.claimToCustomerOrdersMapper = claimToCustomerOrdersMapper;
	}

	public ClosedMapper getClosedMapper() {
		return closedMapper;
	}

	public void setClosedMapper(ClosedMapper closedMapper) {
		this.closedMapper = closedMapper;
	}

	public ConstructionCheckOrdersMapper getConstructionCheckOrdersMapper() {
		return constructionCheckOrdersMapper;
	}

	public void setConstructionCheckOrdersMapper(
			ConstructionCheckOrdersMapper constructionCheckOrdersMapper) {
		this.constructionCheckOrdersMapper = constructionCheckOrdersMapper;
	}

	public ConstructionInspectionOrdersMapper getConstructionInspectionOrdersMapper() {
		return constructionInspectionOrdersMapper;
	}

	public void setConstructionInspectionOrdersMapper(
			ConstructionInspectionOrdersMapper constructionInspectionOrdersMapper) {
		this.constructionInspectionOrdersMapper = constructionInspectionOrdersMapper;
	}

	public ConstructionAcceptanceOrdersMapper getConstructionAcceptanceOrdersMapper() {
		return constructionAcceptanceOrdersMapper;
	}

	public void setConstructionAcceptanceOrdersMapper(
			ConstructionAcceptanceOrdersMapper constructionAcceptanceOrdersMapper) {
		this.constructionAcceptanceOrdersMapper = constructionAcceptanceOrdersMapper;
	}

	public RenovationAcceptanceOrdersMapper getRenovationAcceptanceOrdersMapper() {
		return renovationAcceptanceOrdersMapper;
	}

	public void setRenovationAcceptanceOrdersMapper(
			RenovationAcceptanceOrdersMapper renovationAcceptanceOrdersMapper) {
		this.renovationAcceptanceOrdersMapper = renovationAcceptanceOrdersMapper;
	}

	public RenovationInspectionOrdersMapper getRenovationInspectionOrdersMapper() {
		return renovationInspectionOrdersMapper;
	}

	public void setRenovationInspectionOrdersMapper(
			RenovationInspectionOrdersMapper renovationInspectionOrdersMapper) {
		this.renovationInspectionOrdersMapper = renovationInspectionOrdersMapper;
	}

	public RenovationCheckOrdersMapper getRenovationCheckOrdersMapper() {
		return renovationCheckOrdersMapper;
	}

	public void setRenovationCheckOrdersMapper(
			RenovationCheckOrdersMapper renovationCheckOrdersMapper) {
		this.renovationCheckOrdersMapper = renovationCheckOrdersMapper;
	}

	public FixedParkingOrdersMapper getFixedParkingOrdersMapper() {
		return fixedParkingOrdersMapper;
	}

	public void setFixedParkingOrdersMapper(
			FixedParkingOrdersMapper fixedParkingOrdersMapper) {
		this.fixedParkingOrdersMapper = fixedParkingOrdersMapper;
	}

	public ConsultationOrdersMapper getConsultationOrdersMapper() {
		return consultationOrdersMapper;
	}

	public void setConsultationOrdersMapper(
			ConsultationOrdersMapper consultationOrdersMapper) {
		this.consultationOrdersMapper = consultationOrdersMapper;
	}

	public ComplaintOrdersMapper getComplaintOrdersMapper() {
		return complaintOrdersMapper;
	}

	public void setComplaintOrdersMapper(ComplaintOrdersMapper complaintOrdersMapper) {
		this.complaintOrdersMapper = complaintOrdersMapper;
	}

	public MeterReadingOrdersMapper getMeterReadingOrdersMapper() {
		return meterReadingOrdersMapper;
	}

	public void setMeterReadingOrdersMapper(
			MeterReadingOrdersMapper meterReadingOrdersMapper) {
		this.meterReadingOrdersMapper = meterReadingOrdersMapper;
	}

	public WaterMeterOrdersMapper getWaterMeterOrdersMapper() {
		return waterMeterOrdersMapper;
	}

	public void setWaterMeterOrdersMapper(
			WaterMeterOrdersMapper waterMeterOrdersMapper) {
		this.waterMeterOrdersMapper = waterMeterOrdersMapper;
	}

	public AppealOrdersMapper getAppealOrdersMapper() {
		return appealOrdersMapper;
	}

	public void setAppealOrdersMapper(AppealOrdersMapper appealOrdersMapper) {
		this.appealOrdersMapper = appealOrdersMapper;
	}

	public ReturnVisitOrdersMapper getReturnVisitOrdersMapper() {
		return returnVisitOrdersMapper;
	}

	public void setReturnVisitOrdersMapper(
			ReturnVisitOrdersMapper returnVisitOrdersMapper) {
		this.returnVisitOrdersMapper = returnVisitOrdersMapper;
	}

	public DepartmentOrdersMapper getDepartmentOrdersMapper() {
		return departmentOrdersMapper;
	}

	public void setDepartmentOrdersMapper(
			DepartmentOrdersMapper departmentOrdersMapper) {
		this.departmentOrdersMapper = departmentOrdersMapper;
	}

	public CompensateOwnerMapper getCompensateOwnerMapper() {
		return compensateOwnerMapper;
	}

	public void setCompensateOwnerMapper(CompensateOwnerMapper compensateOwnerMapper) {
		this.compensateOwnerMapper = compensateOwnerMapper;
	}

	public PraiseOrdersMapper getPraiseOrdersMapper() {
		return praiseOrdersMapper;
	}

	public void setPraiseOrdersMapper(PraiseOrdersMapper praiseOrdersMapper) {
		this.praiseOrdersMapper = praiseOrdersMapper;
	}

	public SettleAccountsOrdersMapper getSettleAccountsOrdersMapper() {
		return settleAccountsOrdersMapper;
	}

	public void setSettleAccountsOrdersMapper(
			SettleAccountsOrdersMapper settleAccountsOrdersMapper) {
		this.settleAccountsOrdersMapper = settleAccountsOrdersMapper;
	}

	public QuoteOrdersMapper getQuoteOrdersMapper() {
		return quoteOrdersMapper;
	}

	public void setQuoteOrdersMapper(QuoteOrdersMapper quoteOrdersMapper) {
		this.quoteOrdersMapper = quoteOrdersMapper;
	}

	public DisposeOrderMapper getDisposeOrderMapper() {
		return disposeOrderMapper;
	}

	public void setDisposeOrderMapper(DisposeOrderMapper disposeOrderMapper) {
		this.disposeOrderMapper = disposeOrderMapper;
	}

	public AcceptanceOrdersMapper getAcceptanceOrdersMapper() {
		return acceptanceOrdersMapper;
	}

	public void setAcceptanceOrdersMapper(
			AcceptanceOrdersMapper acceptanceOrdersMapper) {
		this.acceptanceOrdersMapper = acceptanceOrdersMapper;
	}

	public CheckOrdersMapper getCheckOrdersMapper() {
		return checkOrdersMapper;
	}

	public void setCheckOrdersMapper(CheckOrdersMapper checkOrdersMapper) {
		this.checkOrdersMapper = checkOrdersMapper;
	}

	public TasksJournalMapper getTasksJournalMapper() {
		return tasksJournalMapper;
	}

	public void setTasksJournalMapper(TasksJournalMapper tasksJournalMapper) {
		this.tasksJournalMapper = tasksJournalMapper;
	}

	public InspectorOrderMapper getInspectorOrderMapper() {
		return inspectorOrderMapper;
	}

	public void setInspectorOrderMapper(InspectorOrderMapper inspectorOrderMapper) {
		this.inspectorOrderMapper = inspectorOrderMapper;
	}

	public RepairOrdersMapper getRepairOrdersMapper() {
		return repairOrdersMapper;
	}

	public void setRepairOrdersMapper(RepairOrdersMapper repairOrdersMapper) {
		this.repairOrdersMapper = repairOrdersMapper;
	}

	@Override
	public List<TasksJournal> listPageTasksJournal(
			TasksJournal tasksJournal) {
		// TODO Auto-generated method stub
		return tasksJournalMapper.listPageTasksJournal(tasksJournal);
	}

	@Override
	public List<TasksJournal> listAllTasksJournal() {
		// TODO Auto-generated method stub
		return tasksJournalMapper.listAllTasksJournal();
	}

	@Override
	public TasksJournal getTasksJournalbyId(String tasksJournalId) {
		// TODO Auto-generated method stub
		return tasksJournalMapper.getTasksJournalbyId(tasksJournalId);
	}

	@Override
	public void insertTasksJournal(TasksJournal tasksJournal) {
		// TODO Auto-generated method stub
		tasksJournalMapper.insertTasksJournal(tasksJournal);
	}

	@Override
	public void updateTasksJournal(TasksJournal tasksJournal) {
		// TODO Auto-generated method stub
		tasksJournalMapper.updateTasksJournal(tasksJournal);
	}

	@Override
	public void deleteTasksJournal(String tasksJournalId) {
		// TODO Auto-generated method stub
		tasksJournalMapper.deleteTasksJournal(tasksJournalId);
	}

	@Override
	public List<TasksJournal> getTasksJournalbyTasksId(String tasksId) {
		
		if(tasksId != null && !"".equals(tasksId)){
			
			return tasksJournalMapper.getTasksJournalbyTasksId(tasksId);
			
//			List<TasksJournal> temp = new ArrayList<TasksJournal>();
//			QuoteOrders quoteOrders = null;
//			CheckOrders checkOrders = null;
//			DisposeOrder disposeOrder = null;
//			AcceptanceOrders acceptanceOrders = null;
//			
//			if(tasksJournals != null && tasksJournals.size()>0){
//				for(TasksJournal t : tasksJournals){
//					Integer type = t.getCreOrderType();
//					String creOrderId = t.getCreOrderId();
//					
//					if(type != null && type == 0 && creOrderId!=null && !"".equals(creOrderId)){//报价单
//						quoteOrders = quoteOrdersMapper.getQuoteOrdersbyId(creOrderId);
//						t.setQuoteOrders(quoteOrders);
//					}else if(type != null && type == 1 && creOrderId!=null && !"".equals(creOrderId)){//处理单
//						disposeOrder = disposeOrderMapper.getDisposeOrderbyId(creOrderId);
//						t.setDisposeOrder(disposeOrder);
//					}else if(type != null && type == 2 && creOrderId!=null && !"".equals(creOrderId)){//验收单
//						acceptanceOrders = acceptanceOrdersMapper.getAcceptanceOrdersbyId(creOrderId);
//						t.setAcceptanceOrders(acceptanceOrdtttters);
//					}else if(type != null && type == 3 && creOrderId!=null && !"".equals(creOrderId)){//检测单
//						checkOrders = checkOrdersMapper.getCheckOrdersbyId(creOrderId);
//						t.setCheckOrders(checkOrders);
//					}
//					temp.add(t);
//				}
//			}
//			return temp;
		}
		return null;
	}

	@Override
	public TasksJournal getTasksJournalbyDateandType(String creOrderType,
			String operationTime) {
		// TODO Auto-generated method stub
		
		QuoteOrders quoteOrders = null;
		CheckOrders checkOrders = null;
		DisposeOrder disposeOrder = null;
		AcceptanceOrders acceptanceOrders = null;
		SettleAccountsOrders settleAccountsOrders = null;
		CompensateOwner compensateOwner = null;
		PraiseOrders praiseOrders = null;
		DepartmentOrders departmentOrders = null;
		ReturnVisitOrders returnVisitOrders =null;
		AppealOrders appealOrders=null;
		WaterMeterOrders waterMeterOrders = null;
		MeterReadingOrders meterReadingOrders = null;
		ComplaintOrders complaintOrders = null;
		ConsultationOrders consultationOrders = null;
		FixedParkingOrders fixedParkingOrders = null;
		RenovationCheckOrders renovationCheckOrders = null;
		RenovationInspectionOrders renovationInspectionOrders = null;
		RenovationAcceptanceOrders renovationAcceptanceOrders = null;
		InspectorOrder inspectorOrder = null;
		ConstructionCheckOrders constructionCheckOrders = null;
		ConstructionInspectionOrders constructionInspectionOrders = null;
		ConstructionAcceptanceOrders constructionAcceptanceOrders = null;
		RepairOrders repairOrders = null;
		ClosedOrders closedOrders = null;
		ClaimToCustomerOrders claimToCustomerOrders = null;
		if(creOrderType != null && operationTime != null && !"".equals(creOrderType) && !"".equals(operationTime)){
			TasksJournal journal = tasksJournalMapper.getTasksJournalbyDateandType(creOrderType, operationTime);
			if(journal != null){
				Integer type = journal.getCreOrderType();
				String creOrderId = journal.getCreOrderId();
				
				if(type != null && type == 0 && creOrderId!=null && !"".equals(creOrderId)){//报价单
					quoteOrders = quoteOrdersMapper.getQuoteOrdersbyId(creOrderId);
					quoteOrders.getItemRecords().add(0, null);
					journal.setQuoteOrders(quoteOrders);
				}else if(type != null && type == 1 && creOrderId!=null && !"".equals(creOrderId)){//处理单
					disposeOrder = disposeOrderMapper.getDisposeOrderbyId(creOrderId);
					disposeOrder.getAnnexs().add(0,null);
					journal.setDisposeOrder(disposeOrder);
				}else if(type != null && type == 2 && creOrderId!=null && !"".equals(creOrderId)){//验收单
					acceptanceOrders = acceptanceOrdersMapper.getAcceptanceOrdersbyId(creOrderId);
					journal.setAcceptanceOrders(acceptanceOrders);
				}else if(type != null && type == 3 && creOrderId!=null && !"".equals(creOrderId)){//检测单
					checkOrders = checkOrdersMapper.getCheckOrdersbyId(creOrderId);
					journal.setCheckOrders(checkOrders);
				}else if(type != null && type == 4 && creOrderId!=null && !"".equals(creOrderId)){//结算单
 					settleAccountsOrders = settleAccountsOrdersMapper.getSettleAccountsOrdersById(creOrderId);
					settleAccountsOrders.getSaiRecords().add(0,null);
					journal.setSettleAccountsOrders(settleAccountsOrders);
				}else if(type != null && type == 5 && creOrderId!=null && !"".equals(creOrderId)){//赔偿给业主
					compensateOwner = compensateOwnerMapper.getCompensateOwnerbyId(creOrderId);
					journal.setCompensateOwner(compensateOwner);
					/***********************************/
				}else if(type != null && type == 6 && creOrderId!=null && !"".equals(creOrderId)){//部门质检
					departmentOrders = departmentOrdersMapper.getDepartmentOrdersbyId(creOrderId);
					journal.setDepartmentOrders(departmentOrders);
				}else if(type != null && type == 7 && creOrderId!=null && !"".equals(creOrderId)){//回访单
					returnVisitOrders = returnVisitOrdersMapper.getReturnVisitOrdersbyId(creOrderId);
					journal.setReturnVisitOrders(returnVisitOrders);
				}else if(type != null && type == 8 && creOrderId!=null && !"".equals(creOrderId)){//申诉单
					appealOrders = appealOrdersMapper.getAppealOrdersbyId(creOrderId);
					journal.setAppealOrders(appealOrders);
				}else if(type != null && type == 9 && creOrderId!=null && !"".equals(creOrderId)){//抄水表
					waterMeterOrders = waterMeterOrdersMapper.getWaterMeterOrdersbyId(creOrderId);
					waterMeterOrders.getWaterMeterOrderRecordsList().add(0,null);
					journal.setWaterMeterOrders(waterMeterOrders);
				}else if(type != null && type == 10 && creOrderId!=null && !"".equals(creOrderId)){//抄电表
					meterReadingOrders = meterReadingOrdersMapper.getMeterReadingOrdersbyId(creOrderId);
					journal.setMeterReadingOrders(meterReadingOrders);
				}else if(type !=null && type == 11 && creOrderId != null && !"".equals(creOrderId)){  //投诉表
					complaintOrders = complaintOrdersMapper.getComplaintOrdersbyId(creOrderId);
					journal.setComplaintOrders(complaintOrders);
				}else if(type !=null && type == 12 && creOrderId != null && !"".equals(creOrderId)){  //咨询表
					consultationOrders = consultationOrdersMapper.getConsultationOrdersbyId(creOrderId);
					journal.setConsultationOrders(consultationOrders);
				}else if(type !=null && type == 13 && creOrderId != null && !"".equals(creOrderId)){  //固定工单表
					fixedParkingOrders = fixedParkingOrdersMapper.getFixedParkingOrdersbyId(creOrderId);
					journal.setFixedParkingOrders(fixedParkingOrders);
				}
				else if(type !=null && type == 14 && creOrderId != null && !"".equals(creOrderId)){  //装修核查工单
					renovationCheckOrders = renovationCheckOrdersMapper.getRenovationCheckOrdersbyId(creOrderId);
					journal.setRenovationCheckOrders(renovationCheckOrders);
				}else if(type != null && type == 17 && creOrderId!=null && !"".equals(creOrderId)){//表扬单
					praiseOrders = praiseOrdersMapper.getPraiseOrderById(creOrderId);
					journal.setPraiseOrders(praiseOrders);
				}
				else if(type !=null && type == 15 && creOrderId != null && !"".equals(creOrderId)){  //装修巡检工单
					renovationInspectionOrders = renovationInspectionOrdersMapper.getRenovationInspectionOrdersbyId(creOrderId);
					journal.setRenovationInspectionOrders(renovationInspectionOrders);
				}
				else if(type !=null && type == 16 && creOrderId != null && !"".equals(creOrderId)){  //装修核查工单
					renovationAcceptanceOrders = renovationAcceptanceOrdersMapper.getRenovationAcceptanceOrdersbyId(creOrderId);
					journal.setRenovationAcceptanceOrders(renovationAcceptanceOrders);
				}
				else if(type !=null && type == 18 && creOrderId != null && !"".equals(creOrderId)){  //验房单
					inspectorOrder = inspectorOrderMapper.getInspectorOrderbyId(creOrderId);
					journal.setInspectorOrder(inspectorOrder);
				}else if(type !=null && type == 19 && creOrderId != null && !"".equals(creOrderId)){//施工核查
					constructionCheckOrders = constructionCheckOrdersMapper.getConstructionCheckOrdersbyId(creOrderId);
					journal.setConstructionCheckOrders(constructionCheckOrders);
				}else if(type !=null && type == 20 && creOrderId != null && !"".equals(creOrderId)){//施工巡检
					constructionInspectionOrders = constructionInspectionOrdersMapper.getConstructionInspectionOrdersbyId(creOrderId);
					journal.setConstructionInspectionOrders(constructionInspectionOrders);
				}else if(type !=null && type == 21 && creOrderId != null && !"".equals(creOrderId)){//施工验收
					constructionAcceptanceOrders = constructionAcceptanceOrdersMapper.getConstructionAcceptanceOrdersbyId(creOrderId);
					journal.setConstructionAcceptanceOrders(constructionAcceptanceOrders);
				}else if(type !=null && type == 22 && creOrderId != null && !"".equals(creOrderId)){//维修单
					repairOrders = repairOrdersMapper.selectByPrimaryKey(creOrderId);
					journal.setRepairOrders(repairOrders);
				}else if(type !=null && type == 24 && creOrderId != null && !"".equals(creOrderId)){//失效单
					closedOrders = closedMapper.getClosedOrdersbyId(creOrderId);
					journal.setClosedOrders(closedOrders);
				}else if(type !=null && type == 23 && creOrderId != null && !"".equals(creOrderId)){//向业主索赔
					claimToCustomerOrders = claimToCustomerOrdersMapper.getClaimToCustomerOrdersbyId(creOrderId);
					journal.setClaimToCustomerOrders(claimToCustomerOrders);
				}
				return journal;
			}
		}
		return null;
	}


}
