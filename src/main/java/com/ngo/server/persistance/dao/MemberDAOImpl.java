package com.ngo.server.persistance.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import com.ngo.server.persistance.vo.MemberVO;
import com.ngo.server.pojos.Member;
import com.ngo.server.utilities.NgoServerHelper;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class MemberDAOImpl implements MemberDAO{

	private SessionFactory sessionFactory = null;
	
	public MemberDAOImpl(){
		sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
	}

	public Member fetchMemberById(Integer id) {
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		MemberVO memberVo= (MemberVO) session.get(MemberVO.class, id);
		Member memberRes = NgoServerHelper.parseMemberVOToMember(memberVo);
		transaction.commit();
		session.close();
		return memberRes;
	}
	
	public Member fetchMemberByEmail(String emailId){
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		Criteria critera = session.createCriteria(MemberVO.class);
		List<MemberVO> memberVo = (List<MemberVO>) critera.add(Restrictions.eq("email",emailId)).list();
		Member member = NgoServerHelper.parseMemberVOToMember(memberVo.get(0));
		transaction.commit();
		session.close();
		return member;
		
	}
	

	public boolean saveMember(Member member) {
		MemberVO memberVo = NgoServerHelper.parseMemberToMemberVO(member);
		Session session = sessionFactory.openSession();
		Transaction transaction = session.beginTransaction();
		session.persist(memberVo);
		transaction.commit();
		session.close();
		return true;
	}

}
