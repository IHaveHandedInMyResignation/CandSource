package com.cand.source.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.cand.source.dao.ProfileDao;
import com.cand.source.dao.ProfilePostDao;
import com.cand.source.persistentce.ProfilePost;

@Component
public class ProfilePostService {
	
	@Autowired
	ProfilePostDao postDao;
	
	@Autowired
	ProfileDao profileDao;
	
	@Transactional
	public void insertNew(ProfilePost post, String userLogin){
		
		post.setCreationDate(LocalDateTime.now());
		post.setProfile(profileDao.getProfile(userLogin));
		post.setDisplayAccessLevel("A"); //	TODO, create dynamic choose
		post.setEnabled(true);
		postDao.insert(post);
	}
	@Transactional
	public void update(ProfilePost post){
		ProfilePost toUpdatePost = postDao.get(post.getId());
		toUpdatePost.merge(post);
		toUpdatePost.setLastModifyDate(LocalDateTime.now());
		postDao.update(toUpdatePost);
	}
	
	@Transactional
	public List<ProfilePost> getLimitedProfilePosts(String userLogin, Integer startPosition, Integer maxResult){
		Integer profileId = profileDao.getProfile(userLogin).getId();
		return postDao.getLimitedProfilePosts(profileId, startPosition, maxResult);
	}
	@Transactional
	public void delete(Integer id){
		
		postDao.fakeDelete(id);
	}
}
