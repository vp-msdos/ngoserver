package com.ngo.server.persistance.vo;

import java.io.Serializable;
/**
 * 
 * @author VISHWAS SINGH
 *
 */
public interface NgoVO extends Serializable {
	
	String getUpdated_Date();
	void setUpdated_Date(String updated_Date);
	String getUpdated_By();
	void setUpdated_By(String updated_By);
}
