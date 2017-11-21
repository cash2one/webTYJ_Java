package com.flf.request;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Info")
public class Info {
	private String state;
	private String code;
	private Object info;

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object getInfo() {
		return info;
	}

	public void setInfo(Object info) {
		this.info = info;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
