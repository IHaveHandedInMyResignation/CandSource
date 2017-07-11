package com.cand.source.persistentce;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@NamedQueries({ 
		@NamedQuery(name = "ProfilePost.findTasksByProfileId", 
				query = "from ProfilePost PP "
				+ "where PP.profile.id = :id "
				+ "order by PP.creationDate desc"), })
@Entity
@Table(name="PROFILE_POST")
public class ProfilePost {
	
	@Id @GeneratedValue
	private int id;
	
	@Column(name = "TEXT")
	private String text;
	
	@Column(name = "CREATION_DATE", columnDefinition="TIMESTAMP", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime creationDate;
	
	@Column(name = "LAST_MODIFY_DATE", columnDefinition="TIMESTAMP", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime lastModifyDate;
	
	@Column(name = "DISPLAY_ACCESS_LEVEL")
	private String displayAccessLevel;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;
	
	@OneToMany(mappedBy = "profilePost", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
	private Set<ProfilePostComment> profilePostComments;
	
	@Column(name = "ENABLED")
	private boolean enabled;
	
	@OneToMany(mappedBy = "profilePost", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.EAGER)
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
	public LocalDateTime getLastModifyDate() {
		return lastModifyDate;
	}
	public void setLastModifyDate(LocalDateTime lastModifyDate) {
		this.lastModifyDate = lastModifyDate;
	}
	public LocalDateTime getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(LocalDateTime date) {
		this.creationDate = date;
	}
	public String getDisplayAccessLevel() {
		return displayAccessLevel;
	}
	public void setDisplayAccessLevel(String displayAccessLevel) {
		this.displayAccessLevel = displayAccessLevel;
	}
	public Profile getProfile() {
		return profile;
	}
	public void setProfile(Profile profile) {
		this.profile = profile;
	}
	public Set<ProfilePostComment> getProfilePostComments() {
		return profilePostComments;
	}
	public void setProfilePostComments(Set<ProfilePostComment> profilePostComments) {
		this.profilePostComments = profilePostComments;
	}
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public Set<ProfilePostLike> getProfilePostLikes() {
		return profilePostLikes;
	}
	public void setProfilePostLikes(Set<ProfilePostLike> profilePostLikes) {
		this.profilePostLikes = profilePostLikes;
	}
	public void merge(ProfilePost post) {
		this.text = post.getText() !=null? post.getText(): text;
	}

}
