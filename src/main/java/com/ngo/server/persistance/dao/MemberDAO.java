package com.ngo.server.persistance.dao;

import com.ngo.server.pojos.Member;
/**
 * 
 * @author VISHWAS SINGH
 *
 */
public interface MemberDAO {
	
	boolean saveMember(Member member);
	Member fetchMemberByEmail(String emailId);
	Member fetchMemberById(Integer id);
}
