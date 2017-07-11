package com.cand.source.validation;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cand.source.persistentce.Profile;
import com.cand.source.service.ProfileService;

@Component
public class ProfileValidator implements Validator {

	@Autowired
	private ProfileService profileService;

	private static final Pattern emailPattern = Pattern
			.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

	@Override
	public boolean supports(Class<?> clazz) {
		return Profile.class.equals(clazz);
	}

	@Override
	@Transactional
	public void validate(Object target, Errors errors) {
		Profile profile = (Profile) target;

		refreshLoginValidation(profile, errors);
		refreshFirstNameValidation(profile, errors);
		refreshLastNameValidation(profile, errors);
		refreshEmailValidation(profile, errors);

		refreshPasswordValidation(profile, errors);
	}

	private void refreshLoginValidation(Profile profile, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "login", "Username field is required. ");

		if (profile.getLogin().length() < 5)
			errors.rejectValue("login", "Login must have minimum 5 letters. ");
		if (profileService.profileExistByLogin(profile.getLogin()) == true)
			errors.rejectValue("login", "Username already exists in the database. ");
	}

	private void refreshFirstNameValidation(Profile profile, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstName", "First Name field is required. ");
	}

	private void refreshLastNameValidation(Profile profile, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastName", "Last Name field is required. ");
	}

	private void refreshEmailValidation(Profile profile, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "E-mail field is required. ");

		if (profileService.profileExistByEmail(profile.getEmail()) == true)
			errors.rejectValue("email", "Email is incorrect or already exists in the database. ");
		if (!emailPattern.matcher(profile.getEmail()).matches())
			errors.rejectValue("email", "Email field does not look like email. ");
	}

	private void refreshPasswordValidation(Profile profile, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password field is required. ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matchingPassword", "Confirmation field is required. ");

		if (profile.getPassword().length() < 5)
			errors.rejectValue("password", "Password must have minimum 5 letters. ");

		if (!profile.getPassword().equals(profile.getMatchingPassword()))
			errors.rejectValue("matchingPassword", "The confirmation does not match the password. ");
	}

}
