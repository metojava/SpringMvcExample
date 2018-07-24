/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

//import org.hibernate.annotations.Proxy;
import org.springframework.format.annotation.DateTimeFormat;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "ACCOUNT")
// @Proxy(lazy = false)
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Account.findAll", query = "SELECT a FROM Account a"),
		@NamedQuery(name = "Account.findByAccno", query = "SELECT distinct a FROM Account a left join fetch a.customerList c WHERE a.accno = :accno"),
		@NamedQuery(name = "Account.findByAcctype", query = "SELECT a FROM Account a WHERE a.acctype = :acctype"),
		@NamedQuery(name = "Account.findByAccopeningdt", query = "SELECT a FROM Account a WHERE a.accopeningdt = :accopeningdt"),
		@NamedQuery(name = "Account.findByCurrbalance", query = "SELECT a FROM Account a WHERE a.currbalance = :currbalance") })
public class Account implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	// @NotNull
	@GeneratedValue
	@Column(name = "ACCNO")
	private Integer accno;
	@Size(max = 30)
	@Column(name = "ACCTYPE")
	private String acctype;
	@Column(name = "ACCOPENINGDT")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date accopeningdt;
	// @Max(value=?) @Min(value=?)//if you know range of your decimal fields
	// consider using these annotations to enforce field validation
	@Column(name = "CURRBALANCE")
	private Double currbalance;
	@OneToMany(mappedBy = "accno", fetch = FetchType.EAGER, orphanRemoval = true)
	@Cascade(CascadeType.ALL)
	private List<Customer> customerList;

	public Account() {
	}

	public Account(Integer accno) {
		this.accno = accno;
	}

	public Integer getAccno() {
		return accno;
	}

	public void setAccno(Integer accno) {
		this.accno = accno;
	}

	public String getAcctype() {
		return acctype;
	}

	public void setAcctype(String acctype) {
		this.acctype = acctype;
	}

	public Date getAccopeningdt() {
		return accopeningdt;
	}

	public void setAccopeningdt(Date accopeningdt) {
		this.accopeningdt = accopeningdt;
	}

	public Double getCurrbalance() {
		return currbalance;
	}

	public void setCurrbalance(Double currbalance) {
		this.currbalance = currbalance;
	}

	@XmlTransient
	public List<Customer> getCustomerList() {
		return customerList;
	}

	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (accno != null ? accno.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Account)) {
			return false;
		}
		Account other = (Account) object;
		if ((this.accno == null && other.accno != null)
				|| (this.accno != null && !this.accno.equals(other.accno))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Account [accno=" + accno + ", acctype=" + acctype
				+ ", accopeningdt=" + accopeningdt + ", currbalance="
				+ currbalance + ", customerList=" + customerList + "]";
	}

}
