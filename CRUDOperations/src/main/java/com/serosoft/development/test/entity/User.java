package com.serosoft.development.test.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import java.io.Serializable;

/**
 * @author Nikhil Sanghvi
 * 
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1173938882404918354L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column
	private String firstName;

	@Column
	private String lastName;

	@Column
	private String sex;

	@Column
	private String emailId;

	@Column
	private String phoneNo;

	@Column
	private String address;

	public User() {
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	// @Override
	// public String toString() {
	// return "User{" + "id=" + id + ", firstName='" + firstName + '\'' + ",
	// lastName=" + lastName +'\'' + ", sex=" + sex
	// +'\'' + ", emailId=" + emailId +'\'' + ", phoneNo=" + phoneNo +'\'' + ",
	// address=" + address +'\'' + '}';
	// }
	
	 @Override
	    public String toString() {
	        return "User{" +
	                "id=" + id +
	                ", firstName='" + firstName + '\'' +
	                ", lastName='" + lastName + '\'' +
	                ", sex='" + sex + '\'' +
	                ", emailId='" + emailId + '\'' +
	                ", phoneNo='" + phoneNo + '\'' +
	                ", address='" + address + '\'' +
	                '}';
	    }
}