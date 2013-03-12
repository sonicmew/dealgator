/**
 * 
 */
package com.giventime.dealgator.web;

import java.util.List;

import com.giventime.dealgator.model.Category;

/**
 * @author ANDROUTA
 *
 */
public class SearchCriteria {

	private List<String> searchTerms;
	private Category category;

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
	public Category getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(Category category) {
		this.category = category;
	}
	
}
