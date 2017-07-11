package com.cand.source.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cand.source.persistentce.PersonalTask;
import com.cand.source.persistentce.ProfilePost;

@Component
public class ProfilePostDao implements BasicCrud<ProfilePost> {

	private static final Logger logger = Logger.getLogger(ProfilePostDao.class);
	
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {

		this.sessionFactory = sessionFactory;
	}

	@Override
	public ProfilePost get(Integer id) {
		try {
			return sessionFactory.getCurrentSession().get(ProfilePost.class, id);
		} catch (NoResultException e) {
			logger.debug("No result: ProfilePost id: " + id);
			// no action, just there is no result
		}

		return null;
	}

	@Override
	public void insert(ProfilePost entity) {

		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(ProfilePost entity) {

		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void fakeDelete(Integer id) {

		ProfilePost post = get(id);
		post.setEnabled(false);
		sessionFactory.getCurrentSession().update(post);

	}
	
	public List<ProfilePost> getLimitedProfilePosts(Integer profileId, Integer startPosition, Integer maxResult){
		Query query =  sessionFactory.getCurrentSession().getNamedQuery("ProfilePost.findTasksByProfileId")
				.setParameter("id", profileId).setFirstResult(startPosition)
				.setMaxResults(maxResult);
		List<ProfilePost> posts = query.getResultList();
		return posts;
	}

}
