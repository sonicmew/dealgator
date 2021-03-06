/**
 * 
 */
package com.giventime.dealgator.common.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ANDROUTA
 *
 */
public class CategoryGroupInfo implements EntityInfo {

	private Long id;
	private String name;
	private boolean enabled;
	private List<CategoryInfo> categories = new ArrayList<CategoryInfo>();
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the enabled
	 */
	public boolean isEnabled() {
		return enabled;
	}

	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	/**
	 * @return the categories
	 */
	public List<CategoryInfo> getCategories() {
		return categories;
	}

	/**
	 * @param categories the categories to set
	 */
	public void setCategories(List<CategoryInfo> categories) {
		this.categories = categories;
	}
	

	
}
