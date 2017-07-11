package com.cand.source.persistentce;

import java.util.Comparator;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

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
@Table(name="FORUM_POST")
public class ForumPost {

	@Id @GeneratedValue
	@Column(name = "ID")
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
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;
	
	@OneToMany(mappedBy = "forumPost", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<ForumPostAnswer> postAnswers;
	
	@OneToMany(mappedBy = "forumPost", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<ProfileReputation> profileReputations;
	
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
	public Date getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(Date lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date date) {
		this.creationDate = date;
	}
	public boolean isDisplayAccessLevel() {
		return displayAccessLevel;
	}
	public void setDisplayAccessLevel(boolean displayAccessLevel) {
		this.displayAccessLevel = displayAccessLevel;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	@Override
	public String toString() {
		return "ForumPost [id=" + id + ", text=" + text + ", creationDate=" + creationDate + ", lastModifyDate="
				+ lastModifyDate + ", displayAccessLevel=" + displayAccessLevel +"]\n"
				+ postAnswers.stream()
									//.sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId()))
									.sorted(Comparator.comparing(ForumPostAnswer::getId))
									.map(Object::toString)
									.collect(Collectors.joining("\n"));
	}

	
	
}
