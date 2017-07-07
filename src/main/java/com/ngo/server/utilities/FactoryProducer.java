package com.ngo.server.utilities;

import com.ngo.server.persistance.dao.NgoDAOFactoryImpl;
import com.ngo.server.persistance.dao.NgoFactory;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class FactoryProducer {
	
	public static NgoFactory getFactory(String factoryName){
		NgoFactory ngoFactory = null;
		Class loadedClass = null;
		try {
			loadedClass = Class.forName(factoryName);
			ngoFactory = (NgoFactory) loadedClass.newInstance();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ngoFactory;
		/*if(factoryName.equals(ServerConstant.MEMBER_DAO_FACTORY)){
			
			ngoFactory = new NgoDAOFactoryImpl();
		}
		return ngoFactory;*/
	}

}
