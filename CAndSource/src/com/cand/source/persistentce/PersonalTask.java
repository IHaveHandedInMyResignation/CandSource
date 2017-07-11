package com.cand.source.persistentce;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries({ @NamedQuery(name = "PersonalTask.findListOfTasks", query = "from PersonalTask PT "
		+ "where PT.profile.id = :id "),

		@NamedQuery(name = "PersonalTask.findTasksBetweenDates", query = "from PersonalTask PT "
				+ "where PT.profile.id = :id " + "and PT.startDate " + "between :startDate and :finishDate "
				+ "order by PT.startDate asc"), })

@Entity
@Table(name = "PERSONAL_TASK")
public class PersonalTask {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotNull
	@NotEmpty
	@Size(min = 0, max = 15)
	@Column(name = "TITLE", nullable = false)
	private String title;

	@NotNull
	@NotEmpty
	@Size(min = 0, max = 65)
	@Column(name = "DESCRIPTION", nullable = true)
	private String description;

	@NotNull
	@NotEmpty
	@Size(min = 0, max = 1000)
	@Column(name = "FULL_TEXT", nullable = false)
	private String fullText;

	@Column(name = "CREATION_DATE", columnDefinition = "TIMESTAMP", nullable = false)
	private LocalDateTime creationDate;

	@Column(name = "ACTIVE", nullable = false)
	private boolean active;

	@NotNull
	@Column(name = "START_DATE", columnDefinition = "TIMESTAMP", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime startDate;

	@Column(name = "FINISH_DATE", columnDefinition = "TIMESTAMP", nullable = false)
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime finishDate;

	@Column(name = "REMINDER_DATE", columnDefinition = "TIMESTAMP", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime reminderDate;
	
	
	@Column(name = "LAST_MODIFICATION_DATE", columnDefinition = "TIMESTAMP", nullable = true)
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime lastModificationDate;
	
	@ManyToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;

	@Column(name = "ENABLED")
	private boolean enabled;

	public LocalDateTime getLastModificationDate() {
		return lastModificationDate;
	}

	public void setLastModificationDate(LocalDateTime lastModificationDate) {
		this.lastModificationDate = lastModificationDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFullText() {
		return fullText;
	}

	public void setFullText(String fullText) {
		this.fullText = fullText;
	}

	public LocalDateTime getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(LocalDateTime creationDate) {
		this.creationDate = creationDate;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public LocalDateTime getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDateTime startDate) {
		this.startDate = startDate;
	}

	public LocalDateTime getFinishDate() {
		return finishDate;
	}

	public void setFinishDate(LocalDateTime finishDate) {
		this.finishDate = finishDate;
	}
	
	
	public LocalDateTime getReminderDate() {
		return reminderDate;
	}

	public void setReminderDate(LocalDateTime reminderDate) {
		this.reminderDate = reminderDate;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "PersonalTask [id=" + id + ", title=" + title + ", description=" + description + ", fullText=" + fullText
				+ ", creationDate=" + creationDate + ", active=" + active + ", startDate=" + startDate + ", finishDate="
				+ finishDate + ", reminderDate=" + reminderDate;
	}

	public void merge(PersonalTask pt) {

		this.title = pt.getTitle() != null ? pt.getTitle() : title;
		this.description = pt.getDescription() != null ? pt.getDescription() : description;
		this.fullText = pt.getFullText() != null ? pt.getFullText() : fullText;
		this.startDate = pt.getStartDate() != null ? pt.getStartDate() : startDate;
		this.reminderDate = pt.getReminderDate() != null ? pt.getReminderDate() : reminderDate;
		this.finishDate = pt.getFinishDate() != null ? pt.getFinishDate() : finishDate;
		this.active = pt.isActive();

	}

}
