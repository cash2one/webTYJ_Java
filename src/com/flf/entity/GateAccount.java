package com.flf.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

import com.flf.request.TreeResult;
@XmlRootElement(name = "GateAccount")//门控机账号表
public class GateAccount {
	private String id;

    private String accountNum;

    private String accountName;
    
    private String password;

    private @DateTimeFormat(pattern="yyyy-MM-dd")Date registerTime;

    private String state;
    
    private Gating gating;
    
    private Page page;

	public Page getPage() {
		return page;
	}

	public void setPage(Page page) {
		this.page = page;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getRegisterTime() {
		return registerTime;
	}

	public void setRegisterTime(Date registerTime) {
		this.registerTime = registerTime;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Gating getGating() {
		return gating;
	}

	public void setGating(Gating gating) {
		this.gating = gating;
	}
}