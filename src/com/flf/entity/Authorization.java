package com.flf.entity;

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;
@XmlRootElement(name = "Authorization") 
/**
 * 
  * @ClassName: 授权管理
  * @Description: TODO
  * @author wangyong
  * @date 2015-5-20 下午3:33:43
  * 
  * 
  * 修改  by 肖聪   2015/6/4
  * 添加车位授权
 */
public class Authorization {
   
	private String authorizationId; //授权管理id

    private String authorizedPersonid; //被授权人id

    private String authorizerPersonid; //授权人id

    private String houseId; //资产id
    
    private Integer authorizationType;  //授权类型(1委托书2电话3电子授权)

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date staDate;  //开始时间

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date endDate;  //结束时间

    private String accessoryAddress;  //附件路径    

    //private Byte accessCard; //门禁卡(0)否 1 是

    //private Byte vehicle; //车辆登记

    //private Byte parkingCard; //停车卡

    //private Byte carportManage; //车位管理

    // private Byte ropertyChanges; //产权变更

    //private Byte lease;  //租赁

    //private Byte articleRelease; //放行条

    // private Byte decorate;  //装修

    // private Byte partnership;  //入伙   

	//private Byte entrance;
    
    private String  remark; // 备注
    
    private List<Annex> annexs; //上传资料实体    

	private List<String> ids;//房屋id集合	

	private PersonCustNew personCustNew ;
	
	private HouseNew house;
	
    private Date operateDate;//操作时间
    
    private String authorizerName;//授权人姓名(查询用) 
    
    private String authorizationProjectName;//授权项目名（显示用）
    
    private String authorizationProjectId;//授权项目id
    

	private List<AuthorizationProject> authorizationProjects;
	
	private AuthorizationProject authorizationProject;
	
	private List<String> typeList ;
	
	private String status;
	
    public List<String> getTypeList() {
		return typeList;
	}

	public void setTypeList(List<String> typeList) {
		this.typeList = typeList;
	}

	public AuthorizationProject getAuthorizationProject() {
		return authorizationProject;
	}

	public void setAuthorizationProject(AuthorizationProject authorizationProject) {
		this.authorizationProject = authorizationProject;
	}

	public List<AuthorizationProject> getAuthorizationProjects() {
		return authorizationProjects;
	}

	public void setAuthorizationProjects(
			List<AuthorizationProject> authorizationProjects) {
		this.authorizationProjects = authorizationProjects;
	}

	public String getAuthorizationProjectId() {
		return authorizationProjectId;
	}

	public void setAuthorizationProjectId(String authorizationProjectId) {
		this.authorizationProjectId = authorizationProjectId;
	}

	public String getAuthorizationProjectName() {
		return authorizationProjectName;
	}

	public void setAuthorizationProjectName(String authorizationProjectName) {
		this.authorizationProjectName = authorizationProjectName;
	}	
    
	public List<String> getAuthorizationProjectTypes() {
		return authorizationProjectTypes;
	}

	public void setAuthorizationProjectTypes(List<String> authorizationProjectTypes) {
		this.authorizationProjectTypes = authorizationProjectTypes;
	}

	private List<String> authorizationProjectTypes;//授权项目类型表	
	
    
     public List<String> getIds() {
		return ids;
	}

	public void setIds(List<String> ids) {
		this.ids = ids;
	}

    
    public List<Annex> getAnnexs() {
		return annexs;
	}

	public void setAnnexs(List<Annex> annexs) {
		this.annexs = annexs;
	}
	
    public String getAuthorizerName() {
		return authorizerName;
	}

	public void setAuthorizerName(String authorizerName) {
		this.authorizerName = authorizerName;
	}
    
    public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	private Page page;
    
    public Date getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(Date operateDate) {
		this.operateDate = operateDate;
	}
    
    public HouseNew getHouse() {
		return house;
	}

	public void setHouse(HouseNew house) {
		this.house = house;
	}

	public PersonCustNew getPersonCustNew() {
		return personCustNew;
	}

	public void setPersonCustNew(PersonCustNew personCustNew) {
		this.personCustNew = personCustNew;
	}
       
    public String getAuthorizationId() {
		return authorizationId;
	}

	public void setAuthorizationId(String authorizationId) {
		this.authorizationId = authorizationId;
	}

	public String getAuthorizedPersonid() {
		return authorizedPersonid;
	}

	public void setAuthorizedPersonid(String authorizedPersonid) {
		this.authorizedPersonid = authorizedPersonid;
	}

	public String getAuthorizerPersonid() {
		return authorizerPersonid;
	}

	public void setAuthorizerPersonid(String authorizerPersonid) {
		this.authorizerPersonid = authorizerPersonid;
	}

	public String getHouseId() {
		return houseId;
	}

	public void setHouseId(String houseId) {
		this.houseId = houseId;
	}

	public String getAccessoryAddress() {
		return accessoryAddress;
	}

	public void setAccessoryAddress(String accessoryAddress) {
		this.accessoryAddress = accessoryAddress;
	}

    public Integer getAuthorizationType() {
        return authorizationType;
    }

    public void setAuthorizationType(Integer authorizationType) {
        this.authorizationType = authorizationType;
    }

    public Date getStaDate() {
        return staDate;
    }

    public void setStaDate(Date staDate) {
        this.staDate = staDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

    
}