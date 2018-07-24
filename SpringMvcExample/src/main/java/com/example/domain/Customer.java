/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "CUSTOMER")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c"),
		@NamedQuery(name = "Customer.findByCid", query = "SELECT c FROM Customer c WHERE c.cid = :cid"),
		@NamedQuery(name = "Customer.findByCname", query = "SELECT c FROM Customer c WHERE c.cname = :cname"),
		@NamedQuery(name = "Customer.findByContactno", query = "SELECT c FROM Customer c WHERE c.contactno = :contactno"),
		@NamedQuery(name = "Customer.findByBirthdate", query = "SELECT c FROM Customer c WHERE c.birthdate = :birthdate"),
		@NamedQuery(name = "Customer.findByEmailid", query = "SELECT c FROM Customer c WHERE c.emailid = :emailid") })
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	// @NotNull
	@GeneratedValue
	@Column(name = "CID")
	private Integer cid;
	@Size(max = 30)
	@Column(name = "CNAME")
	private String cname;
	@Size(max = 30)
	@Column(name = "CONTACTNO")
	private String contactno;
	@Column(name = "BIRTHDATE")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthdate;
	@Size(max = 50)
	@Column(name = "EMAILID")
	private String emailid;
	@JoinColumn(name = "ACCNO", referencedColumnName = "ACCNO")
	@ManyToOne
	private Account accno;

	public Customer() {
	}

	public Customer(Integer cid) {
		this.cid = cid;
	}

	public Integer getCid() {
		return cid;
	}

	public void setCid(Integer cid) {
		this.cid = cid;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public Account getAccno() {
		return accno;
	}

	public void setAccno(Account accno) {
		this.accno = accno;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (cid != null ? cid.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Customer)) {
			return false;
		}
		Customer other = (Customer) object;
		if ((this.cid == null && other.cid != null)
				|| (this.cid != null && !this.cid.equals(other.cid))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", contactno="
				+ contactno + ", birthdate=" + birthdate + ", emailid="
				+ emailid  + "]";
	}

}
