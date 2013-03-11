/**
 * 
 */
package com.giventime.dealgator.web;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.services.DealServices;

/**
 * @author sonicmew
 *
 */
@Named("dealsBean")
@RequestScoped
public class DealsBean extends BaseBean {

	@Inject
	private DealServices dealServices;
	
	private SearchCriteria searchCriteria = new SearchCriteria();
	
	/**
	 * 
	 */
	public DealsBean() {
		
	}

	/*
	 * (non-Javadoc)
	 * @see com.giventime.dealgator.web.BaseBean#getBeanName()
	 */
	@Override
	public String getBeanName() {
		return DealsBean.class.getName();
	}
	
	/**
	 * 
	 */
	public void searchDeals() {
		dealServices.searchDeals(getSearchCriteria());
	}

	/**
	 * @return the searchCriteria
	 */
	public SearchCriteria getSearchCriteria() {
		return searchCriteria;
	}

	/**
	 * @param searchCriteria the searchCriteria to set
	 */
	public void setSearchCriteria(SearchCriteria searchCriteria) {
		this.searchCriteria = searchCriteria;
	}

}
