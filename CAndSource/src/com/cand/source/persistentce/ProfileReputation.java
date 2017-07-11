package com.cand.source.persistentce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROFILE_REPUTATION")
public class ProfileReputation {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ID_FORUM_POST")
	private ForumPost forumPost;
	
	@ManyToOne
	@JoinColumn(name="ID_FORUM_POST_ANSWER")
	private ForumPostAnswer forumPostAnswer;
	
	@Column(name="REPUTATION")
	private int reputation;
	
	@Column(name="ID_WHO_GIVE")
	private int idWhoGive;
	
	@ManyToOne
	@JoinColumn(name="ID_PROFILE")
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
	public int getIdWhoGive() {
		return idWhoGive;
	}
	public void setIdWhoGive(int idWhoGive) {
		this.idWhoGive = idWhoGive;
	}

	
	
}
