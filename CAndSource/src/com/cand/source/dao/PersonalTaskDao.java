package com.cand.source.dao;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cand.source.persistentce.PersonalTask;

@Component
public class PersonalTaskDao implements BasicCrud<PersonalTask> {

	private static final Logger logger = Logger.getLogger(PersonalTaskDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public PersonalTask get(Integer id) {

		try {
			return sessionFactory.getCurrentSession().get(PersonalTask.class, id);
		} catch (NoResultException e) {
			// no action, just there is no result
		}

		return null;
	}

	public PersonalTask getLast(Integer id) {

		return (PersonalTask) sessionFactory.getCurrentSession().get(PersonalTask.class, id);
	}

	public List<PersonalTask> getList(Integer profileId, Integer limit) {

		List<PersonalTask> resultList;

		if (limit > 0) {
			resultList = (List<PersonalTask>) sessionFactory.getCurrentSession()
					.getNamedQuery("PersonalTask.findListOfTasks").setParameter("id", profileId).setMaxResults(limit)
					.getResultList();
			return resultList;
		}

		resultList = (List<PersonalTask>) sessionFactory.getCurrentSession()
				.getNamedQuery("PersonalTask.findListOfTasks").setParameter("id", profileId).getResultList();

		return resultList;
	}

	public List<PersonalTask> getTasksBetweenDates(Integer profileId, LocalDateTime fromDate, LocalDateTime toDate) {

		Query query = getQueryTasksBetweenDates(profileId, fromDate, toDate);

		return query.getResultList();
	}

	public List<PersonalTask> getTasksBetweenDatesAndLimited(Integer profileId, LocalDateTime fromDate,
			LocalDateTime toDate, Integer startPosition, Integer maxResult) {

		Query query = getQueryTasksBetweenDates(profileId, fromDate, toDate).setFirstResult(startPosition)
				.setMaxResults(maxResult);

		return (List<PersonalTask>) query.getResultList();
	}

	private Query getQueryTasksBetweenDates(Integer profileId, LocalDateTime fromDate, LocalDateTime toDate) {
		return sessionFactory.getCurrentSession().getNamedQuery("PersonalTask.findTasksBetweenDates")
				.setParameter("id", profileId).setParameter("startDate", fromDate).setParameter("finishDate", toDate);
	}

	public List<PersonalTask> getTasksOrderedByStartDateAsc(Integer profileId, Integer fromNumberRowPos,
			Integer limit) {

		Query query = sessionFactory.getCurrentSession().getNamedQuery("PersonalTask.findTasksOrderedByDateAsc")
				.setParameter("id", profileId);

		if (fromNumberRowPos >= 0)
			query.setFirstResult(fromNumberRowPos);
		if (limit > 0)
			query.setMaxResults(limit);

		return (List<PersonalTask>) query.getResultList();

	}

	@Override
	public void insert(PersonalTask entity) {
		logger.info("Before save. Task title: " + entity.getTitle());
		sessionFactory.getCurrentSession().save(entity);
		logger.info("After save. Task title: " + entity.getTitle());

	}

	@Override
	public void update(PersonalTask entity) {
		logger.info("Before update. Task ID: " + entity.getId());
		sessionFactory.getCurrentSession().update(entity);
		logger.info("After update. Task ID: " + entity.getId());
	}

	@Override
	public void fakeDelete(Integer id) {
		logger.info("Before fake delete. Task ID: " + id);
		PersonalTask pt = get(id);
		pt.setEnabled(false);
		sessionFactory.getCurrentSession().update(pt);
		logger.info("After fake delete. Task ID: " + id);

	}

}
