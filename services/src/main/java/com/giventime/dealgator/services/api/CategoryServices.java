/**
 * 
 */
package com.giventime.dealgator.services.api;

import java.util.List;

import com.giventime.dealgator.common.dto.CategoryInfo;

/**
 * @author ANDROUTA
 *
 */
public interface CategoryServices {

	/**
	 * 
	 * @return
	 */
	public List<CategoryInfo> getAllCategories();
	
}
