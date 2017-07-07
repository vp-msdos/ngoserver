package com.ngo.server.pojos;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class Member {
	private String name;
	private String email;
	private String address;
	private String memberType;
	private String memberSince;
	private String updatedBy;
	private String updatedDate;
	private Integer id;
	
	public Member(){}
	public Member(String name,String email,String address,String memberType,String updatedBy){
		this.name = name;
		this.email = email;
		this.address = address;
		this.memberType = memberType;
		this.updatedBy = updatedBy;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMemberType() {
		return memberType;
	}
	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}
	public String getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getMemberSince() {
		return memberSince;
	}
	public void setMemberSince(String memberSince) {
		this.memberSince = memberSince;
	}
	public String getUpdatedDate() {
		return updatedDate;
	}
	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	

}
