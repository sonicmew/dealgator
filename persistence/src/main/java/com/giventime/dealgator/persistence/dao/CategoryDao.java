/**
 * 
 */
package com.giventime.dealgator.persistence.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.giventime.dealgator.persistence.model.Category;

/**
 * @author ANDROUTA
 *
 */
@Stateless
public class CategoryDao extends BaseDao<Category> {

	/**
	 * 
	 */
	public CategoryDao() {
		super(Category.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<Category> fetchCategories() {
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Category> query = criteria.createQuery(Category.class);
		query.from(Category.class);
		
		try {
			return getEntityManager().createQuery(query).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
