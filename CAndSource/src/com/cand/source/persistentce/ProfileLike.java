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
@Table(name="PROFILE_LIKE")
public class ProfileLike {

	@Id @GeneratedValue
	private int id;
	
	@Column(name = "LIKES")
	private int likes;
	

	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<ProfileLike> profileLikes;
	
	@OneToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;
}
