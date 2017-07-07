package com.ngo.server.persistance.dao;

import java.util.List;

import com.ngo.server.commandhandlers.CommandHandler;

public abstract class NgoFactory {
	
	public abstract MemberDAO getMemberDAO();
	public abstract List<CommandHandler> getAllCommandHandlers();

}
