package com.cand.source.persistentce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name = "PROFILE_ROLE")
public class ProfileRole {

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "LOGIN", referencedColumnName = "LOGIN")
	private Profile profile;
	
	@NotNull
	@NotEmpty
	@Column(name = "ROLE")
	private String role;

	
	public ProfileRole() {
		super();
	}

	public ProfileRole(Profile profile, String role) {
		super();
		this.profile = profile;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
