package com.flf.entity;

/*Created by Administrator on 2015/6/5. 
author:尹磊
修改时间：2015/6/5  修改人：尹磊 */

import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name = "ArticleRelease")// 放行条表
public class ArticleRelease {
        private String id;    //放行条主键id
        
    	private String houseId;//房屋id
    	
    	private String houseName;//房屋地址

	    private String name;//受礼人名字

	    private String phoneNumber;//联系电话

	    private String idCard;//身份证号

	    private Date applyTime;//申请时间

	    private Date releaseTime;//放行开始日期
	    
	    private Date releaseTimeEnd;//放行结束日期

	    private Date acceptTime;//受理时间

	    private String itemsId;//物品id预留

	    private String custId;//业主id

	    private String personId;//受理人id

	    private String enterpriseId;//小区公司id

	    private Byte customerType;//客户类型
    
        private PersonCustNew person;//客户为业主时对象
    
        private EnterpriseCustNew enterpriseCustNew;//客户为企业时的对象
        
        private String releaseCode;//放行条编号

        private Page page;
    
        private List<Items> item;
    
        private PersonCustNew personCust;//申请人对象1
        
        private Date operateDate;//操作时间
        
        /***查询用****/
        private String custName;//客户姓名（查询用）
        
        private String phone;//客户电话（查询用）
        
        private String cardNumber;//客户证件号（查询用）
        
        private String cardType;//证件类型（查询用）
        
        private List<Items> releaseItem;//允许放行的物品
        
        private List<Items> notReleaseItem;//不允许放行的物品
        
        public String getCardType() {
			return cardType;
		}

		public void setCardType(String cardType) {
			this.cardType = cardType;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getCardNumber() {
			return cardNumber;
		}

		public void setCardNumber(String cardNumber) {
			this.cardNumber = cardNumber;
		}		
        
        public Date getOperateDate() {
    		return operateDate;
    	}

    	public void setOperateDate(Date operateDate) {
    		this.operateDate = operateDate;
    	}

	    public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public String getHouseId() {
			return houseId;
		}

		public void setHouseId(String houseId) {
			this.houseId = houseId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getIdCard() {
			return idCard;
		}

		public void setIdCard(String idCard) {
			this.idCard = idCard;
		}

		public Date getApplyTime() {
			return applyTime;
		}

		public void setApplyTime(Date applyTime) {
			this.applyTime = applyTime;
		}

		public Date getReleaseTime() {
			return releaseTime;
		}

		public void setReleaseTime(Date releaseTime) {
			this.releaseTime = releaseTime;
		}

		public Date getAcceptTime() {
			return acceptTime;
		}

		public void setAcceptTime(Date acceptTime) {
			this.acceptTime = acceptTime;
		}

		public String getItemsId() {
			return itemsId;
		}

		public void setItemsId(String itemsId) {
			this.itemsId = itemsId;
		}

		public String getCustId() {
			return custId;
		}

		public void setCustId(String custId) {
			this.custId = custId;
		}

		public String getPersonId() {
			return personId;
		}

		public void setPersonId(String personId) {
			this.personId = personId;
		}

		public String getEnterpriseId() {
			return enterpriseId;
		}

		public void setEnterpriseId(String enterpriseId) {
			this.enterpriseId = enterpriseId;
		}

		public Byte getCustomerType() {
			return customerType;
		}

		public void setCustomerType(Byte customerType) {
			this.customerType = customerType;
		}

		public PersonCustNew getPerson() {
			return person;
		}

		public void setPerson(PersonCustNew person) {
			this.person = person;
		}

		public EnterpriseCustNew getEnterpriseCustNew() {
			return enterpriseCustNew;
		}

		public void setEnterpriseCustNew(EnterpriseCustNew enterpriseCustNew) {
			this.enterpriseCustNew = enterpriseCustNew;
		}

		public Page getPage() {
			return page;
		}

		public void setPage(Page page) {
			this.page = page;
		}

		public List<Items> getItem() {
			return item;
		}

		public void setItem(List<Items> item) {
			this.item = item;
		}

		public PersonCustNew getPersonCust() {
			return personCust;
		}

		public void setPersonCust(PersonCustNew personCust) {
			this.personCust = personCust;
		}

		public Date getReleaseTimeEnd() {
			return releaseTimeEnd;
		}

		public void setReleaseTimeEnd(Date releaseTimeEnd) {
			this.releaseTimeEnd = releaseTimeEnd;
		}

		public String getHouseName() {
			return houseName;
		}

		public void setHouseName(String houseName) {
			this.houseName = houseName;
		}

		public String getReleaseCode() {
			return releaseCode;
		}

		public void setReleaseCode(String releaseCode) {
			this.releaseCode = releaseCode;
		}

		public List<Items> getReleaseItem() {
			return releaseItem;
		}

		public void setReleaseItem(List<Items> releaseItem) {
			this.releaseItem = releaseItem;
		}

		public List<Items> getNotReleaseItem() {
			return notReleaseItem;
		}

		public void setNotReleaseItem(List<Items> notReleaseItem) {
			this.notReleaseItem = notReleaseItem;
		}
		
}