package com.flf.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.web.bind.annotation.RequestParam;

import com.flf.entity.Staff;

@javax.jws.WebService
@javax.ws.rs.Path("/LoginService")
public interface LoginService {
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/login")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	String login(com.flf.entity.TUser user);
	
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/loginByAppUser")
	String loginAppUser(@RequestParam("loginName") String loginName, @RequestParam("password") String password);
	
	@javax.ws.rs.GET
	@javax.ws.rs.Path("/loginAppUser_Check")
	boolean loginAppUser_Check(@RequestParam("loginName") String loginName, @RequestParam("password") String password);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/ws_checkUserByAppAccountId")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	com.flf.entity.Staff ws_checkUserByAppAccountId(com.flf.entity.Staff staff);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/importDataFromExcelFileNew")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	com.flf.request.Info importDataFromExcelFileNew(com.flf.entity.Annex annex);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/checkUserByLoginNameAndSendMsg")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	String checkUserByLoginNameAndSendMsg(com.flf.entity.Staff staff);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/disagree_UserByLoginNameAndSendMsg")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	String disagree_UserByLoginNameAndSendMsg(com.flf.entity.Staff staff);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/agree_WelcomeUser")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	String agree_WelcomeUser(com.flf.entity.Staff staff);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/sendMsg2UserByLoginName")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	String sendMsg2UserByLoginName(com.flf.entity.Staff staff);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/putLoginNameInSystemFromAPP")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	String putLoginNameInSystemFromAPP(com.flf.entity.Staff staff);
	
	@javax.ws.rs.POST
	@javax.ws.rs.Path("/sendAuditMsg2UserByLoginName")
	@javax.ws.rs.Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
	@javax.ws.rs.Consumes({javax.ws.rs.core.MediaType.APPLICATION_JSON,javax.ws.rs.core.MediaType.APPLICATION_XML})
	String sendAuditMsg2UserByLoginName(com.flf.entity.Staff staff);
	
	/*删除--改状态0**/
	@PUT
	@Path("/removeStaffStateByStateAndId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void removeStaffStateByStateAndId(Staff staff);
	
	/*删除--改状态0**/
	@PUT
	@Path("/leaveStaffStateByStateAndId")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	void leaveStaffStateByStateAndId(Staff staff);
	
}
