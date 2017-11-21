package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;




import com.flf.entity.Annex;
import com.flf.entity.ChargeItem;
import com.flf.entity.PageRestful;
import com.flf.entity.SearchPact;
import com.flf.entity.TenementPact;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.ChargeItemMapper;
import com.flf.mapper.TenementPactMapper;
import com.flf.request.TenementPactResult;
import com.flf.request.TenementPactSearch;
import com.flf.service.TenementPactService;


public class TenementPactServiceImpl implements TenementPactService{
	
	private TenementPactMapper tenementPactMapper;
	
	private ChargeItemMapper chargeItemMapper;
	
	private AnnexMapper annexMapper;

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	public ChargeItemMapper getChargeItemMapper() {
		return chargeItemMapper;
	}

	public void setChargeItemMapper(ChargeItemMapper chargeItemMapper) {
		this.chargeItemMapper = chargeItemMapper;
	}

	public TenementPactMapper getTenementPactMapper() {
		return tenementPactMapper;
	}

	public void setTenementPactMapper(TenementPactMapper tenementPactMapper) {
		this.tenementPactMapper = tenementPactMapper;
	}

/*	@Override
	public List<TenementPact> listAllTenementPact() {
		// TODO Auto-generated method stub
		return TenementPactMapper.listAllTenementPact();
	}

	@Override
	public List<TenementPact> listPageTenementPact(TenementPact TenementPact) {
		// TODO Auto-generated method stub
		return TenementPactMapper.listPageTenementPact(TenementPact);
	}

	@Override
	public TenementPact getTenementPactById(String id) {
		// TODO Auto-generated method stub
		return TenementPactMapper.getTenementPactById(id);
	}

	@Override
	public int insertTenementPact(TenementPact TenementPact) {
		// TODO Auto-generated method stub
		return TenementPactMapper.insertTenementPact(TenementPact);
	}

	@Override
	public int updateTenementPact(TenementPact TenementPact) {
		// TODO Auto-generated method stub
		return TenementPactMapper.updateTenementPact( TenementPact);
	}*/

	/**
	 * 分页查询合同管理页面
	 */
	@Override
	public PageRestful listPageTenementPactRestful(TenementPact tenementPact) {
		// TODO Auto-generated method stub
		PageRestful pagerestful=new PageRestful();
		Calendar calendar = Calendar.getInstance();
		Calendar calendars = Calendar.getInstance();
		calendar.add(Calendar.MONTH, -1);
		calendars.add(Calendar.MONTH, 1);
		Date date = calendar.getTime();
		Date dates = calendars.getTime();
		if(tenementPact.getState() == 0){
			tenementPact.setEndTime(new Date());
		}else if(tenementPact.getState() == 1){
			tenementPact.setEndTime(dates);
		}else if(tenementPact.getState() == 2){
			tenementPact.setEndTime(dates);
		}
		List<TenementPact> tenementPacts =tenementPactMapper.listPageTenementPact(tenementPact);
		tenementPacts.add(0,null);
		pagerestful.setTenementPacts(tenementPacts);
		pagerestful.setPage(tenementPact.getPage());
		return pagerestful;
	}

	@Override
	public List<TenementPact> listAllTenementPactRestful() {
		// TODO Auto-generated method stub
		return tenementPactMapper.listAllTenementPact();
	}

	@Override
	public TenementPact getTenementPactByIdRestful(String id) {
		// TODO Auto-generated method stub
		return tenementPactMapper.getTenementPactById(id);
	}
	
	
/**
 * 删除合同
 * yinlei
 */
	/*@Override
	public int deleteTenementPactRestful(String id) {
		// TODO Auto-generated method stub
		TenementPact tenementPact=tenementPactMapper.getTenementPactById(id);
		if(tenementPact.getState()!=null && tenementPact.getState()==3){
			tenementPactMapper.deleteTenementPact(id);
			chargeItemMapper.deleteChargeItem(tenementPact.getPactId());
			annexMapper.deleteAnnex(tenementPact.getPactId());
			return 1; //已删除
		}else{
			return 2; //无法删除
		}
		
	}*/

	@Override
	public void insertTenementPactRestful(TenementPact tenementPact) {
		// TODO Auto-generated method stub
		tenementPactMapper.insertTenementPact(tenementPact);
	}

	
	/**
	 * 修改物业合同
	 * yinlei
	 */
	/*@Override
	public int updateTenementPactRestful(TenementPactResult tenementPactResult) {
		// TODO Auto-generated method stub
		if(tenementPactResult.getTenementPact().getState()!=null && tenementPactResult.getTenementPact().getState()==3){
		List<ChargeItem> chargeItems=new ArrayList<ChargeItem>();
		TenementPact tenementPact=new TenementPact();
		List<Annex> annexs=new ArrayList<Annex>();
		if(tenementPactResult.getTenementPact()!=null){
			chargeItems=tenementPactResult.getChargeItems();//收费项集合
		}
		if(tenementPactResult.getTenementPact()!=null){
			tenementPact=tenementPactResult.getTenementPact();//物业合同
		}
		if(tenementPactResult.getAnnex()!=null){
			annexs=tenementPactResult.getAnnex();//附件集合
		}
		if(tenementPactMapper.updateTenementPact(tenementPact)>0&&chargeItems!=null){ //修改收费项
			chargeItemMapper.deleteChargeItem(tenementPact.getPactId());  //删除原有收费项
			Map<String,Object> map=new HashMap<String,Object>();
			map.put("list", chargeItems);
			map.put("pactId", tenementPact.getPactId());
			chargeItemMapper.insertListChargeItem(map);//添加合同项
		}
		annexMapper.deleteAnnex(tenementPact.getPactId());//删除原有文件
		if(annexs!=null){   //修改上传文件
			for (Annex annex : annexs) {
				annex.setPactId(tenementPact.getPactId());
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				annex.setAnnexTime(df.format(new Date()));// new Date()为获取当前系统时间
				annexMapper.insertAnnex(annex); // 添加附件信息
			}
		}	
		return 1;   //已修改
		}else{
			return 2; // 无法修改
		}
	}*/  
	
	
	/**
	 * 新增合同
	 * yinlei
	 */
	@Override
	public void insertTenementPact(TenementPact tenementPact) {
		// TODO Auto-generated method stub
		UUID uuid=UUID.randomUUID();//物业合同主键
		tenementPact.setPactId(uuid.toString());
		tenementPactMapper.insertTenementPact(tenementPact);
		if(tenementPact.getAnnexs() != null && tenementPact.getAnnexs().size() > 0){
			for (Annex annex : tenementPact.getAnnexs()) {
				annex.setPactId(uuid.toString());
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
				annex.setAnnexTime(df.format(new Date()));// new Date()为获取当前系统时间
				annexMapper.insertAnnex(annex); // 添加附件信息
			}
		}
	}
				
	@Override
	public void searchTenementPact(TenementPactSearch tenementPactSearch) {
		// TODO Auto-generated method stub
		tenementPactMapper.searchTenementPact(tenementPactSearch);
	}

	@Override
	public int updateTenementPactState(TenementPact tenementPact) {
		// TODO Auto-generated method stub
		if(tenementPact.getPactId()!=null){
			tenementPact.setState((byte)1);
			return tenementPactMapper.updateTenementPactState(tenementPact);
		}else{
			return 0;
		}		
	}
}
