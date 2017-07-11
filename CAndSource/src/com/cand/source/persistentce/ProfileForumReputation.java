package com.cand.source.persistentce;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="PROFILE_FORUM_REPUTATION")
public class ProfileForumReputation {
	
	@Id @GeneratedValue
	private int id;
	 
	@Column(name = "REPUTATION")
	private int reputation;
	
	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<ProfileReputation> profileReputation;
	
	@OneToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getReputation() {
		return reputation;
	}

	public void setReputation(int reputation) {
		this.reputation = reputation;
	}

	public Set<ProfileReputation> getProfileReputation() {
		return profileReputation;
	}

	public void setProfileReputation(Set<ProfileReputation> profileReputation) {
		this.profileReputation = profileReputation;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	
	
	

}
