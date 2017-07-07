package com.ngo.server.commandhandlers;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.ngo.server.persistance.dao.MemberDAO;
import com.ngo.server.persistance.dao.NgoFactory;
import com.ngo.server.pojos.Member;
import com.ngo.server.utilities.ServerConstant;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class MemberCommandHandler implements CommandHandler {
	
	private NgoFactory ngoFactory = null;
	final static Logger logger = Logger.getLogger(MemberCommandHandler.class);
	public MemberCommandHandler(NgoFactory ngoFactory){
		this.ngoFactory = ngoFactory;
	}

	public Object executeRequest(HttpServletRequest request, Object serilaizedObject) {
		logger.info("Started executing request.");
		Object result = null;
		if (serilaizedObject instanceof Member) {
			Member member = (Member) serilaizedObject;
			String actionType = request.getParameter(ServerConstant.ACTION_TYPE);
			switch (actionType) {
			case ServerConstant.INSERT:
				result = insertAction(member);
				break;
			case ServerConstant.UPDATE:

				break;
			case ServerConstant.SELECT:

				break;
			default:
				break;
			}
		}
		return result;
	}
	
	private boolean insertAction(Member member){
		MemberDAO memberDAO = ngoFactory.getMemberDAO();
		boolean result = memberDAO.saveMember(member);
		return result;
	}

}
