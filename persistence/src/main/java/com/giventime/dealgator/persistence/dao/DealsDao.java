/**
 * 
 */
package com.giventime.dealgator.persistence.dao;

import java.util.Date;
import java.util.List;

import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.giventime.dealgator.common.dto.SearchCriteria;
import com.giventime.dealgator.persistence.model.Deal;
import com.giventime.dealgator.persistence.model.Deal_;

/**
 * @author ANDROUTA
 *
 */
@Named("dealsDao")
@Dependent()
public class DealsDao extends BaseDao<Deal> {

	/**
	 * Default constructor. Required for injection.
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
	
	public void removeAll() {
		fetchAll().forEach(d -> getEntityManager().remove(d));
	}
	
	public Deal byLinkwiseProductId(String linkwiseProductId) {
		CriteriaBuilder criteria = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Deal> query = criteria.createQuery(Deal.class);
		
		Root<Deal> deal_ = query.from(Deal.class);		
		query.where(criteria.equal(deal_.get(Deal_.linkwiseProductId), linkwiseProductId));
		
		try {
			return getEntityManager().createQuery(query).getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	
	/* (non-Javadoc)
	 * @see com.giventime.dealgator.persistence.dao.IDealsDao#addDeal(com.giventime.dealgator.persistence.model.Deal)
	 */	
	public void addDeal(Deal deal) {
		System.out.println("Importing deal with linkwise id: "+deal.getLinkwiseProductId());
		Deal imported = byLinkwiseProductId(deal.getLinkwiseProductId());
		if (imported != null) {
			deal.setId(imported.getId());
			deal.getMetadata().setId(imported.getMetadata().getId());
			deal.getMetadata().setUpdateDate(new Date());
			getEntityManager().merge(deal);
		} else {
			deal.getMetadata().setImportDate(new Date());
			getEntityManager().persist(deal);
		}
	}
	
}
