package com.flf.entity;

  /*Created by Administrator on 2015/6/5. 
	author:尹磊
	修改时间：2015/6/5  修改人：尹磊 */
/**
 * 修改人：  肖聪  修改时间： 2015/6/19
 */
import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Items")
public class Items {
   

	private String id; //物品id

    private String number; // 序号

    private String itemName; // 物品名称

    private String amount; // 数量

    private String note;// 备注

    private String releaseId;// 放行条id
    
    private Integer contaitState;// 物品放行能否被放行

    private Date operateDate;//操作时间
    
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



    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getReleaseId() {
		return releaseId;
	}

	public void setReleaseId(String releaseId) {
		this.releaseId = releaseId;
	}

	public Integer getContaitState() {
		return contaitState;
	}

	public void setContaitState(Integer contaitState) {
		this.contaitState = contaitState;
	}
}