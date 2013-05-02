package com.hosp.entities;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Action entity. @author MyEclipse Persistence Tools
 */
@Entity
@Cacheable(false)
@Table(name = "ACTION", schema = "HOSPITAL")
public class Action implements java.io.Serializable {

	// Fields

	private BigDecimal actionid;
	private Actionscategory actionscategory;
	private String name;
	private Set<Auditing> auditings = new HashSet<Auditing>(0);

	// Constructors

	/** default constructor */
	public Action() {
	}

	/** minimal constructor */
	public Action(BigDecimal actionid, String name) {
		this.actionid = actionid;
		this.name = name;
	}

	/** full constructor */
	public Action(BigDecimal actionid, Actionscategory actionscategory, String name, Set<Auditing> auditings) {
		this.actionid = actionid;
		this.actionscategory = actionscategory;
		this.name = name;
		this.auditings = auditings;
	}

	// Property accessors
	@Id
	@Column(name = "ACTIONID", unique = true, nullable = false, precision = 22, scale = 0)
	public BigDecimal getActionid() {
		return this.actionid;
	}

	public void setActionid(BigDecimal actionid) {
		this.actionid = actionid;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "CATEGORYID")
	public Actionscategory getActionscategory() {
		return this.actionscategory;
	}

	public void setActionscategory(Actionscategory actionscategory) {
		this.actionscategory = actionscategory;
	}

	@Column(name = "NAME", nullable = false, length = 300)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "action")
	public Set<Auditing> getAuditings() {
		return this.auditings;
	}

	public void setAuditings(Set<Auditing> auditings) {
		this.auditings = auditings;
	}

}