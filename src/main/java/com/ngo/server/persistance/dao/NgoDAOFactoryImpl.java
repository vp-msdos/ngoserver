package com.ngo.server.persistance.dao;

import java.util.List;

import com.ngo.server.commandhandlers.CommandHandler;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class NgoDAOFactoryImpl extends NgoFactory{

	@Override
	public MemberDAO getMemberDAO() {
		return new MemberDAOImpl();
	}

	@Override
	public List<CommandHandler> getAllCommandHandlers() {
		// TODO Auto-generated method stub
		return null;
	}



}
