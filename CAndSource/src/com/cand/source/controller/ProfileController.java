package com.cand.source.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cand.source.persistentce.ProfilePost;
import com.cand.source.service.ProfilePostService;

@Controller
@RequestMapping("/profile")
public class ProfileController {

	private static final String MY_PROFILE_HOME = "profile/myProfile";
	private static final String REDIRECT_MY_PROFILE_HOME = "redirect:/profile/";
	private static final String NOTES_HISTORY_VIEW = "profile/noteHistory";

	private ProfilePostService profilePostService;

	@RequestMapping(value = { "", "/" }, method = RequestMethod.GET)
	public String showProfile(ModelMap map, Principal principal) {

		String userLogin = principal.getName();
		map.addAttribute("profile_login", userLogin);
		map.addAttribute("profilePost", new ProfilePost());
		List<ProfilePost> posts = profilePostService.getLimitedProfilePosts(userLogin, 0, 5);
		map.addAttribute("profile_posts", posts);

		return MY_PROFILE_HOME;
	}

	@RequestMapping(value = { "/note/new", "/note/new/" }, method = RequestMethod.POST)
	public String insertNewNote(@Valid @ModelAttribute("profilePost") ProfilePost profilePost, Principal principal) {
		profilePostService.insertNew(profilePost, principal.getName());

		return REDIRECT_MY_PROFILE_HOME;
	}

	@RequestMapping(value = { "/note/update", "/note/update/" }, method = RequestMethod.POST)
	public String updateNote(@Valid @ModelAttribute("profilePost") ProfilePost profilePost) {
		profilePostService.update(profilePost);

		return REDIRECT_MY_PROFILE_HOME;

	}

	@RequestMapping(value = "/note/history", method = RequestMethod.GET)
	public String showNoteHistory(@RequestParam(value = "page", required = false) Integer pageNumber, ModelMap map,
			Principal principal) {
		Integer nrPageCorrection = (pageNumber != null && pageNumber >= 1) ? pageNumber - 1 : 0;
		Integer fromNumberPosts = nrPageCorrection * 5;
		Integer maxResults = 5;
		List<ProfilePost> posts = profilePostService.getLimitedProfilePosts(principal.getName(), fromNumberPosts,
				maxResults);
		map.addAttribute("profile_posts", posts);
		map.addAttribute("pageNum", pageNumber);

		return NOTES_HISTORY_VIEW;
	}

	@Autowired
	public void setProfilePostService(ProfilePostService profilePostService) {
		this.profilePostService = profilePostService;
	}
}
