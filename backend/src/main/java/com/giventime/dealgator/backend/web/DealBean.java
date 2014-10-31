/**
 * 
 */
package com.giventime.dealgator.backend.web;

import javax.annotation.PostConstruct;
import javax.faces.bean.RequestScoped;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.SearchCriteria;
import com.giventime.dealgator.services.api.DealServices;

/**
 * @author ANDROUTA
 *
 */
@Named("dealBean")
@RequestScoped
public class DealBean extends AdminBean<DealInfo> {
	
	@Inject
	private DealServices dealServices;
	
	@PostConstruct
	private void init() {
		setDataModel(new ListDataModel<DealInfo>(dealServices.searchDeals(new SearchCriteria())));
	}

	/* (non-Javadoc)
	 * @see com.giventime.dealgator.backend.web.AdminBean#save()
	 */
	@Override
	public void save() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.giventime.dealgator.backend.web.AdminBean#revert()
	 */
	@Override
	public void revert() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.giventime.dealgator.backend.web.AdminBean#update()
	 */
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see com.giventime.dealgator.backend.web.AdminBean#delete()
	 */
	@Override
	public void delete() {
		// TODO Auto-generated method stub

	}

}
