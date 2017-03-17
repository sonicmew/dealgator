package com.giventime.dealgator.services.api;

import javax.ejb.Local;

import com.giventime.dealgator.persistence.model.User;

@Local
public interface UserServices {

	User getUserByUserId(String userid);
	
}
