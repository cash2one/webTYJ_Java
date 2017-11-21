package com.flf.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.ws.rs.PathParam;

import org.apache.commons.lang.StringUtils;

import net.sf.json.JSONObject;
import com.flf.entity.Annex;
import com.flf.entity.CollectionManage;
import com.flf.entity.PageRestful;
import com.flf.mapper.AnnexMapper;
import com.flf.mapper.CollectionManageMapper;
import com.flf.service.CollectionManageService;
import com.flf.util.DateUtil;

public class CollectionManageServiceImpl implements CollectionManageService{
	
	private CollectionManageMapper collectionManageMapper;
	private AnnexMapper annexMapper;

	public CollectionManageMapper getCollectionManageMapper() {
		return collectionManageMapper;
	}

	public void setCollectionManageMapper(
			CollectionManageMapper collectionManageMapper) {
		this.collectionManageMapper = collectionManageMapper;
	}

	public AnnexMapper getAnnexMapper() {
		return annexMapper;
	}

	public void setAnnexMapper(AnnexMapper annexMapper) {
		this.annexMapper = annexMapper;
	}

	@Override
	public List<CollectionManage> listAllCollectionManage() {
		// TODO Auto-generated method stub
		return collectionManageMapper.listAllCollectionManage();
	}

	@Override
	public PageRestful listPageCollectionManage(
			CollectionManage collectionManage) {
		// TODO Auto-generated method stub
		PageRestful pageRestful=new PageRestful();
		List<CollectionManage> collectionManages=collectionManageMapper.listPageCollectionManage(collectionManage);
		collectionManages.add(0,null);
		pageRestful.setCollectionManages(collectionManages);
		pageRestful.setPage(collectionManage.getPage());
		return pageRestful;
	}

	@Override
	public CollectionManage getCollectionManageById(String collectionManageId) {
		// TODO Auto-generated method stub
		return collectionManageMapper.getCollectionManagebyId(collectionManageId);
	}

	@Override
	public String insertCollectionManage(CollectionManage collectionManage) {
		// TODO Auto-generated method stub
		Map<String,String> map=new HashMap<String,String>();
		if(collectionManage.getId()==null||"".equals(collectionManage.getId())){
			map.put("code","3001");
			map.put("information","建筑未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getCustName()==null||"".equals(collectionManage.getCustName())){
			map.put("code","3001");
			map.put("information","姓名未输入");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getBankAccount()==null||"".equals(collectionManage.getBankAccount())){
			map.put("code","3001");
			map.put("information","银行卡未输入");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getProvince()==null||"".equals(collectionManage.getProvince())){
			map.put("code","3001");
			map.put("information","开户省未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getCity()==null||"".equals(collectionManage.getCity())){
			map.put("code","3001");
			map.put("information","开户市未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getBankName()==null||"".equals(collectionManage.getBankName())){
			map.put("code","3001");
			map.put("information","开户银行未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getCollectionType()==2){
			map.put("code","3001");
			map.put("information","托收类型未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getStartTime()==null||"".equals(collectionManage.getStartTime())){
			map.put("code","3001");
			map.put("information","启用时间未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getContractNumber()==null||"".equals(collectionManage.getContractNumber())){
			map.put("code","3001");
			map.put("information","合同号未填写");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
//		if(collectionManage.getCollectionState()==null||"".equals(collectionManage.getCollectionState())){
//			map.put("code","3001");
//			map.put("information","使用状态未选择");
//		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
//		}
		collectionManage.setCollectionState("0");
		collectionManage.setCollectionManageId(UUID.randomUUID().toString());		
		String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		//if(collectionManageMapper.insertCollectionManage(collectionManage) > 0){
		boolean flag = false;
			List<Annex> annexList = collectionManage.getAnnexs();
			List<String> idList= collectionManage.getIds();
			if(idList!=null && idList.size()>0){
				for(String id : idList){
					collectionManage.setId(id);
					try {
						collectionManageMapper.insertCollectionManage(collectionManage);
						flag = true;
					} catch (Exception e) {
						// TODO Auto-generated catch block
						flag = false;
						e.printStackTrace();
					}
				}
			}else{
				collectionManage.setCreateTime(DateUtil.getToday("yyyy-MM-dd HH:mm:ss"));
				collectionManageMapper.insertCollectionManage(collectionManage);
				flag = true;
			}
			
			//附件信息保存
			if(flag){
				if(annexList!=null && annexList.size()>0){
					for(Annex annex :annexList){
						annex.setRelationId(UUID.randomUUID().toString());
						annex.setAnnexTime(date);
						annexMapper.insertAnnex(annex);
					}
				}				
			}
			map.put("code","200");
			map.put("information","银行托收办理成功");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		//}
	}

	@Override
	public String updateCollectionManage(CollectionManage collectionManage) {
		
		Map<String,String> map=new HashMap<String,String>();
		
		CollectionManage cm = collectionManageMapper.getCollectionManagebyId(collectionManage.getCollectionManageId());
		if("1".equals(cm.getCollectionState())){
			map.put("code","3001");
			map.put("information","停用状态不能修改");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		
		if(collectionManage.getId()==null||"".equals(collectionManage.getId())){
			map.put("code","3001");
			map.put("information","建筑未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getCustName()==null||"".equals(collectionManage.getCustName())){
			map.put("code","3001");
			map.put("information","姓名未输入");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getBankAccount()==null||"".equals(collectionManage.getBankAccount())){
			map.put("code","3001");
			map.put("information","银行卡未输入");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getProvince()==null||"".equals(collectionManage.getProvince())){
			map.put("code","3001");
			map.put("information","开户省未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getCity()==null||"".equals(collectionManage.getCity())){
			map.put("code","3001");
			map.put("information","开户市未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getBankName()==null||"".equals(collectionManage.getBankName())){
			map.put("code","3001");
			map.put("information","开户银行未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getStartTime()==null||"".equals(collectionManage.getStartTime())){
			map.put("code","3001");
			map.put("information","启用时间未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getCollectionState()==null||"".equals(collectionManage.getCollectionState())){
			map.put("code","3001");
			map.put("information","使用状态未选择");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		if(collectionManage.getContractNumber()==null||"".equals(collectionManage.getContractNumber())){
			map.put("code","3001");
			map.put("information","合同号未填写");
		    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
		}
		collectionManageMapper.updateCollectionManage(collectionManage);
		map.put("code","200");
		map.put("information","银行托收修改成功");
	    return JSONObject.fromObject(map).toString();//3001表示参数不全    200表示成功
	}

	@Override
	public String deleteCollectionManage(String collectionManageId) {
		Map<String,String> map=new HashMap<String,String>();
		if(StringUtils.isNotBlank(collectionManageId)){
			String[] ids = collectionManageId.split(",");
			for(String id : ids){
				collectionManageMapper.deleteCollectionManage(id);
				map.put("code","200");
				map.put("information","删除成功");
			}
		}
		return JSONObject.fromObject(map).toString();
	}
	@Override
	public String checkContactNumber(String contractNumber){
		Map<String,String> map=new HashMap<String,String>();
		CollectionManage a=collectionManageMapper.getContractNumber(contractNumber);
		if(a!=null){
			map.put("result", "1");
		}else{
			map.put("result", "0");
		}
		return JSONObject.fromObject(map).toString();
		
	}
}
