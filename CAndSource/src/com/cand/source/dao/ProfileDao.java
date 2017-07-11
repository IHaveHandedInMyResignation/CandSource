package com.cand.source.dao;

import javax.persistence.NoResultException;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cand.source.persistentce.Profile;

@Component
public class ProfileDao implements BasicCrud<Profile>{

	
	@Autowired
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Profile get(Integer id) {
		
		return (Profile)sessionFactory.getCurrentSession().get(Profile.class, id);
	}

	@Override
	public void insert(Profile entity) {
		
		sessionFactory.getCurrentSession().save(entity);
	}

	@Override
	public void update(Profile entity) {
		
		sessionFactory.getCurrentSession().update(entity);
	}

	@Override
	public void fakeDelete(Integer id) {
		
		Profile profile = sessionFactory.getCurrentSession().get(Profile.class, id);
		profile.setEnabled(false);
		sessionFactory.getCurrentSession().update(profile);
	} 
	
	public Profile getProfile(String userLogin){
		Profile profile = null;
		try {
			profile = (Profile) sessionFactory.getCurrentSession().createNamedQuery("Profile.getProfile").setParameter("login", userLogin).getSingleResult();
		} catch (NoResultException e) {
			//no action, just there is no result
		}
		
		return profile;
	}

	public Profile getProfileByEmail(String email) {
		Profile profile = null;
		try {
			profile = (Profile) sessionFactory.getCurrentSession().createNamedQuery("Profile.getProfileByEmail").setParameter("email", email).getSingleResult();
		} catch (NoResultException e) {
			//no action, just there is no result
		}
		
		return profile;
	}
	
	public void updateActivationCode(String userLogin, String code){
		sessionFactory.getCurrentSession().createNamedQuery("Profile.updateActivCode").setParameter("login", userLogin).setParameter("code", code).executeUpdate();
	}

}
