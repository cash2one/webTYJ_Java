package com.flf.service.impl;

import java.util.List;

import com.flf.entity.ClassesType;
import com.flf.mapper.ClassesTypeMapper;
import com.flf.service.ClassesTypeService;

public class ClassesTypeServiceImpl implements ClassesTypeService {

	private ClassesTypeMapper classesTypeMapper;
	
	
	public ClassesTypeMapper getClassesTypeMapper() {
		return classesTypeMapper;
	}

	public void setClassesTypeMapper(ClassesTypeMapper classesTypeMapper) {
		this.classesTypeMapper = classesTypeMapper;
	}

	@Override
	public List<ClassesType> listPageuser() {
		// TODO Auto-generated method stub
		return classesTypeMapper.listClassesAll();
	}

	@Override
	public ClassesType getClassesTypeByIdRest(String id) {
		// TODO Auto-generated method stub
		return classesTypeMapper.selectByPrimaryKey(id);
	}

	@Override
	public void AddClassesType(ClassesType classesType) {
		// TODO Auto-generated method stub
		classesTypeMapper.insertClassesType(classesType);

	}

	@Override
	public void UpdateClassesType(ClassesType classesType) {
		// TODO Auto-generated method stub
		classesTypeMapper.updateByPrimaryKey(classesType);

	}

	@Override
	public void DeleteClassesTypeById(String id) {
		// TODO Auto-generated method stub
		classesTypeMapper.deleteByPrimaryKey(id);

	}

}
