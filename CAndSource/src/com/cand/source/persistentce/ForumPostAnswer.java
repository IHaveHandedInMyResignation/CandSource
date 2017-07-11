package com.cand.source.persistentce;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="FORUM_POST_ANSWER")
public class ForumPostAnswer {

	@Id @GeneratedValue
	private int id;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "CREATION_DATE")
	private Date creationDate;
	
	@Column(name = "LAST_MODIFY_DATE")
	private Date lastModifyDate;
	
	
	@Column(name = "DISPLAY_ACCESS_LEVEL")
	private boolean displayAccessLevel;

	@ManyToOne
	@JoinColumn(name = "ID_FORUM_POST")
	private ForumPost forumPost;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;
	
	@OneToMany(mappedBy = "forumPostAnswer", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<ProfileReputation> profileReputation;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Date getDate() {
		return creationDate;
	}
	public void setDate(Date date) {
		this.creationDate = date;
	}
	public boolean isDisplayAccessLevel() {
		return displayAccessLevel;
	}
	public void setDisplayAccessLevel(boolean displayAccessLevel) {
		this.displayAccessLevel = displayAccessLevel;
	}
	public Profile getIdProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public ForumPost getForumPost() {
		return forumPost;
	}
	public void setForumPost(ForumPost forumPost) {
		this.forumPost = forumPost;
	}
	@Override
	public String toString() {
		return "ForumPostAnswer [id=" + id + ", text=" + text + ", creationDate=" + creationDate + ", lastModifyDate="
				+ lastModifyDate + ", displayAccessLevel=" + displayAccessLevel + "]";
	}
	
}
