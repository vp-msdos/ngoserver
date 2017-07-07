package com.ngo.server.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.google.gson.Gson;
import com.ngo.server.persistance.vo.MemberVO;
import com.ngo.server.pojos.Member;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class NgoServerHelper {
	
	public static MemberVO parseMemberToMemberVO(Member member){
		MemberVO memberVO = new MemberVO();
		memberVO.setName(member.getName());
		memberVO.setEmail(member.getEmail());
		memberVO.setAddress(member.getAddress());
		memberVO.setMember_Type(member.getMemberType());
		SimpleDateFormat fmt = new SimpleDateFormat("dd-MM-yyyy");
		Date currentDate = new Date();
		String memberSince = fmt.format(currentDate);
		memberVO.setMember_Since(memberSince);
		memberVO.setUpdated_By(member.getUpdatedBy());
		memberVO.setUpdated_Date(memberSince);
		return memberVO;
	}
	
	public static Member parseMemberVOToMember(MemberVO memberVO){
		Member member = new Member();
		return member;
	}
	
	public static Object getSerilizedObjectFromRequest(HttpServletRequest request){
		Gson gson = new Gson();
		String json = request.getParameter(ServerConstant.OBJ);
		String objectName = request.getParameter(ServerConstant.OBJECT_NAME);
		Class loadedPojo = null;
		try {
			loadedPojo= Class.forName(NgoProperty.getProperty(ServerConstant.POJO_PATH).toString()+objectName);
			System.out.println(loadedPojo.getName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Object serilizedObject = gson.fromJson(json,loadedPojo);
		return serilizedObject;
	}

}
