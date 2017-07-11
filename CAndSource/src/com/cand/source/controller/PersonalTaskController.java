package com.cand.source.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cand.source.persistentce.PersonalTask;
import com.cand.source.service.PersonalTaskService;
import com.cand.source.utils.DateTimeUtils;

@Controller
@RequestMapping("/taskmgr")
public class PersonalTaskController {
	private static final Logger logger = Logger.getLogger(PersonalTaskController.class);
	
	private static final String TASK_MANAGER_HOME = "task/taskManager";
	private static final String PROFILE_PAST_TASKS ="task/pastTasks";
	private static final String	PROFILE_UPCOMING_TASKS ="task/upcomingTasks";
	private static final String EDIT_TASK = "task/editTask";
	
	
	@Autowired
	private PersonalTaskService ptService;
	
	
	@RequestMapping(value = {"", "/"}, method = RequestMethod.GET)
	public String showTaskMgrHome(ModelMap map, Principal principal){
		map.addAttribute("personalTask", new PersonalTask());
		System.out.println(principal.getName());
		
		List<PersonalTask> upcommingTasks = ptService.getLimitedUpcomingTasks(principal.getName(), 0, 4);
		List<PersonalTask> pastTasks = ptService.getLimitedPastTasks(principal.getName(), 0, 4);
		
		map.addAttribute("upcomingTasks", upcommingTasks);
		map.addAttribute("pastTasks", pastTasks);
		
		return TASK_MANAGER_HOME;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addProfileTask(@Valid @ModelAttribute("personalTask")PersonalTask task, BindingResult bindRes, ModelMap map, Principal principal){
		logger.info("User: " + principal.getName() + ", Method: " + "/taskmgr/add");
		
		List<PersonalTask> upcommingTasks = ptService.getLimitedUpcomingTasks(principal.getName(), 0, 4);
		List<PersonalTask> pastTasks = ptService.getLimitedPastTasks(principal.getName(), 0, 4);
		map.addAttribute("upcomingTasks", upcommingTasks);
		map.addAttribute("pastTasks", pastTasks);
		
		if(bindRes.hasErrors()){
			bindRes.getFieldErrors().forEach(x-> logger.debug(x));
			map.addAttribute("validError","Not optional fields have to be initialized.");			
			return TASK_MANAGER_HOME;
		}
		
		if(DateTimeUtils.validatePersonalTaskDateTimes(task.getReminderDate(), task.getStartDate(), task.getFinishDate())){
			ptService.insertNewTask(task, principal.getName());
			return "redirect:/taskmgr?result=added";
		}
		map.addAttribute("validError", "Times are incorrect. \nReminder Date&Time should be before start and finish date\n Finish Date&Time should be after start date.");
		return TASK_MANAGER_HOME;
	}
	
	@RequestMapping(value = "/past", method = RequestMethod.GET)
	public String showPastTasks(@RequestParam(value = "page", required = false) Integer pageNumber, ModelMap map, Principal principal){
		
		Integer nrPageCorrection = (pageNumber!=null && pageNumber>=1) ? pageNumber-1 : 0;
		Integer fromNumberTasks= nrPageCorrection*5;
		Integer maxResults = 5;
		List<PersonalTask> pastTasks = ptService.getLimitedPastTasks(principal.getName(), fromNumberTasks, maxResults);
		map.addAttribute("pastTasks", pastTasks);
		map.addAttribute("pageNum", pageNumber);
		
		
		return PROFILE_PAST_TASKS;
	}
	
	@RequestMapping(value = "/upcoming", method = RequestMethod.GET)
	public String showUpcomingTasks(@RequestParam(value = "page", required = false) Integer pageNumber, ModelMap map, Principal principal){
		
		Integer nrPageCorrection = (pageNumber!=null && pageNumber>=1) ? pageNumber-1: 0;
		Integer fromNumberTasks= nrPageCorrection*5;
		
		List<PersonalTask> upcommingTasks = ptService.getLimitedUpcomingTasks(principal.getName(), fromNumberTasks, 5);
		map.addAttribute("upcomingTasks", upcommingTasks);
		map.addAttribute("pageNum", pageNumber);
		return PROFILE_UPCOMING_TASKS;
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String showEditUpcommingTask(@RequestParam("id") Integer id, ModelMap map, Principal principal){
		logger.debug("taskmgr/edit id: " + id);
		
		map.addAttribute("personalTask",ptService.getTask(id));
		return EDIT_TASK;
	} 
	@RequestMapping(value = "/edit/accepted", method = RequestMethod.POST)
	public String showAcceptEditUpcommingTask(@Valid @ModelAttribute("personalTask")PersonalTask task, ModelMap map, Principal principal){
		logger.debug("taskmgr/edit/accepted updated Task: " + task.toString());
		ptService.updateTask(task);
		return EDIT_TASK;
	} 
	
	
}
