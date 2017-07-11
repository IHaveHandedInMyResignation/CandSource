package com.cand.source.service;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cand.source.account.activation.EmailSender;
import com.cand.source.dao.ProfileDao;
import com.cand.source.persistentce.PersonalTask;
import com.cand.source.persistentce.Profile;
import com.cand.source.persistentce.ProfileOptions;
import com.cand.source.persistentce.ProfileRole;

@Component
public class ProfileService {
	
	@Value("${default.currency}")
	private String DEFAULT_CURRENCY;
	
	@Value("${store.image.prefix}")
	private String IMAGE_STORE_PATH;
	
	@Autowired
	private ProfileDao dao;

	@Autowired
	private EmailSender mailSender;

	@Autowired
	private PasswordEncoder passwordEncoder;

	public void setDao(ProfileDao dao) {
		this.dao = dao;
	}

	public Profile getProfile(String userLogin) {
		return dao.getProfile(userLogin);
	}

	public Set<PersonalTask> getLastTasks(Integer profileId) {
		return null;
	}

	public PersonalTask getTask(Integer id) {
		return null;
	}

	public PersonalTask getLastTask(Integer profileId) {
		return null;
	}

	@Transactional
	public void createNewAccount(Profile profile) {
		profile.setCreationDate(LocalDateTime.now());
		encodePassoword(profile);
		setRoleForUser(profile);
		generateDefaultOptions(profile);
		sendActivationEmail(profile);
		
		dao.insert(profile);
	}


	@Transactional
	public boolean activateAccount(String login, String code) {

		Profile profile = dao.getProfile(login);

		if (code.equals(profile.getActivCode())) {
			profile.setEnabled(true);
			profile.setActivCode("");
			dao.update(profile);
			return true;
		}

		return false;
	}

	@Transactional
	public boolean profileExistByLogin(String userLogin) {
		if (dao.getProfile(userLogin) != null)
			return true;

		return false;
	}

	@Transactional
	public boolean profileExistByEmail(String email) {
		if (dao.getProfileByEmail(email) != null)
			return true;

		return false;
	}
	
	@Transactional
	public void changePassword(String userLogin, Profile profile) {
		encodePassoword(profile);
		Profile profileToUpdate = getProfile(userLogin);
		profileToUpdate.mergePassword(profile);
		dao.update(profileToUpdate);
	}

	private void encodePassoword(Profile profile){
		profile.setPassword(passwordEncoder.encode(profile.getPassword().trim()));
	}
	
	private void setRoleForUser(Profile profile) {
		profile.getRoles().add(new ProfileRole(profile, "ROLE_ADMIN"));
	}

	private void sendActivationEmail(Profile profile) {
		String activCode = UUID.randomUUID().toString();
		mailSender.sendActivationEmailMsg(profile, activCode);
		profile.setActivCode(activCode);
	}

	private void generateDefaultOptions(Profile profile) {
		ProfileOptions options = new  ProfileOptions();
		options.setProfile(profile);
		options.setCurrency(DEFAULT_CURRENCY);
		profile.setOptions(options);
	}
	
	@Transactional
	public ProfileOptions getOptions(String userLogin) {
		Profile profile = getProfile(userLogin);
		ProfileOptions options = profile.getOptions() !=null ? profile.getOptions() : new ProfileOptions();
		return options;
	}
	
	@Transactional
	public void updateExpenseOptions(String userLogin, ProfileOptions options) {
		Profile profile = getProfile(userLogin);
		ProfileOptions optionsToUpdate = profile.getOptions() != null ? profile.getOptions() : new ProfileOptions();
		optionsToUpdate.setProfile(profile);
		optionsToUpdate.setCurrency(options.getCurrency());
		profile.setOptions(optionsToUpdate);
		dao.update(profile);
	}
	
	@Transactional
	public String getCurrency(String userLogin) {
		
		return getProfile(userLogin).getOptions().getCurrency();
	}

	
	public void saveProfileImage(MultipartFile multipartFile, String userLogin) {
		
		String fileSuffix = "." + FilenameUtils.getExtension(multipartFile.getOriginalFilename());
		try {
			multipartFile.transferTo(new File(IMAGE_STORE_PATH+userLogin + fileSuffix));
		} catch (IllegalStateException | IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
}
