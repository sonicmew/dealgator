/**
 * 
 */
package com.giventime.dealgator.services.api;

import java.util.List;

import com.giventime.dealgator.common.dto.CategoryGroupInfo;

/**
 * @author ANDROUTA
 *
 */
public interface CategoryServices {

	/**
	 * 
	 * @return
	 */
	public List<CategoryGroupInfo> getAllCategoryGroups();
	
}
