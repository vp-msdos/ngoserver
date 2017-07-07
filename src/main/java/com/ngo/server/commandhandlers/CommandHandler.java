package com.ngo.server.commandhandlers;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public interface CommandHandler {
	
	Object executeRequest(HttpServletRequest request, Object serilaizedObject);

}
