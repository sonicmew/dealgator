/**
 * 
 */
package com.giventime.dealgator.persistence.dao;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.giventime.dealgator.persistence.model.User;
import com.giventime.dealgator.persistence.model.User_;

/**
 * @author ANDROUTA
 *
 */
@Named("usersDao")
@Dependent
public class UsersDao extends BaseDao<User> {

	public UsersDao() {
		super(User.class);
	}
	
	public UsersDao(EntityManager entityManager, Class<User> entityClass) {
		super(entityManager, entityClass);
	}
	
	public User byUserId(String userid) {
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<User> query = criteria.createQuery(User.class);
		
		Root<User> user_ = query.from(User.class);		
		query.where(criteria.equal(user_.get(User_.userid), userid));
		
		try {
			return getEntityManager().createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

}
