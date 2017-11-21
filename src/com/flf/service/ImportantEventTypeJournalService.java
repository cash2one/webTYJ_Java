package com.flf.service;

import javax.jws.WebService;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.flf.entity.ImportantEventTypeJournal;


@WebService
@Path("/ImportantEventTypeJournal")
public interface ImportantEventTypeJournalService {
	/**
	 * 根据id查询日志
	 * @return
	 */
	@GET
	@Path("/getDataByReordId/{recordId}")
	@Produces(MediaType.APPLICATION_JSON)
	ImportantEventTypeJournal getDataByReordId(@PathParam("recordId") String recordId);

	
}
