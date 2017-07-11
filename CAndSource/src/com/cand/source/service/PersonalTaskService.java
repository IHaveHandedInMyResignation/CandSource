package com.cand.source.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cand.source.dao.PersonalTaskDao;
import com.cand.source.dao.ProfileDao;
import com.cand.source.persistentce.PersonalTask;
import com.cand.source.persistentce.Profile;

@Component
public class PersonalTaskService {

	@Autowired
	private PersonalTaskDao dao;

	public void setDao(PersonalTaskDao dao) {
		this.dao = dao;
	}

	@Autowired
	private ProfileDao profileDao;

	public void setProfileDao(ProfileDao profileDao) {
		this.profileDao = profileDao;
	}

	@Transactional
	public List<PersonalTask> getAllTasks(String userLogin, Integer limit) {
		Integer profileId = getUserIdByLogin(userLogin);
		return dao.getList(profileId, limit);
	}

	@Transactional
	public List<PersonalTask> getAllUpcomingTasks(String userLogin, LocalDateTime fromDate) {
		Integer profileId = getUserIdByLogin(userLogin);
		return dao.getTasksBetweenDates(profileId, fromDate, fromDate.plusYears(10));
	}

	@Transactional
	public List<PersonalTask> getLimitedUpcomingTasks(String userLogin, Integer startPosition, Integer limit) {
		Integer profileId = getUserIdByLogin(userLogin);
		LocalDateTime nowDateTime = LocalDateTime.now();

		return dao.getTasksBetweenDatesAndLimited(profileId, nowDateTime, nowDateTime.plusYears(10), startPosition,
				limit);
	}

	@Transactional
	public List<PersonalTask> getLimitedPastTasks(String userLogin, Integer startPosition, Integer limit) {

		Integer profileId = getUserIdByLogin(userLogin);
		LocalDateTime nowDateTime = LocalDateTime.now();

		return dao.getTasksBetweenDatesAndLimited(profileId, nowDateTime.minusYears(10), nowDateTime, startPosition,
				limit);
	}

	private Integer getUserIdByLogin(String userLogin) {

		return profileDao.getProfile(userLogin).getId();
	}

	@Transactional
	public void insertNewTask(PersonalTask pt, String userLogin) {
		
		Profile profile = profileDao.getProfile(userLogin);
		pt.setProfile(profile);
		pt.setCreationDate(LocalDateTime.now());
		dao.insert(pt);
	}

	@Transactional
	public PersonalTask getTask(Integer taskId) {

		return dao.get(taskId);
	}

	@Transactional
	public void updateTask(PersonalTask pt) {
		PersonalTask existTask = dao.get(pt.getId());
		existTask.merge(pt);
		existTask.setLastModificationDate(LocalDateTime.now());
		dao.update(existTask);
	}

}
