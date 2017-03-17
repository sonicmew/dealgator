/**
 * 
 */
package com.giventime.dealgator.services.impl;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.giventime.dealgator.persistence.dao.DealsDao;
import com.giventime.dealgator.persistence.dao.UsersDao;
import com.giventime.dealgator.persistence.model.User;
import com.giventime.dealgator.services.api.UserServices;

/**
 * @author ANDROUTA
 *
 */
@Stateless
public class UserServicesImpl implements UserServices {

	@Inject
	private UsersDao usersDao;
	
	/* (non-Javadoc)
	 * @see com.giventime.dealgator.services.api.UserServices#getUserByUserId(java.lang.String)
	 */
	@Override
	public User getUserByUserId(String userid) {
		return usersDao.byUserId(userid);
	}

}
