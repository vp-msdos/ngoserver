package com.ngo.server.session;

import java.io.Serializable;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public final class Session implements Serializable,SessionState {
	
	private static final long serialVersionUID = 1020175273763175269L;
	private String userName =null;
	private static volatile Session session = null;
	private String sessionState = null;
	private Session(){}
	
	public static Session getInstance(){
		if(session == null){
			synchronized (Session.class) {
				if(session == null){
					session = new Session();
				}
			}
		}
		return session;
	}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	private void cleanUpSession(){
		this.setUserName(null);
		session = null;
	}

	public void startSession() {
		this.sessionState = "START";
		
	}

	public void stopSession() {
		this.sessionState = "STOP";
		cleanUpSession();
		
	}

	@Override
	public boolean isStart() {
		if(this.sessionState.equals("START")){
			return true;
		}
		return false;
	
	}

}
