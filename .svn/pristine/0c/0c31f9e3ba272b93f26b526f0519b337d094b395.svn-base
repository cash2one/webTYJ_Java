package com.flf.service.impl;

import java.util.List;

import com.flf.entity.Classes;
import com.flf.mapper.ClassesMapper;
import com.flf.service.ClassesService;

public class ClassesServiceImpl implements ClassesService {

	private ClassesMapper classesMapper;
	
	
	public ClassesMapper getClassesMapper() {
		return classesMapper;
	}

	public void setClassesMapper(ClassesMapper classesMapper) {
		this.classesMapper = classesMapper;
	}

	@Override
	public List<Classes> listAllClasses() {
		// TODO Auto-generated method stub
		return classesMapper.listAllClasses();
	}

	@Override
	public Classes getClassesById(String id) {
		// TODO Auto-generated method stub
		return classesMapper.getClassesById(id);
	}

	@Override
	public int insertClasses(Classes classes) {
		// TODO Auto-generated method stub
		return classesMapper.insertClasses(classes);
	}

	@Override
	public int updateClasses(Classes classes) {
		// TODO Auto-generated method stub
		return classesMapper.updateClasses(classes);
	}

	@Override
	public int deleteClasses(String id) {
		// TODO Auto-generated method stub
		return classesMapper.deleteClasses(id);
	}
	
	@Override
	public List<Classes> listClassesByPostIdAndOrderByPostTypeId(String postId) {
		// TODO Auto-generated method stub
		return classesMapper.listClassesByPostIdAndOrderByPostTypeId(postId);
	}
	
	@Override
	public int updateClassesState(Classes classes) {
		// TODO Auto-generated method stub
		return classesMapper.updateClassesState(classes);
	}

	@Override
	public Classes getUserByIdRest(String id) {
		// TODO Auto-generated method stub
		return classesMapper.getClassesById(id);
	}

	@Override
	public void AddClasses(Classes classes) {
		// TODO Auto-generated method stub
		classesMapper.insertClasses(classes);
	}

	@Override
	public void UpdateClasses(Classes classes) {
		// TODO Auto-generated method stub
		classesMapper.updateClasses(classes);
	}

	@Override
	public void DeleteClassesById(String id) {
		// TODO Auto-generated method stub
		classesMapper.deleteClasses(id);
	}

	@Override
	public List<Classes> listPageuser() {
		// TODO Auto-generated method stub
		return classesMapper.listAllClasses();
	}

}
