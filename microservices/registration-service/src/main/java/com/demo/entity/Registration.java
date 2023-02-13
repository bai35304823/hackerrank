package com.demo.entity;

import java.sql.Timestamp;

//package com.demo.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "REGISTRATIONS")

public class Registration {
	@Column(name = "ADMIN_NAME", nullable = false, length = 25)
	String adminName;
	@Id
	@Column(name = "EMAIL", nullable = false, length = 25)
	//@Email(regexp = "^[\\\\w-\\\\.]+@([\\\\w-]+\\\\.)+[\\\\w-]{2,4}$")
	String email;
	String phone;
	String password;
	byte[] salt;

	private long accessCount;
	private Timestamp accessTime;
	
	Registration() {
		super();
	}

	public byte[] getSalt() {
		return salt;
	}

	public void setSalt(byte[] salt) {
		this.salt = salt;
	}

	public long getAccessCount() {
		return accessCount;
	}

	public void setAccessCount(long accessCount) {
		this.accessCount = accessCount;
	}

	public Timestamp getAccessTime() {
		return accessTime;
	}

	public void setAccessTime(Timestamp accessTime) {
		this.accessTime = accessTime;
	}

	public Registration(String adminName, String email, String phone, String password) {
		this.adminName = adminName;
		this.email = email;
		this.phone = phone;
		this.password = password;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Registration{" + "adminName='" + adminName + '\'' + ", email='" + email + '\'' + ", phone='" + phone
				+ '\'' + ", password='" + password + '\'' + '}';
	}
}
