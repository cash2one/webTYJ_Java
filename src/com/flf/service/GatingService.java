package com.flf.service;

import javax.jws.WebService;
@WebService
public interface GatingService {
	
	String getGatingByid(String gateId);

}
