/**
 * 
 */
package com.giventime.dealgator.frontend.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.SearchCriteria;
import com.giventime.dealgator.services.api.DealServices;

/**
 * @author sonicmew
 *
 */
@Named("dealsBean")
@RequestScoped
public class DealsBean extends BaseBean {

	@Inject
	private DealServices dealServices;	
	private DataModel<DealInfo> dataModel;
	
	private SearchCriteria searchCriteria = new SearchCriteria();
	
	/**
	 * 
	 */
	public DealsBean() {
		
	}

	@PostConstruct
	private void init() {
		setDataModel(new ListDataModel<DealInfo>(dealServices.searchDeals(new SearchCriteria())));
	}
	
	/**
	 * @return the dataModel
	 */
	public DataModel<DealInfo> getDataModel() {
		return dataModel;
	}

	/**
	 * @param dataModel the dataModel to set
	 */
	public void setDataModel(DataModel<DealInfo> dataModel) {
		this.dataModel = dataModel;
	}
	
	/*
	 * (non-Javadoc)
	 * @see com.giventime.dealgator.frontend.web.BaseBean#getBeanName()
	 */
	@Override
	public String getBeanName() {
		return DealsBean.class.getName();
	}
	
	/**
	 * 
	 */
	public void searchDeals() {
		setDataModel(new ListDataModel<DealInfo>(dealServices.searchDeals(getSearchCriteria())));
	}

	public String view(Long dealId) {
		return "/view.xhtml?dealId="+dealId;
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
