package com.cand.source.persistentce;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@NamedQueries({
	@NamedQuery(name = "Profile.getProfile", 
				query = "from Profile where login= :login"),
	
	@NamedQuery(name = "Profile.getProfileByEmail", 
				query = "from Profile where email= :email"),
	
	@NamedQuery(name = "Profile.updateActivCode",
				query = "update Profile "
						+ "set activCode= :code "
						+ "where login= :login")
	})
@Entity
@Table(name = "PROFILE")
public class Profile implements Serializable{
	@Transient
	private static final long serialVersionUID = 3528152595052755797L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "LOGIN")
	private String login;
	
	@Column(name = "FIRST_NAME")
	private String firstName;
	
	@Column(name = "LAST_NAME")
	private String lastName;
	
	@Column(name = "FULL_NAME")
	private String fullName;
	
	@Column(name = "CREATION_DATE", columnDefinition="TIMESTAMP")
	private LocalDateTime creationDate;
	
	@Column(name = "BIRTH_DATE", columnDefinition="DATETIME")
	private LocalDateTime birthDate;
	
	@Column(name = "EMAIL")
	private String email;
	
	@Column(name = "SUBSCRIPTION")
	private boolean subscription;
	
	@Column(name = "PHONE_NUMBER")
	private String phoneNumber;
	
	@Column(name = "LOGIN_COUNTER")
	private long loginCounter;
	
	@Column(name = "PASSWORD")
	private String password;
	@Transient
	private String matchingPassword;
	
	@Column(name = "ENABLED")
	private boolean enabled;
	
	@Column(name = "ACTIV_CODE")
	private String activCode;
	
	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<ForumPost> forumPosts;
	
	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<ForumPostAnswer> postAnswers;
	
	@OneToOne(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private ProfileForumReputation profileForumReputation;
	
	@OneToOne(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private ProfileLike profileLikes;
	
	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<ProfilePost> profilePosts;
	
	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<ProfilePostComment> profilePostComments;
	
	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<PersonalTask> personalTasks;
	
	@OneToMany(mappedBy = "profile", cascade={CascadeType.PERSIST, CascadeType.MERGE}, fetch = FetchType.LAZY)
	private Set<Expense> expenses;
	
	@OneToMany(mappedBy = "profile", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<ProfileRole> roles = new HashSet<>();
	
	@OneToOne(mappedBy = "profile", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	private ProfileOptions options;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public LocalDateTime getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(LocalDateTime birthDate) {
		this.birthDate = birthDate;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean isSubscription() {
		return subscription;
	}

	public void setSubscription(boolean subscription) {
		this.subscription = subscription;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public long getLoginCounter() {
		return loginCounter;
	}

	public void setLoginCounter(long loginCounter) {
		this.loginCounter = loginCounter;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMatchingPassword() {
		return matchingPassword;
	}

	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getActivCode() {
		return activCode;
	}

	public void setActivCode(String activCode) {
		this.activCode = activCode;
	}

	public Set<ForumPost> getForumPosts() {
		return forumPosts;
	}

	public void setForumPosts(Set<ForumPost> forumPosts) {
		this.forumPosts = forumPosts;
	}

	public Set<ForumPostAnswer> getPostAnswers() {
		return postAnswers;
	}

	public void setPostAnswers(Set<ForumPostAnswer> postAnswers) {
		this.postAnswers = postAnswers;
	}

	public ProfileForumReputation getProfileForumReputation() {
		return profileForumReputation;
	}

	public void setProfileForumReputation(ProfileForumReputation profileForumReputation) {
		this.profileForumReputation = profileForumReputation;
	}

	public ProfileLike getProfileLikes() {
		return profileLikes;
	}

	public void setProfileLikes(ProfileLike profileLikes) {
		this.profileLikes = profileLikes;
	}

	public Set<ProfilePost> getProfilePosts() {
		return profilePosts;
	}

	public void setProfilePosts(Set<ProfilePost> profilePosts) {
		this.profilePosts = profilePosts;
	}

	public Set<ProfilePostComment> getProfilePostComments() {
		return profilePostComments;
	}

	public void setProfilePostComments(Set<ProfilePostComment> profilePostComments) {
		this.profilePostComments = profilePostComments;
	}

	public Set<PersonalTask> getPersonalTasks() {
		return personalTasks;
	}

	public void setPersonalTasks(Set<PersonalTask> personalTasks) {
		this.personalTasks = personalTasks;
	}

	public Set<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Set<Expense> expenses) {
		this.expenses = expenses;
	}

	public Set<ProfileRole> getRoles() {
		return roles;
	}

	public void setRoles(Set<ProfileRole> roles) {
		this.roles = roles;
	}
	
	public void  mergePassword(Profile profile){
		this.password = profile.getPassword();
	}
	
	public ProfileOptions getOptions() {
		return options;
	}

	public void setOptions(ProfileOptions options) {
		this.options = options;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", login=" + login + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", fullName=" + fullName + ", creationDate=" + creationDate + ", birthDate=" + birthDate + ", email="
				+ email + ", subscription=" + subscription + ", phoneNumber=" + phoneNumber + ", loginCounter="
				+ loginCounter + ", password=" + password + ", matchingPassword=" + matchingPassword + ", enabled="
				+ enabled + "]";
	}
	
	
/*
	@Override
	public String toString() {
		
		return "Profile [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", fullName=" + fullName
				+ ", creationDate=" + creationDate + ", birthDate=" + birthDate + ", email=" + email + ", subscription="
				+ subscription + ", phoneNumber=" + phoneNumber + ", loginCounter=" + loginCounter + ", \n\nPOSTS:\n" 
				+ forumPosts.stream()
									//.sorted((e1, e2) -> Integer.compare(e1.getId(), e2.getId()))
									.sorted(Comparator.comparing(ForumPost::getId))
									.map(Object::toString)
									.collect(Collectors.joining("\n"));
	}
*/
}
