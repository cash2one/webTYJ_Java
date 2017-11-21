package com.flf.request;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.flf.entity.Parcel;
import com.flf.entity.Post;
import com.flf.entity.Prepare;
import com.flf.entity.Project;

@XmlRootElement(name = "ProjectResult") 
public class ProjectResult {
	private Project project;//项目
	private List<Parcel> parcels;//宗地
	private List<Prepare> Prepares;//编制

	

	public List<Parcel> getParcels() {
		return parcels;
	}

	public void setParcels(List<Parcel> parcels) {
		this.parcels = parcels;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public List<Prepare> getPrepares() {
		return Prepares;
	}

	public void setPrepares(List<Prepare> prepares) {
		Prepares = prepares;
	}
}
