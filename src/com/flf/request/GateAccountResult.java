/**
 * @Title: GateAccountResult.java
 * @Package com.flf.request
 * @Description: TODO
 * Copyright: Copyright (c) 2011 
 * Company:武汉闻风多奇软件开发有限公司
 * 
 * @author wangtao
 * @date 2015-6-1 下午2:31:13
 * @version V1.0
 */

package com.flf.request;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.GateAccount;

/**
 * @ClassName: GateAccountResult
 * @Description: TODO
 * @author wangyang
 * @date 2015-6-1 下午2:31:13
 *
 */
@XmlRootElement(name = "GateAccountResult") 
public class GateAccountResult {
	private GateAccount gateAccount;
	private TreeResult treeResult;
	public GateAccount getGateAccount() {
		return gateAccount;
	}
	public void setGateAccount(GateAccount gateAccount) {
		this.gateAccount = gateAccount;
	}
	public TreeResult getTreeResult() {
		return treeResult;
	}
	public void setTreeResult(TreeResult treeResult) {
		this.treeResult = treeResult;
	}
	
}
