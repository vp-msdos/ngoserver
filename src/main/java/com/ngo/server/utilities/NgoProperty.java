package com.ngo.server.utilities;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 
 * @author VISHWAS SINGH
 *
 */
public class NgoProperty {
	private static Properties props;
	static{
		props = new Properties();
	}
	
	public static void loadNgoProperties(){
				InputStream inputStream = NgoProperty.class.getResourceAsStream("/ngoConfigServer.properties");
				try {
					props.load(inputStream);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	/**
	 * Get property from ngoconfig.properties file
	 * @param key
	 * @return
	 */
	public static Object getProperty(String key){
		return props.getProperty(key);
	}
	

}
