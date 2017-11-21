package com.flf.entity;

public class Sipmanage {
    private String sipId;

    private String sipName;

    private String sipPwd;
    
    private int loginState;
    
    private int state;//使用状态，0为有效，1为失效  王洲  2016.02.27
    
	public int getLoginState() {
		return loginState;
	}

	public void setLoginState(int loginState) {
		this.loginState = loginState;
	}

	public String getSipId() {
        return sipId;
    }

    public void setSipId(String sipId) {
        this.sipId = sipId;
    }

    public String getSipName() {
        return sipName;
    }

    public void setSipName(String sipName) {
        this.sipName = sipName;
    }

    public String getSipPwd() {
        return sipPwd;
    }

    public void setSipPwd(String sipPwd) {
        this.sipPwd = sipPwd;
    }

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}