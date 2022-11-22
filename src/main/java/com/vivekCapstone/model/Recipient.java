package com.vivekCapstone.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="recipients")
public class Recipient {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false, length = 30)
	private String rname;
	
	@Column(nullable=false, unique=true, length = 10)
	private String acnum;
	
	@Column(nullable=false)
	private String bcurrency;
	
	@Column(nullable=false)
	private String country;
	
	@Column(nullable=false)
	private String swift;
	
	@Column(nullable=false)
	private String bic;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getRname() {
		return rname;
	}

	public void setRname(String rname) {
		this.rname = rname;
	}

	public String getAcnum() {
		return acnum;
	}

	public void setAcnum(String acnum) {
		this.acnum = acnum;
	}

	public String getBcurrency() {
		return bcurrency;
	}

	public void setBcurrency(String bcurrency) {
		this.bcurrency = bcurrency;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}
	
	
	

}
