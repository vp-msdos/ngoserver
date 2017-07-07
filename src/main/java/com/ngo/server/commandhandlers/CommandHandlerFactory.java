package com.ngo.server.commandhandlers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ngo.server.persistance.dao.MemberDAO;
import com.ngo.server.persistance.dao.NgoFactory;
import com.ngo.server.utilities.FactoryProducer;
import com.ngo.server.utilities.ServerConstant;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class CommandHandlerFactory extends NgoFactory{
	
	private List<CommandHandler> listOfCommandHandlers = null;
	public CommandHandlerFactory() {
		NgoFactory ngoFactory = FactoryProducer.getFactory(ServerConstant.NGO_DAO_FACTORY);
		listOfCommandHandlers = new ArrayList<CommandHandler>();
		//Add all commandHandlers in list while initializing factory
		listOfCommandHandlers.add(new MemberCommandHandler(ngoFactory));
	}

	@Override
	public MemberDAO getMemberDAO() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommandHandler> getAllCommandHandlers() {
		return Collections.unmodifiableList(listOfCommandHandlers);
	}
	
	
}
