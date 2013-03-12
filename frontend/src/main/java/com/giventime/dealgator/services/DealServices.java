package com.giventime.dealgator.services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.giventime.dealgator.dao.DealsDao;
import com.giventime.dealgator.model.Deal;
import com.giventime.dealgator.web.SearchCriteria;

/**
 * Session Bean implementation class DealServices
 */
@Stateless
public class DealServices {

	@Inject
	private DealsDao dealsDao;
	
    /**
     * Default constructor. 
     */
    public DealServices() {
    	
    }
    
    /**
     * 
     * @param searchCriteria
     * @return
     */
    public List<Deal> searchDeals(SearchCriteria searchCriteria) {
    	return dealsDao.searchDeals(searchCriteria);
    }

}
