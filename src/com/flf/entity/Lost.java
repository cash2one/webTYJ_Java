package com.flf.entity;
import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name ="Lost") 
public class Lost {
	
	private String articleId;  //遗失id
    private String  articleName;//遗失名称
    private Integer articleAmount;//遗失数量
    private String  articlePlace;//遗失地方
    private String  pickPlace;  //拾取地点
    private String  articlePeople;//拾取者id
    private String  articleClaimant;//领取人id
    private Date    articleTimePicker;//拾取时间
    private Date    articleTimeCheck;//领取时间
    private Date lostTime;// 遗失时间
    private Date    articleTimeClaim;//遗失物品领取时间
    private String  articleDescribe;//遗失物品描述
    private String  remarks;//遗失物品备注
    private String  articleLostPeople;//遗失物品人的id
	private Integer lostState;//遗失物品状态
	private Page    page;
    private String name;//姓名
    private String phoneNum;//电话号码
   
	PersonCustNew personPicker;//拾取人
	
    PersonCustNew personLoser;//遗失人
    
    PersonCustNew personGeter;//领取人
	
    public PersonCustNew getPersonPicker() {
		return personPicker;
	}
	public void setPersonPicker(PersonCustNew personPicker) {
		this.personPicker = personPicker;
	}
	public PersonCustNew getPersonLoser() {
		return personLoser;
	}
	public void setPersonLoser(PersonCustNew personLoser) {
		this.personLoser = personLoser;
	}
	public PersonCustNew getPersonGeter() {
		return personGeter;
	}
	public void setPersonGeter(PersonCustNew personGeter) {
		this.personGeter = personGeter;
	}
    
    public Integer getLostState() {
		return lostState;
	}
	public void setLostState(Integer lostState) {
		this.lostState = lostState;
	}
    

    
 
    public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getArticleLostPeople() {
		return articleLostPeople;
	}
	public void setArticleLostPeople(String articleLostPeople) {
		this.articleLostPeople = articleLostPeople;
	}
	public String getPickPlace() {
		return pickPlace;
	}
	public void setPickPlace(String pickPlace) {
		this.pickPlace = pickPlace;
	}
	public Date getLostTime() {
		return lostTime;
	}
	public void setLostTime(Date lostTime) {
		this.lostTime = lostTime;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	public String getArticleId() {
		return articleId;
	}
    
    public Date getArticleTimeCheck() {
		return articleTimeCheck;
	}
	public void setArticleTimeCheck(Date articleTimeCheck) {
		this.articleTimeCheck = articleTimeCheck;
	}

	public void setArticleId(String articleId) {
		this.articleId = articleId;
	}
	
	
	public String getArticleName() {
		return articleName;
	}
	public void setArticleName(String articleName) {
		this.articleName = articleName;
	}
	public Integer getArticleAmount() {
		return articleAmount;
	}
	public void setArticleAmount(Integer articleAmount) {
		this.articleAmount = articleAmount;
	}
	public String getArticlePlace() {
		return articlePlace;
	}
	public void setArticlePlace(String articlePlace) {
		this.articlePlace = articlePlace;
	}
	public String getArticlePeople() {
		return articlePeople;
	}
	public void setArticlePeople(String articlePeople) {
		this.articlePeople = articlePeople;
	}
	public String getArticleClaimant() {
		return articleClaimant;
	}
	public void setArticleClaimant(String articleClaimant) {
		this.articleClaimant = articleClaimant;
	}
	public Date getArticleTimePicker() {
		return articleTimePicker;
	}
	public void setArticleTimePicker(Date articleTimePicker) {
		this.articleTimePicker = articleTimePicker;
	}
	public Date getArticleTimeClaim() {
		return articleTimeClaim;
	}
	public void setArticleTimeClaim(Date articleTimeClaim) {
		this.articleTimeClaim = articleTimeClaim;
	}
	public String getArticleDescribe() {
		return articleDescribe;
	}
	public void setArticleDescribe(String articleDescribe) {
		this.articleDescribe = articleDescribe;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	
    
   
		
}
