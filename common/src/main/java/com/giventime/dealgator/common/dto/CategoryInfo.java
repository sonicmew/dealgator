/**
 * 
 */
package com.giventime.dealgator.common.dto;

/**
 * @author ANDROUTA
 *
 */
public class CategoryInfo implements EntityInfo {

	private Long id;
	private String name;
	private boolean enabled;
	private CategoryGroupInfo categoryGroupInfo;
	
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
	 * @return the categoryGroupInfo
	 */
	public CategoryGroupInfo getCategoryGroupInfo() {
		return categoryGroupInfo;
	}

	/**
	 * @param categoryGroupInfo the categoryGroupInfo to set
	 */
	public void setCategoryGroupInfo(CategoryGroupInfo categoryGroupInfo) {
		this.categoryGroupInfo = categoryGroupInfo;
	}
	
}
