/**
 * 
 */
package com.giventime.dealgator.services.api;

import java.net.URL;
import java.util.List;

import javax.ejb.Local;

import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.SearchCriteria;

/**
 * @author ANDROUTA
 *
 */
@Local
public interface DealServices {

	/**
	 * 
	 * @param dealId
	 * @return
	 */
	public DealInfo getDealById(long dealId);
	
	/**
	 * 
	 * @param searchCriteria
	 * @return
	 */
	public List<DealInfo> searchDeals(SearchCriteria searchCriteria);
	
	public void deleteAllDeals();
	
	public void importDeals(URL feedUrl);

}
