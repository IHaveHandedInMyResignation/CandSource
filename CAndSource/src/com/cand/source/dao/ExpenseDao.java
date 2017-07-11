package com.cand.source.dao;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cand.source.persistentce.Expense;

@SuppressWarnings("deprecation")
@Component
public class ExpenseDao implements BasicCrud<Expense> {

	private static final Logger logger = Logger.getLogger(ExpenseDao.class);

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Expense get(Integer id) {
		
		try {
			return sessionFactory.getCurrentSession().get(Expense.class, id);
		} catch (NoResultException e) {
			logger.debug("No result: Expense id: " + id);
			// no action, just there is no result
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	public List<Expense> getExpenses(Integer idProfile) {

		return (List<Expense>) sessionFactory.getCurrentSession().getNamedQuery("Expense.getForUser")
				.setParameter("id", idProfile).getResultList();
	}

	@Override
	public void insert(Expense entity) {
		logger.debug("Before save. Expense id: " + entity.getId());
		sessionFactory.getCurrentSession().save(entity);
		logger.debug("After save. Expense id: " + entity.getId());

	}

	@Override
	public void update(Expense entity) {
		logger.debug("Before update. Expense id: " + entity.getId());
		sessionFactory.getCurrentSession().update(entity);
		logger.debug("After update. Expense id: " + entity.getId());

	}

	@Override
	public void fakeDelete(Integer id) {
		logger.debug("Before fake delete. Expense id: " + id);
		Expense expense = get(id);
		expense.setEnabled(false);
		sessionFactory.getCurrentSession().update(expense);
		logger.debug("After fake delete. Expense id: " + id);

	}

	@SuppressWarnings("unchecked")
	public List<Expense> getBetweenDates(LocalDate start, LocalDate end, Integer idProfile) {
		LocalDateTime startDateTime = LocalDateTime.of(start, LocalTime.of(0, 0));
		LocalDateTime endDateTime = LocalDateTime.of(end, LocalTime.of(23, 59));

		return (List<Expense>) sessionFactory.getCurrentSession().getNamedQuery("Expense.getForUserBetweenDates")
				.setParameter("id", idProfile).setParameter("startDate", startDateTime)
				.setParameter("endDate", endDateTime).getResultList();
	}

	public BigDecimal getSumExBetweenDates(LocalDate start, LocalDate end, Integer idProfile) {
		LocalDateTime startDateTime = LocalDateTime.of(start, LocalTime.of(0, 0));
		LocalDateTime endDateTime = LocalDateTime.of(end, LocalTime.of(23, 59));
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Expense.class);
		criteria.add(Restrictions.ge("date", startDateTime));
		criteria.add(Restrictions.lt("date", endDateTime));
		criteria.setProjection(Projections.sum("cost"));
		criteria.add(Restrictions.eq("profile.id", idProfile));
		
		BigDecimal expensesSum = criteria.uniqueResult() !=null ? (BigDecimal) criteria.uniqueResult() : new BigDecimal(0.0) ;
		return expensesSum;
	}

	public BigDecimal getSumExAll(Integer idProfile) {

		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(Expense.class);
		criteria.setProjection(Projections.sum("cost"));
		criteria.add(Restrictions.eq("profile.id", idProfile));
		return (BigDecimal) criteria.uniqueResult();
	}
	/*
	 * CriteriaBuilder builder =
	 * sessionFactory.getCurrentSession().getCriteriaBuilder();
	 * CriteriaQuery<Long> criteriaQuery = builder.createQuery(Long.class);
	 * Root<Expense> root = criteriaQuery.from(Expense.class);
	 * criteriaQuery.select(builder.count(root)); Predicate betweenDates=
	 * (Predicate) builder.between(root.get("date").as(LocalDateTime.class),
	 * startDateTime, endDateTime); Predicate fitUserId = (Predicate) builder.p;
	 * Predicate condition3 = builder.and(betweenDates, fitUserId);
	 */
}
