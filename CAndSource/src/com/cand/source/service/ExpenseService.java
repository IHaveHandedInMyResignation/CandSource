package com.cand.source.service;

import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import javax.naming.NoPermissionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cand.source.dao.ExpenseDao;
import com.cand.source.dao.ProfileDao;
import com.cand.source.persistentce.Expense;
import com.cand.source.persistentce.Profile;

@Component
public class ExpenseService {

	@Autowired
	ExpenseDao expenseDao;

	@Autowired
	ProfileDao profileDao;

	@Transactional
	public void insertNewExpense(Expense expense, String userLogin, boolean generateNowDate) {

		if (generateNowDate || expense.getDate() == null)
			expense.setDate(LocalDateTime.now());

		expense.setProfile(profileDao.getProfile(userLogin));
		expenseDao.insert(expense);
	}
	private void sortByDateDesc(List<Expense> expenses){
		
		expenses.sort((e1, e2)-> e2.getDate().compareTo(e1.getDate()));
	}

	@Transactional
	public List<Expense> getWeekExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.with(DayOfWeek.MONDAY);
		LocalDate end = initial.with(DayOfWeek.SUNDAY);
		
		List<Expense> expenses = expenseDao.getBetweenDates(start, end, profile.getId());
		sortByDateDesc(expenses);
		return expenses;
	}

	@Transactional
	public BigDecimal getSumWeekExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.with(DayOfWeek.MONDAY);
		LocalDate end = initial.with(DayOfWeek.SUNDAY);
		return expenseDao.getSumExBetweenDates(start, end, profile.getId());
	}

	@Transactional
	public List<Expense> getMonthExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.withDayOfMonth(initial.getMonth().maxLength());
		List<Expense> expenses = expenseDao.getBetweenDates(start, end, profile.getId());
		sortByDateDesc(expenses);
		return expenses;

	}

	@Transactional
	public BigDecimal getSumMonthExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.withDayOfMonth(1);
		LocalDate end = initial.withDayOfMonth(initial.getMonth().maxLength());

		return expenseDao.getSumExBetweenDates(start, end, profile.getId());

	}

	@Transactional
	public List<Expense> getYearExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.withMonth(Month.JANUARY.getValue()).withDayOfMonth(1);
		LocalDate end = initial.withMonth(Month.DECEMBER.getValue())
				.withDayOfMonth(initial.withMonth(12).getMonth().maxLength());
		List<Expense> expenses = expenseDao.getBetweenDates(start, end, profile.getId());
		sortByDateDesc(expenses);
		return expenses;
	}

	@Transactional
	public BigDecimal getSumYearExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);
		LocalDate initial = LocalDate.now();
		LocalDate start = initial.withMonth(Month.JANUARY.getValue()).withDayOfMonth(1);
		LocalDate end = initial.withMonth(Month.DECEMBER.getValue())
				.withDayOfMonth(initial.withMonth(12).getMonth().maxLength());

		return expenseDao.getSumExBetweenDates(start, end, profile.getId());
	}

	@Transactional
	public List<Expense> getAllExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);

		List<Expense> expenses = expenseDao.getExpenses(profile.getId());
		sortByDateDesc(expenses);
		
		return expenses;
	}

	@Transactional
	public BigDecimal getSumAllExpForUser(String login) {
		Profile profile = profileDao.getProfile(login);
		return expenseDao.getSumExAll(profile.getId());
	}

	@Transactional
	public BigDecimal getSumExpenseForPeriodAndUser(String period, String login) {
		BigDecimal sum = new BigDecimal("0");
		switch (period) {
		case "week":
			sum = getSumWeekExpForUser(login);
			break;
		case "month":
			sum = getSumMonthExpForUser(login);
			break;
		case "year":
			sum = getSumYearExpForUser(login);
			break;
		case "archive":
		default:
			break;
		}

		return sum;

	}

	@Transactional
	public List<Expense> getExpenseByPeriod(String period, String login) {
		List<Expense> expenses = new ArrayList<>();
		switch (period) {
		case "week":
			expenses = getWeekExpForUser(login);
			break;
		case "month":
			expenses = getMonthExpForUser(login);
			break;
		case "year":
			expenses = getYearExpForUser(login);
			break;
		case "archive":
			expenses = getAllExpForUser(login);
			break;
		default:
			expenses = new ArrayList<>();
			break;
		}
		return expenses;
	}

	@Transactional
	public BigDecimal getExpenseSummaryByPeriod(String period, String login) {
		BigDecimal sum = new BigDecimal("0");
		switch (period) {
		case "week":
			sum = getSumWeekExpForUser(login);
			break;
		case "month":
			sum = getSumMonthExpForUser(login);
			break;
		case "year":
			sum = getSumYearExpForUser(login);
			break;
		case "archive":
			sum = getSumAllExpForUser(login);
			break;
		default:
			break;
		}
		return sum;
	}

	@Transactional
	public Expense getExpense(Integer id, String login) throws NoPermissionException {
		Profile profile = profileDao.getProfile(login);
		Expense expense = expenseDao.get(id);
		if (expense.getProfile().getId() == profile.getId())
			return expense;
		else
			throw new NoPermissionException(
					"User has no permission to retrieve, expense ID:" + expense.getId() + ", User: " + login);
		

	}

	@Transactional
	public void saveChanges(Expense expense, String userLogin) throws NoPermissionException {
		Profile profile = profileDao.getProfile(userLogin);
		Expense expenseToUpdate = expenseDao.get(expense.getId());
		expenseToUpdate.merge(expense);
		if (expenseToUpdate.getProfile().getId() == profile.getId())
			expenseDao.update(expenseToUpdate);
		else
			throw new NoPermissionException(
					"User has no permission for update, expense ID:" + expense.getId() + ", User: " + userLogin);
	}
	
	@Transactional
	public String getSumExpenseForPeriodWithCurrencyAndUser(String period, String userLogin) {
		String currency =profileDao.getProfile(userLogin).getOptions().getCurrency();
		BigDecimal expensesSum = getSumExpenseForPeriodAndUser(period, userLogin);
		String expensesSumWithCurrency = expensesSum + " " + currency;
		return expensesSumWithCurrency;
	}
}
