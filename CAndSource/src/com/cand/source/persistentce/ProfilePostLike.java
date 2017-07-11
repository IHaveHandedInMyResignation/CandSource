package com.cand.source.persistentce;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROFILE_POST_LIKE")
public class ProfilePostLike {

	@Id
	@GeneratedValue
	private int id;
	
	@ManyToOne
	@JoinColumn(name="ID_POST")
	private ProfilePost profilePost;
	
	@ManyToOne
	@JoinColumn(name="ID_POST_COMMENT")
	private ProfilePostComment profilePostComment;
	
	@Column(name="ID_WHO_LIKED")
	private int idWhoLiked;
	
	@Column(name="ID_PROFILE")
	private int idProfile;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ProfilePost getProfilePost() {
		return profilePost;
	}
	public void setProfilePost(ProfilePost profilePost) {
		this.profilePost = profilePost;
	}
	public ProfilePostComment getProfilePostComment() {
		return profilePostComment;
	}
	public void setProfilePostComment(ProfilePostComment profilePostComment) {
		this.profilePostComment = profilePostComment;
	}
	public int getIdWhoLiked() {
		return idWhoLiked;
	}
	public void setIdWhoLiked(int idWhoLiked) {
		this.idWhoLiked = idWhoLiked;
	}
	public int getIdProfile() {
		return idProfile;
	}
	public void setIdProfile(int idProfile) {
		this.idProfile = idProfile;
	}
	
	
	
}
