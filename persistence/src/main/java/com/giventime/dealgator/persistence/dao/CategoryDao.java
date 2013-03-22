/**
 * 
 */
package com.giventime.dealgator.persistence.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import com.giventime.dealgator.persistence.model.CategoryGroup;

/**
 * @author ANDROUTA
 *
 */
@Stateless
public class CategoryDao extends BaseDao<CategoryGroup> {

	/**
	 * 
	 */
	public CategoryDao() {
		super(CategoryGroup.class);
	}

	/**
	 * 
	 * @return
	 */
	public List<CategoryGroup> fetchCategoryGroups() {
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<CategoryGroup> query = criteria.createQuery(CategoryGroup.class);
		query.from(CategoryGroup.class);
		
		try {
			return getEntityManager().createQuery(query).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
}
