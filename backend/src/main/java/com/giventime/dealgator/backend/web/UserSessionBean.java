/**
 * 
 */
package com.giventime.dealgator.backend.web;

import java.security.Principal;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.persistence.model.User;
import com.giventime.dealgator.services.api.UserServices;

/**
 * @author ANDROUTA
 *
 */
@Named("userSession")
@SessionScoped
public class UserSessionBean {

	private User user;
	
	@Inject
	private UserServices userServices;
	
	public User getUser() {
		if (user == null) {
			Principal principal = FacesContext.getCurrentInstance().getExternalContext().getUserPrincipal();
			if (principal != null) {
				user = userServices.getUserByUserId(principal.getName());
			}
		}
		return user;
	}
	
	public String getUserid() {
		if (getUser() != null) {
			return getUser().getUserid();
		}
		return "guest";
	}
	
	public String logout() {
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	    return "/welcome?faces-redirect=true";
	}
	
}
