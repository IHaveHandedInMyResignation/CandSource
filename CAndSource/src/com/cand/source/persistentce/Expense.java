package com.cand.source.persistentce;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@NamedQueries({ @NamedQuery(name = "Expense.getForUser", query = "from Expense ex where ex.profile.id=:id"),

		@NamedQuery(name = "Expense.getCountForUser", query = "select count(*) from Expense ex where ex.profile.id=:id"),

		@NamedQuery(name = "Expense.getForUserBetweenDates", query = "from Expense ex where ex.profile.id=:id" + " and"
				+ " ex.date between :startDate and :endDate"),

		@NamedQuery(name = "Expense.getCountForUserBetweenDates", query = "select count (*)from Expense ex where ex.profile.id=:id"
				+ " and" + " ex.date between :startDate and :endDate") })
@Entity
@Table(name = "EXPENSE")
public class Expense {

	@Id
	@GeneratedValue
	@Column(name = "ID")
	private int id;

	@ManyToOne
	@JoinColumn(name = "ID_PROFILE")
	private Profile profile;

	@Column(name = "TYPE")
	private String type;

	@NotNull
	@Column(name = "COST")
	private BigDecimal cost;

	@NotNull
	@NotEmpty
	@Column(name = "DESCRIPTION")
	private String description;

	@NotNull
	@Column(name = "DATE", columnDefinition = "TIMESTAMP")
	@DateTimeFormat(pattern = "yyyy-MM-dd' 'HH:mm:ss")
	private LocalDateTime date;

	@Column(name = "ENABLED")
	private boolean enabled;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public BigDecimal getCost() {
		return cost;
	}

	public void setCost(BigDecimal cost) {
		this.cost = cost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "Expense [id=" + id + ", type=" + type + ", cost=" + cost + ", description=" + description + ", date="
				+ date + "]";
	}

	public void merge(Expense expense) {

		this.type = expense.getType() != null ? expense.getType() : type;
		this.cost = expense.getCost() != null ? expense.getCost() : cost;
		this.description = expense.getDescription() != null ? expense.getDescription() : description;
		this.date = expense.getDate() != null ? expense.getDate() : date;
	}

}
