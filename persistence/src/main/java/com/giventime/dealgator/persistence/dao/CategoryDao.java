/**
 * 
 */
package com.giventime.dealgator.persistence.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.apache.commons.lang.StringUtils;

import com.giventime.dealgator.common.SuppliedDataException;
import com.giventime.dealgator.persistence.model.Category;
import com.giventime.dealgator.persistence.model.Category_;

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

	public void addCategory(Category category) {
		getEntityManager().persist(category);
	}
	
	/**
	 * 
	 * @return
	 */
	public List<Category> fetchCategories() {
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Category> query = criteria.createQuery(Category.class);
		query.from(Category.class);
		return getEntityManager().createQuery(query).getResultList();
	}
	
	/**
	 * Returns the category Id for the given category name.
	 * @param categoryStr
	 * @return
	 * @throws SuppliedDataException
	 */
	public Long getCategoryIdFor(String categoryStr) throws SuppliedDataException {
		if (StringUtils.isBlank(categoryStr)) {
			throw new SuppliedDataException("CategoryStr is empty or null...");
		}
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Category> query = criteria.createQuery(Category.class);
		Root<Category> root = query.from(Category.class);		
		query.where(criteria.equal(criteria.lower(root.get(Category_.name)), categoryStr.toLowerCase()));
		try {
			Category category = getEntityManager().createQuery(query).getSingleResult();	
			return category.getId();
		} catch (NoResultException e) {
			return null;
		}
	}

}
