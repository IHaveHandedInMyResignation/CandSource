package com.cand.source.persistentce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "PROFILE_OPTIONS")
public class ProfileOptions {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;
	
	@Column(name = "CURRENCY")
	private String currency;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	
}
