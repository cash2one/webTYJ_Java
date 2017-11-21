package com.flf.entity;

import java.util.Date;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 银联托收总结文件
 * 
 * @author 倪明 创建时间：2015/9/22
 * 
 */
@XmlRootElement(name = "UnionpayCollectionTotall")
public class UnionpayCollectionTotall{

	private String unionpayCollectionTotallId; // 主键id

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createTime; // 创建时间

	private String projectId; // 项目id

	private String projectName; // 项目名称

	private String merchantsNum; // 商户号

	private String batchNum; // 批次号

	private Long totalSum; // 总金额

	private Page page; // 分页
	
	private Date minStaTime;//开始时间
	
	private Date maxStaTime;//结束时间
	
	private Project project;//项目对象
	
	private Integer totalTradeNum;//总笔数
	
	private Integer collectionType; //托收状态 0:未托收 1：已托收 2已回盘
	
	private String createDateString;//excel导出时间处理
	
	private String fileNames;
	
	public String getFileNames() {
		return fileNames;
	}

	public void setFileNames(String fileNames) {
		this.fileNames = fileNames;
	}

	public Integer getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(Integer collectionType) {
		this.collectionType = collectionType;
	}

	public List<UnionpayCollectionDetail> getUnionpayCollectionDetails() {
		return unionpayCollectionDetails;
	}

	public void setUnionpayCollectionDetails(List<UnionpayCollectionDetail> unionpayCollectionDetails) {
		this.unionpayCollectionDetails = unionpayCollectionDetails;
	}

	private List<UnionpayCollectionDetail> unionpayCollectionDetails; //银联托收明细表
	
	
    public String getCreateDateString() {
		return createDateString;
	}

	public void setCreateDateString(String createDateString) {
		this.createDateString = createDateString;
	}

	public Integer getTotalTradeNum() {
	     return totalTradeNum;
	 }

    public void setTotalTradeNum(Integer totalTradeNum) {
	     this.totalTradeNum = totalTradeNum;
	 }

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Date getMinStaTime() {
		return minStaTime;
	}

	public void setMinStaTime(Date minStaTime) {
		this.minStaTime = minStaTime;
	}

	public Date getMaxStaTime() {
		return maxStaTime;
	}

	public void setMaxStaTime(Date maxStaTime) {
		this.maxStaTime = maxStaTime;
	}

	public Page getPage() {
		if(this.page==null){
    		this.page=new Page();
		}
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getUnionpayCollectionTotallId() {
		return unionpayCollectionTotallId;
	}

	public void setUnionpayCollectionTotallId(String unionpayCollectionTotallId) {
		this.unionpayCollectionTotallId = unionpayCollectionTotallId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getMerchantsNum() {
		return merchantsNum;
	}

	public void setMerchantsNum(String merchantsNum) {
		this.merchantsNum = merchantsNum;
	}

	public String getBatchNum() {
		return batchNum;
	}

	public void setBatchNum(String batchNum) {
		this.batchNum = batchNum;
	}

	public Long getTotalSum() {
		return totalSum;
	}

	public void setTotalSum(Long totalSum) {
		this.totalSum = totalSum;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

}
