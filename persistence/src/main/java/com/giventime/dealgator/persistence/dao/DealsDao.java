/**
 * 
 */
package com.giventime.dealgator.persistence.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.giventime.dealgator.common.dto.SearchCriteria;
import com.giventime.dealgator.persistence.model.Deal;

/**
 * @author ANDROUTA
 *
 */
@Stateless
public class DealsDao extends BaseDao<Deal> {

	/**
	 * Default constructor.
	 */
	public DealsDao() {
		super(Deal.class);
	}
	
	/**
	 * 
	 */
	public DealsDao(EntityManager entityManager, Class<Deal> entityClass) {
		super(entityManager, entityClass);
	}

	/**
	 * 
	 * @param criteria
	 * @return
	 */
	public List<Deal> searchDeals(SearchCriteria searchCriteria) {
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Deal> query = criteria.createQuery(Deal.class);
		
		Root<Deal> deal_ = query.from(Deal.class);
		
//		for (String searchTerm : searchCriteria.getSearchTerms()) {
//			query.where(criteria.like(criteria.upper(deal_.get(Deal_.title)), searchTerm));
//		}
		
		try {
			return getEntityManager().createQuery(query).getResultList();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/**
	 * 
	 * @param deal
	 */
	public void addDeal(Deal deal) {
		getEntityManager().persist(deal);
	}
	
}
