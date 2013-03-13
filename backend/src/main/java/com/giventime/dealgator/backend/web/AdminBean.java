/**
 * 
 */
package com.giventime.dealgator.backend.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author ANDROUTA
 *
 */
@Named("adminBean")
@RequestScoped
public class AdminBean {

	/**
	 * 
	 */
	public AdminBean() {
		
	}
	
	public String helloAdmin() {
		return "Hello Admin!";
	}

}
