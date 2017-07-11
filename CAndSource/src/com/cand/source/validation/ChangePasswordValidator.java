package com.cand.source.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cand.source.persistentce.Profile;

@Component
public class ChangePasswordValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Profile.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Profile profile =(Profile)target;
		refreshPasswordErrors(profile, errors);
		
	}

	private void refreshPasswordErrors(Profile profile, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "Password field is required. ");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "matchingPassword", "Confirmation field is required. ");

		if (profile.getPassword().length() < 5)
			errors.rejectValue("password", "Password must have minimum 5 letters. ");

		if (!profile.getPassword().equals(profile.getMatchingPassword()))
			errors.rejectValue("matchingPassword", "The confirmation does not match the password. ");
		
	}

}
