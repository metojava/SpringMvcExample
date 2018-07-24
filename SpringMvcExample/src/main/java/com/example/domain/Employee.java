/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.example.validators.ContactNumber;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedQueries({
		@NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
		@NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
		@NamedQuery(name = "Employee.findByName", query = "SELECT e FROM Employee e WHERE e.name = :name"),
		@NamedQuery(name = "Employee.findByContactno", query = "SELECT e FROM Employee e WHERE e.contactno = :contactno"),
		@NamedQuery(name = "Employee.findByEmailid", query = "SELECT e FROM Employee e WHERE e.emailid = :emailid"),
		@NamedQuery(name = "Employee.findByRole", query = "SELECT e FROM Employee e WHERE e.role = :role") })
public class Employee implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Basic(optional = false)
	//@NotNull
	@GeneratedValue
	@Column(name = "ID")
	private Integer id;
	@NotEmpty
	@Size(max = 30)
	@Column(name = "NAME")
	private String name;
	@NotEmpty
	@Size(max = 30)
	@Column(name = "CONTACTNO")
	@ContactNumber
	private String contactno;
	@NotEmpty
	@Size(max = 50)
	@Column(name = "EMAILID")
	private String emailid;
	@NotEmpty
	@Size(max = 30)
	@Column(name = "ROLE")
	private String role;

	public Employee() {
	}

	public Employee(String name, String contactno, String emailid, String role) {
		this.id = id;
		this.name = name;
		this.contactno = contactno;
		this.emailid = emailid;
		this.role = role;
	}

	public Employee(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContactno() {
		return contactno;
	}

	public void setContactno(String contactno) {
		this.contactno = contactno;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are
		// not set
		if (!(object instanceof Employee)) {
			return false;
		}
		Employee other = (Employee) object;
		if ((this.id == null && other.id != null)
				|| (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", contactno="
				+ contactno + ", emailid=" + emailid + ", role=" + role + "]";
	}

	// @Override
	// public String toString() {
	// return "com.example.Employee[ id=" + id + " ]";
	// }

}
