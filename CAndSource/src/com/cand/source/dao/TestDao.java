package com.cand.source.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.cand.source.persistentce.Profile;

@Component
public class TestDao {

	@Autowired
	private DataSource ds;
	
	public void setDs(DataSource ds) {
		this.ds = ds;
	}
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session currentSession(){
		return sessionFactory.getCurrentSession();
	}
	public TestDao(){
		System.out.println(ds);
	}
	
	public Profile getProfile(int id){
		
		return (Profile) currentSession().get(Profile.class, id);
	}
	
	public List<Profile> getTest(){
		String testSql = "Select * from Profile";
		JdbcTemplate jdbctmplt = new JdbcTemplate(ds);
		List<Profile> list = jdbctmplt.query(testSql, new RowMapper<Profile>(){

			@Override
			public Profile mapRow(ResultSet rs, int rowNum) throws SQLException {
				Profile profile = new Profile();
				profile.setId(rs.getInt("ID"));
				return profile;
			}});
		
		/*	@Override
			public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
				Profile profile = new Profile();
				profile.setId(rs.getInt("ID"));
				profile.setFirstName("FIRST_NAME");
				return profile;
			}
		}).;*/
		return list;
	}
}
