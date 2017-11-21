package com.flf.service.impl;

import java.util.List;
import javax.jws.WebService;
import com.flf.entity.PageRestful;
import com.flf.entity.Vacation;
import com.flf.mapper.VacationMapper;
import com.flf.service.VacationService;

/**
 * 内部专业线_ 假期管理(接口实现)
 * 
 * @author 阮枚星
 * 
 * @createDate:2015-05-26
 */
@WebService
public class VacationServiceImpl implements VacationService {

	private VacationMapper vacationMapper;


	public VacationMapper getVacationMapper() {
		return vacationMapper;
	}

	public void setVacationMapper(VacationMapper vacationMapper) {
		this.vacationMapper = vacationMapper;
	}

	@Override
	public PageRestful getPageRestfulVacation(Vacation vacation) {
		PageRestful pagerestful = new PageRestful();
		List<Vacation> vacations = vacationMapper.getAllVacation(vacation);
		vacations.add(0, null);
		pagerestful.setVacations(vacations);
		pagerestful.setPage(vacation.getPage());
		return pagerestful;
	}

	@Override
	public List<Vacation> getAllVacation(Vacation vacation) {
		return vacationMapper.getAllVacation(vacation);
	}

	@Override
	public Vacation getVacationById(Integer id) {
		return vacationMapper.getVacationById(id);
	}

	@Override
	public List<Vacation> getVacationByName(String vacationName) {
		return vacationMapper.getVacationByName(vacationName);
	}

	@Override
	public void editVacation(Vacation vacation) {
		vacationMapper.editVacation(vacation);
	}

	@Override
	public void delVacationById(Integer id) {
		vacationMapper.delVacationById(id);
	}

	@Override
	public void addVacation(Vacation vacation) {
		vacationMapper.addVacation(vacation);
	}

	public List<Vacation> getVacation() {
		return vacationMapper.getVacation();
	}
}
