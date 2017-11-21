package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.CassetRepository;
@XmlRootElement(name = "CassetRepositoryRequest") 
public class CassetRepositoryRequest {
	
	private List<CassetRepository> CassetRepositorys;  //资产库集合

	public List<CassetRepository> getCassetRepositorys() {
		return CassetRepositorys;
	}

	public void setCassetRepositorys(List<CassetRepository> cassetRepositorys) {
		CassetRepositorys = cassetRepositorys;
	}

}
