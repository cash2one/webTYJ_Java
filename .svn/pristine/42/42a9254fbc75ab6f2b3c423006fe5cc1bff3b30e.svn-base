package com.flf.entity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="ProductFixedparkingspace")
public class ProductFixedparkingspace {
	//固定车位主表ID
    private String fixedparkingspaceId;
    //生效时间
    private String beginDate;
    //失效时间
    private String endDate;
    //价格
    private BigDecimal productPrice;
    //产品编码
    private String productCode;
    //创建人
    private String createUser;
    //修改人
    private String updateUser;
    //创建时间
    private String createDate;
    //修改时间
    private Date updateDate;
    //租用状态   通过数据库查询计算  生成
    private String state;
    //用来接收需要失效的id
    private String ids[];
	public String[] getIds() {
		return ids;
	}

	public void setIds(String[] ids) {
		this.ids = ids;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	//链接车库表
    private List<BuildingStructureNew> buildingStructureNewList;
    
    
    //分页
    private Page page;
    

    public Page getPage() {
 		if(this.page==null){
 			this.page=new Page();
 		}
 		return page;
 	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getFixedparkingspaceId() {
        return fixedparkingspaceId;
    }

    public void setFixedparkingspaceId(String fixedparkingspaceId) {
        this.fixedparkingspaceId = fixedparkingspaceId;
    }

    public String getBeginDate() {
        return beginDate;
    }

    public void setBeginDate(String beginDate) {
        this.beginDate = beginDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public String getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
    
    public List<BuildingStructureNew> getBuildingStructureNewList() {
		return buildingStructureNewList;
	}

	public void setBuildingStructureNewList(List<BuildingStructureNew> buildingStructureNewList) {
		this.buildingStructureNewList = buildingStructureNewList;
	}
}