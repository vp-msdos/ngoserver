package com.ngo.server.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.ngo.server.utilities.NgoProperty;
import com.ngo.server.utilities.ServerConstant;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class ConnectionPool {

	private BlockingQueue<Connection> queueConnection;
	private static ConnectionPool connectionPool;
	private final int INITIAL_CAPACITY = 20;

	private ConnectionPool() {
		queueConnection = new LinkedBlockingQueue<Connection>(INITIAL_CAPACITY);
		initConnectionPool();
	}

	private void initConnectionPool() {
		for (int i = 0; i < INITIAL_CAPACITY; i++) {
			try {
				Class.forName(NgoProperty.getProperty(ServerConstant.MY_SQL_DRIVER).toString());
				Connection connection = DriverManager.getConnection(
						NgoProperty.getProperty(ServerConstant.MY_SQL_URL).toString(),
						NgoProperty.getProperty(ServerConstant.MY_SQL_UNAME).toString(),
						NgoProperty.getProperty(ServerConstant.MY_SQL_PWD).toString());
				queueConnection.add(connection);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	
	public Connection getCononnection(){
		Connection con = null;
		try {
			con = queueConnection.take();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
	
	public void releaseConnection(Connection connection){
		queueConnection.offer(connection);
	}

	public static ConnectionPool getInstance() {
		if (connectionPool == null) {
			synchronized (ConnectionPool.class) {
				if (connectionPool == null) {
					connectionPool = new ConnectionPool();
				}
			}
		}
		return connectionPool;
	}

}
