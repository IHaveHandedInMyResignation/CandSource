package com.cand.source.controller;

import java.security.Principal;
import java.time.LocalDateTime;

import javax.naming.NoPermissionException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cand.source.persistentce.Expense;
import com.cand.source.service.ExpenseService;
import com.cand.source.service.ProfileService;

@Controller
@RequestMapping("/expenses")
public class ExpensesController {
	private static final Logger logger = Logger.getLogger(ExpensesController.class);
	private static final String CREATE_NEW_RECEIPT_TAB_VIEW = "expense/newReceiptTab";
	private static final String EXPENSES_TAB_VIEW = "expense/expensesTab";
	private static final String EXPENSES_SUMMARY_VIEW = "expense/summary";
	private static final String INSERT_RECEIPT_PRICE_VIEW = "expense/receiptPrice";
	private static final String SELECT_RECEIPT_DATE_VIEW = "expense/receiptDate";
	private static final String REDIRECT_TO_HOME_EXPENSES_VIEW = "redirect:/expenses/";
	private static final String SHOW_VIEW = "expense/showExpense";
	private static final String EDIT_VIEW = "expense/editExpense";
	private static final String USER_HAS_NO_PERMISSION_VIEW = "home/noPermission";
	@Autowired
	private ExpenseService expenseService;
	
	@Autowired
	private ProfileService profileService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String showNewReceiptTab() {

		return CREATE_NEW_RECEIPT_TAB_VIEW;
	}

	@RequestMapping(value = { "/view", "/view/" }, method = RequestMethod.GET)
	public String showExpensesView0(ModelMap map, Principal principal) {
		String currency = profileService.getCurrency(principal.getName());
		map.addAttribute("expenseWeek", expenseService.getSumExpenseForPeriodWithCurrencyAndUser("week", principal.getName()));
		map.addAttribute("expenseMonth", expenseService.getSumExpenseForPeriodWithCurrencyAndUser("month", principal.getName()));
		map.addAttribute("expenseYear", expenseService.getSumExpenseForPeriodWithCurrencyAndUser("year", principal.getName()));

		return EXPENSES_TAB_VIEW;
	}

	@RequestMapping(value = { "/view/summary" }, method = RequestMethod.GET)
	public String showExpensesViewSummary(@RequestParam("period") String period, ModelMap map, Principal principal) {
		String userLogin = principal.getName();
		
		map.addAttribute("expenses", expenseService.getExpenseByPeriod(period, userLogin));
		map.addAttribute("expensesSummary", expenseService.getExpenseSummaryByPeriod(period, userLogin));
		map.addAttribute("currency", profileService.getCurrency(userLogin));

		return EXPENSES_SUMMARY_VIEW;
	}

	@RequestMapping(value = { "/view/{type}" }, method = RequestMethod.GET)
	public String showEditOrShow(@PathVariable String type, @RequestParam("id") Integer id, ModelMap map,
			Principal principal) {

		Expense expense;
		try {
			expense = expenseService.getExpense(id, principal.getName());
			map.addAttribute("expense", expense);
		} catch (NoPermissionException e) {
			logger.error(e.getMessage());
			return USER_HAS_NO_PERMISSION_VIEW;
		}

		if ("edit".equals(type))
			return EDIT_VIEW;
		return SHOW_VIEW;
	}

	@RequestMapping(value = { "/price", "/price/" }, method = RequestMethod.GET)
	public String showNewReceiptPrice(ModelMap map) {
		map.addAttribute("expense", new Expense());

		return INSERT_RECEIPT_PRICE_VIEW;
	}

	@RequestMapping(value = { "/price/add", "/price/add/" }, method = RequestMethod.POST)
	public String showAcceptedNewReceiptPrice(@Valid @ModelAttribute("expense") Expense expense, BindingResult bindRes,
			HttpServletRequest request, ModelMap map, HttpSession session, Principal principal) {
		logger.debug("Request: /expenses/price/add POST, expense: " + expense.toString());

		if (bindRes.hasErrors() && (bindRes.getErrorCount() == 1 && bindRes.getFieldError("date").equals(null))) {
			bindRes.getFieldErrors().forEach(x -> logger.debug(x));
			map.addAttribute("validError", "All fields are required");
			return INSERT_RECEIPT_PRICE_VIEW;
		}
		
		String action = request.getParameter("clickBtn");
		if ("addReceipt".equals(action)) {
			expenseService.insertNewExpense(expense, principal.getName(), true);
		} else if ("generateDate".equals(action)) {
			session.setAttribute("expense", expense);

			return SELECT_RECEIPT_DATE_VIEW;
		}

		return REDIRECT_TO_HOME_EXPENSES_VIEW;
	}

	@RequestMapping(value = { "/view/edit/accepted" }, method = RequestMethod.POST)
	public String editAccepted(@Valid @ModelAttribute("expense") Expense expense, Principal principal) {
		logger.debug("Request: /expenses/view/edit/accepted POST, expense: " + expense.toString());
		try {
			expenseService.saveChanges(expense, principal.getName());
		} catch (NoPermissionException e) {
			logger.error(e.getMessage());

			return USER_HAS_NO_PERMISSION_VIEW;
		}
		return REDIRECT_TO_HOME_EXPENSES_VIEW;
	}

	@RequestMapping(value = { "/price/add/date", "/price/add/date/" }, method = RequestMethod.POST)
	public String showGenerateReceiptDate(
			@RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss") LocalDateTime dateTime,
			HttpSession session, Principal principal) {
		Expense expense = (Expense) session.getAttribute("expense");
		logger.debug("Request: /expenses/price/added/date POST, expense: " + expense.toString());
		
		
		expense.setDate(dateTime);
		expenseService.insertNewExpense(expense, principal.getName(), false);
		
		session.removeAttribute("expense");

		return REDIRECT_TO_HOME_EXPENSES_VIEW;
	}

}
