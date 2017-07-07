package com.ngo.server.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ngo.server.commandhandlers.CommandHandler;
import com.ngo.server.persistance.dao.NgoFactory;
import com.ngo.server.utilities.FactoryProducer;
import com.ngo.server.utilities.NgoProperty;
import com.ngo.server.utilities.NgoServerHelper;
import com.ngo.server.utilities.ServerConstant;

/**
 * Servlet implementation class NgoMainController
 */
public class NgoMainController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private NgoFactory ngoFactory = null;
	final static Logger logger = Logger.getLogger(NgoMainController.class);
    /**
     * Default constructor. 
     */
    public NgoMainController() {
    	NgoProperty.loadNgoProperties();
    	ngoFactory = FactoryProducer.getFactory(ServerConstant.COMMAND_HANDLER_FACTORY);
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at:Vishwas ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("Received post request");
		response.setContentType("text/text");
        response.setCharacterEncoding( "UTF-8" );
        PrintWriter out = response.getWriter();
        List<CommandHandler> commandHandlerList = ngoFactory.getAllCommandHandlers();
        logger.info("All commandHandler loaded.");
        Object resultFromCommandHandler = null;
        for(CommandHandler commandHandler : commandHandlerList){
        	resultFromCommandHandler = commandHandler.executeRequest(request, NgoServerHelper.getSerilizedObjectFromRequest(request));
        }
        logger.info("Request executed sending response");
        out.append(resultFromCommandHandler.toString());
        out.close();
		//doGet(request, response);
	}

}
