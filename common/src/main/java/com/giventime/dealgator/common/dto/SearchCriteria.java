/**
 * 
 */
package com.giventime.dealgator.common.dto;

import java.util.List;

/**
 * @author ANDROUTA
 *
 */
public class SearchCriteria {

	private List<String> searchTerms;
	private CategoryGroupInfo category;

	/**
	 * 
	 */
	public SearchCriteria() {
	}
	
	/**
	 * 
	 * @return
	 */
	public List<String> getSearchTerms() {
		return searchTerms;
	}

	/**
	 * 
	 * @param searchTerms
	 */
	public void setSearchTerms(List<String> searchTerms) {
		this.searchTerms = searchTerms;
	}

	/**
	 * @return the category
	 */
	public CategoryGroupInfo getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(CategoryGroupInfo category) {
		this.category = category;
	}
	
}
