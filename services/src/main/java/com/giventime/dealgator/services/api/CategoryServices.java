/**
 * 
 */
package com.giventime.dealgator.services.api;

import java.util.List;

import com.giventime.dealgator.common.SuppliedDataException;
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
	List<CategoryInfo> getAllCategories();
	
	/**
	 * 
	 * @return
	 */
	Long getCategoryIdFor(String categoryStr) throws SuppliedDataException;
	
}
