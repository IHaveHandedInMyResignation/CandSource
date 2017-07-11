package com.cand.source.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cand.source.persistentce.Profile;
import com.cand.source.persistentce.ProfileOptions;
import com.cand.source.service.ProfileService;

@Controller
@RequestMapping("/account")
public class AccountMaintenanceController {

	private static final String HOME_PAGE_VIEW = "home/index";
	private static final String NEW_ACCOUNT_VIEW = "account/newAccount";
	private static final String ACTIVATION_PAGE_VIEW = "account/accountActivation";
	private static final String OTHER_OPTIONS_VIEW = "account/options/other";
	private static final String PASSWORD_OPTIONS_VIEW = "account/options/password";
	private static final String PERSONAL_TASK_OPTIONS_VIEW = "account/options/task";
	private static final String EXPENSE_OPTIONS_VIEW = "account/options/expense";
	private static final String REDIRECT_MY_PROFILE_HOME = "redirect:/profile/";
	
	private ProfileService profileService;

	private Validator profileValidator;

	private Validator changePasswordValidator;
	
	@RequestMapping(value = "/new", method = RequestMethod.GET)
	public String showNewAccountForm(ModelMap map) {
		map.addAttribute("profile", new Profile());
		
		return NEW_ACCOUNT_VIEW;
	}

	@RequestMapping(value = "/new", method = RequestMethod.POST)
	public String newAccountCreation(@Valid @ModelAttribute("profile") Profile profile, BindingResult bindRes,
			ModelMap map) {
		profileValidator.validate(profile, bindRes);

		if (bindRes.hasErrors()) {
			map.addAttribute(profile);
			refreshNewAccErrors(map, bindRes);
			
			return NEW_ACCOUNT_VIEW;
		} else
			profileService.createNewAccount(profile);

		return HOME_PAGE_VIEW;
	}

	@RequestMapping(value = "/{login}/email/{code}/activation", method = RequestMethod.GET)
	public String verificationAccountEmail(@PathVariable("login") String login, @PathVariable("code") String code,
			ModelMap map) {

		if (profileService.activateAccount(login, code))
			map.addAttribute("activationMessage", "Account Activated");
		else
			map.addAttribute("activationMessage", "Account Activation Failed");

		return ACTIVATION_PAGE_VIEW;
	}
	
	@RequestMapping(value = { "/options/expense", "options/expense/" }, method = RequestMethod.GET)
	public String showExpenseOptions(ModelMap map, Principal principal) {
		ProfileOptions options = profileService.getOptions(principal.getName());
		map.addAttribute("options", options);
		return EXPENSE_OPTIONS_VIEW;
	}

	@RequestMapping(value = { "/options/expense", "options/expense/" }, method = RequestMethod.POST)
	public String updateExpenseOptions(@Valid @ModelAttribute("options") ProfileOptions options, BindingResult bindRes,
			ModelMap map, Principal principal) {
		profileService.updateExpenseOptions(principal.getName(), options);
		map.addAttribute("options", options);
		map.addAttribute("updateStatus", "Options Updated");
		return EXPENSE_OPTIONS_VIEW;
	}

	@RequestMapping(value = { "/options/task", "options/task/" }, method = RequestMethod.GET)
	public String showPersonalTaskOptions(ModelMap map, Principal principal) {

		return PERSONAL_TASK_OPTIONS_VIEW;
	}

	@RequestMapping(value = { "/options/other", "options/other/" }, method = RequestMethod.GET)
	public String showOtherOptions(ModelMap map, Principal principal) {

		map.addAttribute("profile_login", principal.getName());
		return OTHER_OPTIONS_VIEW;
	}

	@RequestMapping(value = { "options/other", "options/other/" }, method = RequestMethod.POST)
	public String profileImageUpload(@RequestParam("image") MultipartFile image, ModelMap map, Principal principal) {
		profileService.saveProfileImage(image, principal.getName());
		map.addAttribute("updateStatus", "Image has been changed.");
		return OTHER_OPTIONS_VIEW;
	}

	@RequestMapping(value = { "/options/password", "options/password/" }, method = RequestMethod.GET)
	public String showPasswordOptions(ModelMap map, Principal principal) {

		map.addAttribute("profile", new Profile());

		return PASSWORD_OPTIONS_VIEW;
	}

	@RequestMapping(value = { "/options/password", "options/password/" }, method = RequestMethod.POST)
	public String changePassword(@Valid @ModelAttribute("profile") Profile profile, BindingResult bindRes, ModelMap map,
			Principal principal) {
		changePasswordValidator.validate(profile, bindRes);
		if (bindRes.hasErrors()) {
			refreshChangePassowrdErrors(map, bindRes);

			return PASSWORD_OPTIONS_VIEW;
		}
		profileService.changePassword(principal.getName(), profile);

		return REDIRECT_MY_PROFILE_HOME;
	}
	
	private void refreshNewAccErrors(ModelMap map, BindingResult bindRes) {
		
		if (bindRes.getFieldError("login") != null)
			map.addAttribute("loginErr", bindRes.getFieldError("login").getCode());
		if (bindRes.getFieldError("firstName") != null)
			map.addAttribute("firstNameErr", bindRes.getFieldError("firstName").getCode());
		if (bindRes.getFieldError("lastName") != null)
			map.addAttribute("lastNameErr", bindRes.getFieldError("lastName").getCode());
		if (bindRes.getFieldError("email") != null)
			map.addAttribute("emailErr", bindRes.getFieldError("email").getCode());
		if (bindRes.getFieldError("password") != null)
			
			map.addAttribute("passwordErr", bindRes.getFieldError("password").getCode());
		if (bindRes.getFieldError("matchingPassword") != null)
			map.addAttribute("matchingPasswordErr", bindRes.getFieldError("matchingPassword").getCode());
	}
	
	private void refreshChangePassowrdErrors(ModelMap map, BindingResult bindRes) {
		if (bindRes.getFieldError("password") != null)
			map.addAttribute("passwordErr", bindRes.getFieldError("password").getCode());
		if (bindRes.getFieldError("matchingPassword") != null)
			map.addAttribute("matchingPasswordErr", bindRes.getFieldError("matchingPassword").getCode());
	}

	@Autowired
	public void setProfileService(ProfileService profileService) {
		this.profileService = profileService;
	}

	@Autowired
	@Qualifier("profileValidator")
	public void setProfileValidator(Validator profileValidator) {
		this.profileValidator = profileValidator;
	}

	@Autowired
	@Qualifier("changePasswordValidator")
	public void setChangePasswordValidator(Validator changePasswordValidator) {
		this.changePasswordValidator = changePasswordValidator;
	}

}
