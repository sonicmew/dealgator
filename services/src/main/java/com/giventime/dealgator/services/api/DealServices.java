/**
 * 
 */
package com.giventime.dealgator.services.api;

import java.net.URL;
import java.util.List;

import com.giventime.dealgator.common.dto.DealInfo;
import com.giventime.dealgator.common.dto.SearchCriteria;

/**
 * @author ANDROUTA
 *
 */
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
	
	public void importDeals(URL feedUrl);

}
