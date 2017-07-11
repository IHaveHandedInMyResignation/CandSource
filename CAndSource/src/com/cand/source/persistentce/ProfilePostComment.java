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
@Table(name="PROFILE_POST_COMMENT")
public class ProfilePostComment {

	@Id
	@GeneratedValue
	private int id;
	@Column(name="TEXT")
	private String text;
	@Column(name="CREATION_DATE")
	private Date creationDate;
	@Column(name="LAST_MODIFY_DATE")
	private Date lastModifyDate;
	@Column(name="DISPLAY_ACCESS_LEVEL")
	private boolean displayAccessLevel;
	
	@ManyToOne
	@JoinColumn(name="ID_PROFILE_POST")
	private ProfilePost profilePost;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;
	
	@OneToMany(mappedBy = "profilePostComment", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<ProfilePostLike> profilePostLikes;	
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

}
