package com.vivekCapstone.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@Column(nullable=false, unique=true, length=45)
	@Email(message = "Email address is not valid !!")
	private String email;
	
	@Column(nullable=false, length = 30)
	@Size(min = 4, message = "Username must be min of 4 characters !!")
	private String name;
	
	@Column(nullable=false, unique=true, length = 10)
	private String accountNo;	
	
	@Column(nullable=false, unique=true, length = 10)
	private String mobileNo;
	
	@Column(nullable=false, length=64)
	private String password;

	public Users() {
		super();
		
	}

	

	public Users(String name, String accountNo, String email, String mobileNo, String password,
			String confirmpassword) {
		super();
		this.name = name;
		this.accountNo = accountNo;
		this.email = email;
		this.mobileNo = mobileNo;
		this.password = password;
		;
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}



	public String getAccountNo() {
		return accountNo;
	}



	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}


	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
		String encryptedPwd = pwdEncoder.encode(password);
		this.password = encryptedPwd;
	}
	

	
	public void setNewPassword(String password) {
//		BCryptPasswordEncoder pwdEncoder = new BCryptPasswordEncoder();
//		String encryptedPwd = pwdEncoder.encode(password);
		this.password = password;
	}


	@Override
	public String toString() {
		return "Users [name=" + name + ", accountNo=" + accountNo + ", email=" + email + ", mobileNo=" + mobileNo
				+ ", password=" + password + ",]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(accountNo,email, mobileNo, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Users other = (Users) obj;
		return Objects.equals(accountNo, other.accountNo) && 
				Objects.equals(email, other.email) && Objects.equals(mobileNo, other.mobileNo)
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
				
	}
	
}
