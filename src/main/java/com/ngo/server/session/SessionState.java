package com.ngo.server.session;
/**
 * 
 * @author VISHWAS SINGH
 *
 */
public interface SessionState {
	
	void startSession();
	void stopSession();
	boolean isStart();

}
