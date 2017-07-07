package com.ngo.server.persistance.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
@Entity
@Table(name="Member")
public class MemberVO implements NgoVO{

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer Member_Id;
	@Column(name="Name")
	private String Name;
	@Column(name="email")
	private String email;
	@Column(name="Address")
	private String Address;
	@Column(name="Member_Type")
	private String Member_Type;
	@Column(name="Member_Since")
	private String Member_Since;
	@Column(name="Updated_Date")
	private String Updated_Date;
	@Column(name="Updated_By")
	private String Updated_By;
	
	public Integer getMember_Id() {
		return Member_Id;
	}
	public void setMember_Id(Integer member_Id) {
		Member_Id = member_Id;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getMember_Type() {
		return Member_Type;
	}
	public void setMember_Type(String member_Type) {
		Member_Type = member_Type;
	}
	public String getMember_Since() {
		return Member_Since;
	}
	public void setMember_Since(String member_Since) {
		Member_Since = member_Since;
	}
	public String getUpdated_Date() {
		return Updated_Date;
	}
	public void setUpdated_Date(String updated_Date) {
		Updated_Date = updated_Date;
	}
	public String getUpdated_By() {
		return Updated_By;
	}
	public void setUpdated_By(String updated_By) {
		Updated_By = updated_By;
	}



}
